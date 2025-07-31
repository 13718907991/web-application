package local.example.service.impl;

import local.example.mapper.DeptMapper;
import local.example.pojo.Dept;
import local.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> alldepts() {
        return deptMapper.allDepts();
    }

    @Override
    public void deleteDeptById(Integer id) {
        deptMapper.deleteDeptById(id);
    }

    @Override
    public void addDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.addDept(dept);
    }

    @Override
    public Dept searchDeptById(Integer id) {
        return deptMapper.searchDeptById(id);
    }

    @Override
    public void updateDeptById(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateDeptById(dept);
    }
}
