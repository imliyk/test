package com.example.springboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.Param;
import com.example.springboot.entity.Worker;

import java.util.List;

@Mapper
public interface WorkerMapper {

    @Insert("insert into `worker`(username,password,name,phone,email,position,avatar)"+
            "values (#{username},#{password},#{name},#{phone},#{email},#{position},#{avatar})")
    void insert(Worker worker);

    @Update("update `worker` set username = #{username},password=#{password},name=#{name},phone=#{phone},"+
            "email=#{email},position=#{position},avatar=#{avatar} where id = #{id}")
    void updateWorker(Worker worker);
    
    @Delete("delete from `worker` where id = #{id}")
    void deleteWorker(Integer id);

    @Select("select * from `worker`")
    List<Worker> selectAll();

    @Select("select * from `worker` where id = #{id} order by id desc")
    Worker selectById(Integer id);

    @Select("select * from `worker` where username = #{username} and name = #{name} order by id desc")
    List<Worker> selectByMore(@Param("username")String username, @Param("name")String name);

    @Select("select * from `worker` where username = #{username}")
    Worker selectByUsername(String username);
}
