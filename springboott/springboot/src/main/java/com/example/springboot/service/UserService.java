package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springboot.entity.User;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.UserMapper;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public void insertUser(User user){
            userMapper.insert(user);
    }

    public void updateUser(User user){
            userMapper.updateUser(user);
    }

    public void deleteUser(Integer id){
            userMapper.deleteUser(id);
    }

    public List<User> selectAll(){
            return userMapper.selectAll();
    }

    public User selectById(Integer id){
            return userMapper.selectById(id);
    }

    public List<User> selectByMore(String username,String name){
            return userMapper.selectByMore(username, name);
    }

     // 验证用户账户是否合法
     public User login(User user) {
        // 根据用户名查询数据库的用户信息
        User dbUser = userMapper.selectByUsername(user.getUsername());
        if (dbUser == null) {
            // 抛出一个自定义的异常
            throw new ServiceException("用户名或密码错误");
        }
        if (!user.getPassword().equals(dbUser.getPassword())) {
            throw new ServiceException("用户名或密码错误");
        }
        return dbUser;
    }

    public User register(User user) {
        User dbUser = userMapper.selectByUsername(user.getUsername());
        if (dbUser != null) {
            // 抛出一个自定义的异常
            throw new ServiceException("用户名已存在");
        }
        user.setName(user.getUsername());
        userMapper.insert(user);
        return user;
    }
}
