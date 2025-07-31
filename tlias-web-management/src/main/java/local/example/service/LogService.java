package local.example.service;

import local.example.pojo.LogPageResult;
import local.example.pojo.LogQueryParam;

public interface LogService {
    LogPageResult page(LogQueryParam logQueryParam);
}
