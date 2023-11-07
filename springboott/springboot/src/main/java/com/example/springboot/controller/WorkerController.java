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
import com.example.springboot.service.WorkerService;
import com.example.springboot.entity.Worker;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    WorkerService workerService;
    
    //新增信息

    @PostMapping("/add")
    public Result add(@RequestBody Worker worker) {
        try{
            workerService.insertWorker(worker);
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
    public Result update(@RequestBody Worker worker){
        workerService.updateWorker(worker);
        return Result.success();
    }

    //删除
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        workerService.deleteWorker(id);
        return Result.success();
    }


    //查询全部用户信息
    @GetMapping("/selectAll")
    public Result selectAll(){
        List<Worker> userlist=workerService.selectAll();
        return Result.success(userlist);
    }

    //查询全部用户信息
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id){
        Worker worker =workerService.selectById(id);
        return Result.success(worker);
    }

    @GetMapping("/selectByMore")
    public Result selectByMore(@RequestParam String username, @RequestParam String name){
        List<Worker> userlist=workerService.selectByMore(username,name);
        return Result.success(userlist);
    }
}