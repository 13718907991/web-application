package local.example.service.impl;

import local.example.mapper.EmpLogMapper;
import local.example.pojo.EmpLog;
import local.example.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired
    private EmpLogMapper empLogMapper;

    // 虽然与父类方法有事务，但是这里REQUIRES_NEW，是独立事务，不受父事务成功失败的影响
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insertLog(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }
}