
狂神的mybatis教学视频


1、mybatis的介绍
    就是一款持久层框架，用的人比较多！


2、搭建第一个mybatis小程序

    脚本：
        create table user(
        id int not null auto_increment primary key ,
        name varchar(30) default null,
        passowrd varchar(30) default null
        
        )ENGINE=INNODB DEFAULT CHARSET=UTF8MB4;


sqlSession.getMapper(UserMapper.class)的含义不清楚？
        Mybatis 读取XML配置文件后会将内容放在一个Configuration类中，SqlSessionFactoryBuilder会读取
    Configuration类中信息创建SqlSessionFactory。SqlSessionFactory创建SqlSession。（这个不重要）

    SqlSession能干什么？
      获取对应的Mapper，让映射器通过命名空间和方法名称找到对应的SQL，发送给数据库执行后返回结果。

    这个问题就先了解到这里就行，后面需要再来拿！



3、curd操作

    curd操作的关键点：拿到sqlsession对象，
再通过“sqlSession.getMapper(UserMapper.class)”让映射器通过命名空间和方法名称找到对应的SQL，发送给数据库执行后返回结果。


3.1
<insert id="addUser" parameterType="user">
insert into users (name,password) values (#{name},#{password})
</insert>
在这段话中，传入一个User对象，框架会使用反射机制将将user的各个属性自动解析出来并插入到数据库中


3.2
增删改操作需要提交事务操作!(了解到这里，后面有更多需求再回来拿！)
    但使用spring-ioc托管后,对于SqlSession的关闭无需程序员手动关闭，Spring会自动关闭


4、
map操作（具体实现原理见代码以及官方文档即可）：
    map传参数，直接在sql中取key即可；对象传参，在sql中取对象属性名即可。
    注：感觉用处不大，后面有需要再说


模糊查询：
    见代码即可


取别名以及setting属性设置：
    见官网api


映射器（mappers）的两种配置方式：
1、mapperRegistry注册方式

2、使用class类注册：
    <mappers>
        <mapper class="com.jc.mapper.UserMapper"/>
    </mappers>
注：接口必须与映射文件同名；接口必须与mapper文件在同一个文件夹


5、关于mybatis中的一些关键类
    
sqlsessionfactorybuidler:
    在创建了sqlsessionfactory之后就没有存在的必要了；
    作为一个局部变量即可。

sqlsessionfactory：
    可以理解为数据库连接池；
    一旦被创建成功就应该一直存在；所有的session都由其生产

sqlsession：
    拿到sqlsession对象，再通过“sqlSession.getMapper(UserMapper.class)”
让映射器通过命名空间和方法名称找到对应的SQL，发送给数据库执行后返回。
    用完之后就关闭即可。（不能占用资源）


6、使用resultMap简单地解决一下pojo属性名与数据表字段不一致的问题

    <resultMap id="userResultMap" type="user">
    <result column="password" property="pwd"/>
    </resultMap>

    column：代表数据库表的字段，property：代表实体类的字段；resultmap用于将两者关联起来；
    一般来讲，如果实体类的属性名与数据库表名一致的话，不需要借助resultmap（框架通过反射机制自动对应起来即可）；
所以使用resultmap时，只需要将字段不一致的属性相互映射即可。



7、日志（方便调试）
常规日志：见代码即可


log4j：
    Log4J 是 Apache 的一个开源项目（官网 http://jakarta.apache.org/log4j），通过在项目中使用 Log4J，
我们可以控制日志信息输出到控制台、文件、GUI 组件、甚至是数据库中。我们可以控制每一条日志的输出格式，通过定义
日志的输出级别，可以更灵活的控制日志的输出过程。方便项目的调试。
    Log4J 主要由 Loggers (日志记录器)、Appenders（输出端）和 Layout（日志格式化器）组成。其中 Loggers 控制
日志 的输出级别与日志是否输出；Appenders 指定日志的输出方式（输出到控制台、文件等）；Layout 控制日志信息的输出格式。


8.分页

limit：
    select * from Customer LIMIT 10;–检索前10行数据，显示1-10条数据
    select * from Customer LIMIT 1,10;–检索从第2行开始，累加10条id记录，共显示id为2…11
    select * from Customer limit 5,10;–检索从第6行开始向前加10条数据，共显示id为6,7…15
注：具体见代码


9、使用注解标注sql语句

适用于简单的情形，稍微复杂的sql语句实现还是得用.xml文件

注：具体见代码


10.mybatis1流程解析

    Eexecutor作为灵活且强大的异步执行框架，其支持多种不同类型的任务执行策略，提供了一种标准的方法将任务的提交过程和
执行过程解耦开发，基于生产者-消费者模式，其提交任务的线程相当于生产者，执行任务的线程相当于消费者，并用Runnable来表示任务，
Executor的实现还提供了对生命周期的支持，以及统计信息收集，应用程序管理机制和性能监视等机制。
注：这个类就先了解到这里，后面有需要再深入了解即可。


11、注解实现crud操作：

@Param注解的一些信息：
    基本类型或者string类型，需要加上；引用类型不用加
    在sql语句中引用的就是@Param中设定的属性名：
            @Param("**uid**") | @Select("delete from users where id =#{**uid**}")




12、搭建复杂环境实现多对一、一对多


数据库的搭建语句：
    create table teacher(
    id INTEGER NOT NULL auto_increment primary key ,
    name varchar(30) default null
    )ENGINE=INNODB DEFAULT CHARSET=UTF8MB4;
    insert into teacher(name) values ('赵老师');
    
    create table student(
    id INTEGER NOT NULL auto_increment ,
    name varchar(30) default null,
    tid INTEGER DEFAULT NULL,
    PRIMARY KEY (id),
    key fktid (tid),
    CONSTRAINT fkkid FOREIGN KEY(tid) references teacher(id)
    
    )ENGINE=INNODB DEFAULT CHARSET=UTF8MB4;
    insert into student(name,tid) values ('蒋超',1);
    insert into student(name,tid) values ('刘琪',1);
    insert into student(name,tid) values ('刘涛',1);
    insert into student(name,tid) values ('正林',1);


多对一： 多个学生关联一个老师
    子查询、联表查询（见代码即可）

一对多：一个老师关联多个学生（具体实现见代码）


关键点总结：
    多对一：
        association，关联属性（一个对象）
        javatype:与 association标签搭配使用，指定实体类的属性类型

    一对多：
        collection，集合属性（一个对象集合）
        oftype：与collection标签使用，指定集合泛型中的约束类型！
        
看视频时，狂神提到的面试高频：
    慢sql；mysql引擎；innoDB底层原理；索引（优化）





13、动态sql：根据不同的条件生成不同的sql语句。

create table blog(
id varchar(50) not null COMMENT '博客id' primary key ,
title varchar(50) not null COMMENT '博客标题',
author varchar(30) not null COMMENT '博客作者',
create_time datetime not null COMMENT '创建时间',
views INTEGER NOT NULL COMMENT '浏览量'

)ENGINE=INNODB DEFAULT CHARSET=UTF8;


if/where/set/choose/when标签的使用：见代码以及官网api介绍


如果 where 元素与你期望的不太一样，你也可以通过自定义 trim 元素来定制 where 元素的功能，
和 where 元素等价的自定义 trim 元素为：
    <trim prefix="WHERE" prefixOverrides="AND |OR ">
    ...
    </trim>
注：后面有需要再来深入了解！


foreach:具体说明见官网，，具体使用见代码


编写动态sql语句的精髓：
    将完整的sql语句写出来，然后再用标签去组合拼接即可（即使拼接有问题，通过调试反馈再回来不断修改即可。）


注：这部分是mybatis的核心内容，后面回来专门练习才行！




14、缓存 （将查询到的结果（经常被使用）存放到内存中，下次需要用的时候就直接走缓存，就不用走数据库了！）

1、何为缓存？
    存储在内存中的临时数据；用户去查询数据就不用从磁盘上去读取数据库，直接从缓存中查询，加快查询速率。

2、为什么使用缓存？
    减少与数据库的交互次数，减少系统开销，提高系统效率

3、什么样的数据使用缓存？
    经常查询且不常改变的数据


一级缓存：
    默认是开启的。只在一次sqlsession（开启到关闭的时间段）中有效。

二级缓存：
    二级缓存标签一般放在mapper文件中即可，可作用于多个session会话。其他具体原理见官方文档即可！




后面重点：
    把sql语句与mybatis结合起来重点突击一下即可！！





    