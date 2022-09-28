package com.jc.mapper;

import com.jc.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    public List<User> selectUsers();
    @Select("select * from users where id =#{uid}")
    public User selectUserById(@Param("uid") Integer id);

    @Select("insert into users (name,password) values (#{name},#{pwd})")
    public Integer addUser(User user);

    @Select("update users set name=#{name},password=#{pwd} where id=#{id}")
    public Integer updateUser(User user);

    @Select("delete from users where id =#{uid}")
    public Integer deleteUser(@Param("uid") Integer id);


//    使用map增加一个用户:
    public Integer addUser2(Map<String,Object> map);
//    模糊查询
    List<User> getUserLike(String username);

//    分页查询
    List<User> getUserByLimit(Map<String,Integer> map);


}
