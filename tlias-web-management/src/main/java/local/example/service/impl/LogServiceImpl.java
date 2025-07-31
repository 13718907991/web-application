package local.example.service.impl;

import local.example.mapper.LogMapper;
import local.example.pojo.LogPageResult;
import local.example.pojo.LogQueryParam;
import local.example.pojo.OperateLog;
import local.example.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;
    @Override
    public LogPageResult page(LogQueryParam logQueryParam) {
        logQueryParam.setOffset((logQueryParam.getPage() - 1) * logQueryParam.getPageSize());
        List<OperateLog> logList = logMapper.page(logQueryParam);
        Integer count = logMapper.count();
        return new LogPageResult(count, logList);
    }
}
