import com.jc.mapper.BlogMapper;
import com.jc.mapper.StudentMapper;
import com.jc.mapper.TeacherMapper;
import com.jc.pojo.Blog;
import com.jc.utils.IdUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.*;

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
//        拿到sqlsession对象
        SqlSession sqlsession=context.getBean("sqlSession",SqlSession.class);
//        再通过sqlsession语句拿到接口
        TeacherMapper teacherMapper=sqlsession.getMapper(TeacherMapper.class);
        StudentMapper studentMapper=sqlsession.getMapper(StudentMapper.class);
        BlogMapper blogMapper=sqlsession.getMapper(BlogMapper.class);
//        通过接口实现功能
//        Object result1=teacherMapper.selectTeachers();
//        查询学生（多个学生对一个老师）
//        Object result2=studentMapper.selectStudents();
//        查询老师（一个老师对多个学生）
        Object result3=teacherMapper.selectTeacherTwos();
//        Object result4=blogMapper.addBlog(new Blog(IdUtils.getId(),"bb","蒋超",new Date(),111));
//        动态sqlIF语句

//        Map map=new HashMap();
////        map.put("id","064f910a89c54639acc6e086cc569416");
////        map.put("title","bbc");
//        map.put("author","成超");
//        map.put("views",110);
////        Object result5=blogMapper.selectBlogsIf(map);
//
//        Object result6=blogMapper.selectBlogsChoose(map);

//        Object result7=blogMapper.updateBlog(map);
//        foreach的使用
//        ArrayList<Integer> ids=new ArrayList<Integer>();
//        ids.add(1);ids.add(2);ids.add(3);
//        map.put("ids",ids);

//        Object result8=blogMapper.selectBlogForeach(map);



//        一级缓存测试：
//        Object result9=studentMapper.selectStudents();
//        System.out.println("_____________________________");
//        Object result10=studentMapper.selectStudents();
//


        System.out.println("________END__________");
    }


    @Test
    public void testtwo(){
        System.out.println(IdUtils.getId());
        System.out.println(IdUtils.getId());
        System.out.println(IdUtils.getId());
        System.out.println("_____________________end____________________");
    }


}
