package com.jc.mapper;

import com.jc.pojo.Blog;
import com.jc.pojo.Student;
import com.jc.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

//    插入数据
    int addBlog(Blog blog);
//  if：  有条件地查询数据
    List<Blog> selectBlogsIf(Map map);
// choose ：有条件地查询语句
    List<Blog> selectBlogsChoose(Map map);
//set :更新
    Integer updateBlog(Map map);

//    foreach：有条件地查询博客
    List<Blog> selectBlogForeach(Map map);



}
