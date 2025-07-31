package local.example.service;

import local.example.pojo.Dept;

import java.util.List;

@SuppressWarnings("all")
public interface DeptService {
    List<Dept> alldepts();

    void deleteDeptById(Integer id);

    void addDept(Dept dept);

    Dept searchDeptById(Integer id);

    void updateDeptById(Dept dept);

}
