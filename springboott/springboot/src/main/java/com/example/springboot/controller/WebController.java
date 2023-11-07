package com.example.springboot.controller;

import cn.hutool.core.util.StrUtil;
import com.example.springboot.common.Result;
import com.example.springboot.entity.User;
import com.example.springboot.entity.Worker;
import com.example.springboot.service.UserService;
import com.example.springboot.service.WorkerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class WebController {

    @Resource
    UserService userService;

    @Resource
    WorkerService workerService;

    @GetMapping("/")
    public Result hello() {
        return Result.success("success");
    }

    @PostMapping("/userlogin")
    public Result login(@RequestBody User user) {
        if (StrUtil.isBlank(user.getUsername()) || StrUtil.isBlank(user.getPassword())) {
            return Result.error("数据输入不合法");
        }
        user = userService.login(user);
        return Result.success(user);
    }

    @PostMapping("/userregister")
    public Result register(@RequestBody User user) {
        if (StrUtil.isBlank(user.getUsername()) || StrUtil.isBlank(user.getPassword())) {
            return Result.error("数据输入不合法");
        }
        if (user.getUsername().length() > 10 || user.getPassword().length() > 20) {
            return Result.error("数据输入不合法");
        }
        user = userService.register(user);
        return Result.success(user);
    }

    @PostMapping("/workerlogin")
    public Result login(@RequestBody Worker worker) {
        if (StrUtil.isBlank(worker.getUsername()) || StrUtil.isBlank(worker.getPassword())) {
            return Result.error("数据输入不合法");
        }
        worker = workerService.login(worker);
        return Result.success(worker);
    }

    @PostMapping("/workerregister")
    public Result register(@RequestBody Worker worker) {
        if (StrUtil.isBlank(worker.getUsername()) || StrUtil.isBlank(worker.getPassword())) {
            return Result.error("数据输入不合法");
        }
        if (worker.getUsername().length() > 10 || worker.getPassword().length() > 20) {
            return Result.error("数据输入不合法");
        }
        worker = workerService.register(worker);
        return Result.success(worker);
    }
}
