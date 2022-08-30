package org.demo.controller;

import org.demo.entity.User;
import org.demo.result.Result;
import org.demo.service.UserService;
import org.demo.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 测试
    @GetMapping("/hello")
    public Result hello(){
        return Result.ok("hello");
    }

    // 模拟登录，用 postman(我这里用的 Apifox，两者差不多) 发送一个请求测试一下
    @PostMapping("/user/login")
    public Result test(String account, String password){

        // 这个是测试是否可以连接数据库的一个 sql，与 token 没啥关系
        User user = userService.selectByAge("18");
        Map<String, Object> map = new HashMap<>();
        String token = "";

        if (user.getAccount().equals(account) && user.getPassword().equals(password)){
            map.put("msg", "success");
            token = TokenUtils.createToken(user);
            map.put("token",  token);
            return Result.ok(map);
        } else {
            return Result.error("用户不存在");
        }

    }

    // 验证 token
    @GetMapping("/check")
    public Boolean check(HttpServletRequest request){
        System.out.println("token " + request.getHeader("token"));
        System.out.println("结果 " + TokenUtils.checkToken(request.getHeader("token")));
        return TokenUtils.checkToken(request.getHeader("token"));
    }
}
