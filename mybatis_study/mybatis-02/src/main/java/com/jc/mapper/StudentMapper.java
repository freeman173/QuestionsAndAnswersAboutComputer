package com.jc.mapper;

import com.jc.pojo.Student;
import com.jc.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface StudentMapper {


    public List<Student> selectStudents();

}
