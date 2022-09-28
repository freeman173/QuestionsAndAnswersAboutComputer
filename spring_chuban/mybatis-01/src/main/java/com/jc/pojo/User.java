package com.jc.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Alias("user")//给实体类起别名
public class User {
    private Integer id;
    private String name;
    private String pwd;

}
