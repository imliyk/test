package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springboot.entity.Worker;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.WorkerMapper;

import java.util.List;

@Service
public class WorkerService {

    @Autowired
    WorkerMapper workerMapper;

    public void insertWorker(Worker worker){
            workerMapper.insert(worker);
    }

    public void updateWorker(Worker worker){
            workerMapper.updateWorker(worker);
    }

    public void deleteWorker(Integer id){
            workerMapper.deleteWorker(id);
    }

    public List<Worker> selectAll(){
            return workerMapper.selectAll();
    }

    public Worker selectById(Integer id){
            return workerMapper.selectById(id);
    }

    public List<Worker> selectByMore(String username,String name){
            return workerMapper.selectByMore(username, name);
    }

     // 验证用户账户是否合法
     public Worker login(Worker worker) {
        // 根据用户名查询数据库的用户信息
        Worker dbUser = workerMapper.selectByUsername(worker.getUsername());
        if (dbUser == null) {
            // 抛出一个自定义的异常
            throw new ServiceException("用户名或密码错误");
        }
        if (!worker.getPassword().equals(dbUser.getPassword())) {
            throw new ServiceException("用户名或密码错误");
        }
        return dbUser;
    }

    public Worker register(Worker worker) {
        Worker dbUser = workerMapper.selectByUsername(worker.getUsername());
        if (dbUser != null) {
            // 抛出一个自定义的异常
            throw new ServiceException("用户名已存在");
        }
        worker.setName(worker.getUsername());
        workerMapper.insert(worker);
        return worker;
    }
}