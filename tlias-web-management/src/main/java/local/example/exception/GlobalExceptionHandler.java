package local.example.exception;

import local.example.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@SuppressWarnings("all")
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Result exceptionHandler(Exception e) {
        log.error("全局异常捕获：{}", e.getMessage());
        e.printStackTrace(); // 堆栈错误信息（详细）
        return Result.error("操作失败，请联系管理员");
    }
}
