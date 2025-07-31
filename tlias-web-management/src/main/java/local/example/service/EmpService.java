package local.example.service;

import local.example.pojo.*;

import java.util.List;

public interface EmpService {
    PageResult page(EmpQueryParam empQueryParam);

    void addEmp(Emp emp);

    void deleteEmpByIds(List<Integer> ids);

    Emp searchEmpById(Integer id);

    void updateEmpById(Emp emp);

    LoginInfo searchLoginInfo(Login info);
}
