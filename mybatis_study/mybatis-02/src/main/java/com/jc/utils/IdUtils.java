package com.jc.utils;

import java.util.UUID;


//获取一个随机id
public class IdUtils {

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }






}
