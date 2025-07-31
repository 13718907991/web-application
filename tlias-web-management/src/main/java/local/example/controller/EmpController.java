package local.example.controller;

import local.example.anno.LogOperation;
import local.example.pojo.Emp;
import local.example.pojo.EmpQueryParam;
import local.example.pojo.PageResult;
import local.example.pojo.Result;
import local.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    EmpService empService;

    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页条件查询员工信息, page={}, pageSize={}", empQueryParam.getPage(), empQueryParam.getPageSize());
        PageResult pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

//    @LogOperation
    @PostMapping
    public Result addEmp(@RequestBody Emp emp) {
        log.info("添加员工信息, emp={}", emp);
        empService.addEmp(emp);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result deleteEmpByIds(@PathVariable List<Integer> ids) {
        log.info("删除员工信息, ids={}", ids);
        empService.deleteEmpByIds(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result searchEmpById(@PathVariable Integer id) {
        log.info("查询单个员工信息, id={}", id);
        Emp emp = empService.searchEmpById(id);
        System.out.println(emp);
        return Result.success(emp);
    }

    @PutMapping
    public Result updateEmp(@RequestBody Emp emp) {
        log.info("修改员工信息, id={}", emp.getId());
        empService.updateEmpById(emp);
        return Result.success();
    }
}
