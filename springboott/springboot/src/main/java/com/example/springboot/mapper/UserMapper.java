package com.example.springboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.Param;
import com.example.springboot.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into `user`(username,password,name,phone,email,address,avatar)"+
            "values (#{username},#{password},#{name},#{phone},#{email},#{address},#{avatar})")

    void insert(User user);

    @Update("update `user` set username = #{username},password=#{password},name=#{name},phone=#{phone},"+
            "email=#{email},address=#{address},avatar=#{avatar} where id = #{id}")
    void updateUser(User user);
    
    @Delete("delete from `user` where id = #{id}")
    void deleteUser(Integer id);

    @Select("select * from `user`")
    List<User> selectAll();

    @Select("select * from `user` where id = #{id} order by id desc")
    User selectById(Integer id);

    @Select("select * from `user` where username = #{username} and name = #{name} order by id desc")
    List<User> selectByMore(@Param("username")String username, @Param("name")String name);

    @Select("select * from `user` where username = #{username}")
    User selectByUsername(String username);
}
