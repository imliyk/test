package com.example.springboot.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.common.Result;
import com.example.springboot.service.UserService;
import com.example.springboot.entity.User;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    
    //新增信息

    @PostMapping("/add")
    public Result add(@RequestBody User user) {
        try{
            userService.insertUser(user);
        }catch(Exception e){
            if(e instanceof SQLException){
                return Result.error("插入数据库错误");
            } else{
                return Result.error("系统错误");
            }
            
        }
        return Result.success();
    }
    

    //修改信息
    @PutMapping("/update")
    public Result update(@RequestBody User user){
        userService.updateUser(user);
        return Result.success();
    }

    //删除
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        userService.deleteUser(id);
        return Result.success();
    }


    //查询全部用户信息
    @GetMapping("/selectAll")
    public Result selectAll(){
        List<User> userlist=userService.selectAll();
        return Result.success(userlist);
    }

    //查询全部用户信息
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id){
        User user =userService.selectById(id);
        return Result.success(user);
    }

    @GetMapping("/selectByMore")
    public Result selectByMore(@RequestParam String username, @RequestParam String name){
        List<User> userlist=userService.selectByMore(username,name);
        return Result.success(userlist);
    }
}
