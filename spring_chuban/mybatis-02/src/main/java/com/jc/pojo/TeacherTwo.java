package com.jc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherTwo {
    private Integer id;
    private String name;
    private List<StudentTwo> students;

}
