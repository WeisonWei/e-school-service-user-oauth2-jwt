package com.es.user.jwt.controller;

import com.es.user.jwt.config.PassToken;
import com.es.user.jwt.config.UserLoginToken;
import com.es.user.jwt.entity.User;
import com.es.user.jwt.modle.UserVo;
import com.es.user.jwt.service.JwtService;
import com.es.user.jwt.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    public UserController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PassToken
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {
        User userDb = userService.getByName(user.getName());
        if (!userDb.getPassword().equals(user.getPassword())) {
            return ok("登录失败,密码错误");
        } else {
            String token = jwtService.createToken(userDb);
            UserVo userVo = new UserVo().setId(userDb.getId())
                    .setName(userDb.getName())
                    .setToken(token);
            return ok(userVo);
        }
    }

    @UserLoginToken
    @GetMapping("/users/{name}")
    public ResponseEntity<User> getUsers(@PathVariable("name") String name) {
        return ok(userService.getByName(name));
    }

    @PassToken
    @GetMapping("/inner/users/{name}")
    public ResponseEntity<User> getUser(@PathVariable("name") String name) {
        return ok(userService.getByName(name));
    }
}
