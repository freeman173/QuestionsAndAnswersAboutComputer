
import com.jc.mapper.UserMapper;
import com.jc.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyTest {
//    @Before:每一个测试方法之前运行
//    @Before
//    public void one(){
//
//        System.out.println("--------测试开始了！-----------");
//
//    }
//
//    @After
//    public void two(){
//
//        System.out.println("--------测试结束了！-----------");
//
//    }
//

    @Test
    public void testOne() throws ClassNotFoundException, IOException {


//spring的ioc托管了mybatis，还是舒服！
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper=context.getBean("userMapper",UserMapper.class);

//        功能1
//        userMapper.selectUsers();

//        功能2
//        userMapper.selectUserById(1);

        //        功能3
//        userMapper.addUser(new User(null,"哈哈","123456"));

        //        功能4
//        userMapper.updateUser(new User(5,"唐田","1234567"));

        //        功能4
//        userMapper.deleteUser(5);

//        功能5
//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("username","经辉");
//        map.put("password","12345678");
//        userMapper.addUser2(map);

        //        功能6
//        userMapper.getUserLike("刘");

//        功能7:limit分页查询
//        HashMap<String,Integer> map=new HashMap<String, Integer>();
//        map.put("startIndex",1);
//        map.put("pageSize",2);



//        使用注解sql语句来实现
//        Object result1=userMapper.selectUserById(1);
//        Object result2=userMapper.addUser(new User(null,"杨文","123456"));
//        Object result3=userMapper.updateUser(new User(4,"shen正林","1234567"));
//        Object result4=userMapper.deleteUser(4);


        System.out.println("________END__________");
    }

}
