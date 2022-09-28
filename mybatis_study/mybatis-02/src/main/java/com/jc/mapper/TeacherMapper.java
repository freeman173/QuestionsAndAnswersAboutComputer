package com.jc.mapper;

import com.jc.pojo.Teacher;
import com.jc.pojo.TeacherTwo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    @Select("select * from teachers")
    public Teacher selectTeachers();

    public List<TeacherTwo> selectTeacherTwos();

}
