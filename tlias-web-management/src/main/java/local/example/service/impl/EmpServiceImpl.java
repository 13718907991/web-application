package local.example.service.impl;

import local.example.mapper.EmpExprMapper;
import local.example.mapper.EmpMapper;
import local.example.pojo.*;
import local.example.service.EmpLogService;
import local.example.service.EmpService;
import local.example.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@SuppressWarnings("all")
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Autowired
    EmpExprMapper empExprMapper;

    @Autowired
    EmpLogService empLogService;

    @Override
    public PageResult page(EmpQueryParam empQueryParam) {
        empQueryParam.setOffset((empQueryParam.getPage() - 1) * empQueryParam.getPageSize());
        List<Emp> empList = empMapper.page(empQueryParam);
        return new PageResult((empMapper.count()), empList);
    }

    @Transactional
    @Override
    public void addEmp(Emp emp) {
        try {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.addEmp(emp);

            // Options (useGeneratedKeys = true, keyProperty = "id") 或 xml中的useGeneratedKeys="true" keyProperty="id"
            // 将数据库生成的id返回给emp对象的id
            Integer empId = emp.getId();
            List<EmpExpr> exprList = emp.getExprList();
            if (!CollectionUtils.isEmpty(exprList)) {
                exprList.forEach(expr -> expr.setEmpId(empId));
                empMapper.addEmpExprs(exprList);
            }
        } finally {
            empLogService.insertLog(new EmpLog(null, LocalDateTime.now(), emp.toString()));
        }
    }

    @Override
    public void deleteEmpByIds(List<Integer> ids) {
        ids.forEach(id -> {
            empMapper.deleteEmpById(id);
            empExprMapper.deleteEmpExprByEmpId(id);
        });
    }

    @Override
    public Emp searchEmpById(Integer id) {
        Emp emp = empMapper.searchEmpById(id);
        emp.setExprList(empExprMapper.searchEmpExprByEmpId(emp.getId()));
        return emp;
    }

    @Override
    public void updateEmpById(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateEmpById(emp);
        List<EmpExpr> exprList = emp.getExprList();
        empExprMapper.deleteEmpExprByEmpId(emp.getId());
        exprList.forEach(empExpr -> empExprMapper.addEmpExpr(empExpr));
    }

    @Override
    public LoginInfo searchLoginInfo(Login info) {
        LoginInfo loginInfo = empMapper.searchLoginInfo(info);
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", loginInfo.getId());
        dataMap.put("username", loginInfo.getUsername());
        String jwt = JwtUtils.generateJwt(dataMap);
        loginInfo.setToken(jwt);
        return loginInfo;
    }
}
