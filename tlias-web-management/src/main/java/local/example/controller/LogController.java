package local.example.controller;

import local.example.pojo.LogQueryParam;
import local.example.pojo.Result;
import local.example.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    @GetMapping("/page")
    public Result page(LogQueryParam logQueryParam) {
        log.info("logQueryParam: {}", logQueryParam);
        return Result.success(logService.page(logQueryParam));
    }
}
