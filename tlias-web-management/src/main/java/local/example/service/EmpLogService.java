package local.example.service;

import local.example.pojo.EmpLog;

public interface EmpLogService {
    //记录新增员工日志
    void insertLog(EmpLog empLog);
}