package com.jc.mapper;


import com.jc.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//第二种整合方式的工具类
public class UserMapperImpl implements UserMapper {

    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> selectUsers() {
        return sqlSession.getMapper(UserMapper.class).selectUsers();
    }

    public User selectUserById(Integer id) {
        return sqlSession.getMapper(UserMapper.class).selectUserById(id);
    }

    public Integer addUser(User user) {
        return sqlSession.getMapper(UserMapper.class).addUser(user);

    }

    public Integer updateUser(User user) {
        return sqlSession.getMapper(UserMapper.class).updateUser(user);
    }

    public Integer deleteUser(Integer id) {
        return sqlSession.getMapper(UserMapper.class).deleteUser(id);
    }


    public Integer addUser2(Map<String, Object> map) {

        return sqlSession.getMapper(UserMapper.class).addUser2(map);

    }

    public List<User> getUserLike(String username) {
        return sqlSession.getMapper(UserMapper.class).getUserLike(username);
    }

    public List<User> getUserByLimit(Map<String, Integer> map) {

        return sqlSession.getMapper(UserMapper.class).getUserByLimit(map);

    }


}
