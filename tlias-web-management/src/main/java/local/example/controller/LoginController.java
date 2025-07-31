package local.example.controller;

import local.example.pojo.Login;
import local.example.pojo.LoginInfo;
import local.example.pojo.Result;
import local.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Login info) {
        LoginInfo loginInfo = empService.searchLoginInfo(info);
        if (loginInfo != null) return Result.success(loginInfo);
        return Result.error("用户名或密码错误");
    }
}
