package com.bupt;

import com.bupt.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @Author czgggggggg
 * @Date 2021/12/15
 * @Description
 */
public class MybatisTest {
    SqlSession sqlSession;

    /**每一个@Test注解对应的方法 都会先执行该方法*/
    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession();//会话 connection
    }

    /**每一个@Test注解对应的方法 都会最后执行该方法*/
    @After
    public void commitAndClose(){
        if(sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }

    /**第1个查询 查询了数据记录数*/
    @Test
    public void test1() throws IOException {
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
//        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();//会话 connection
        //第一个参数：命名空间+id
        //第二个参数：object给sql语句提供参数
        int count = sqlSession.selectOne("userMapperNamespace.selectCount");
        System.out.println("count = " + count);
    }

    /**第2个查询：查询一个User*/
    @Test
    public void test2() throws IOException {
        //4条会话链接语句合并成1条
//        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml")).openSession();
        int idz = 1;
        User user = sqlSession.selectOne("userMapperNamespace.selectUserById", idz);
        System.out.println("user = " + user);
    }

    /**第3个查询：查询user的list数据*/
    @Test
    public void test3(){
        List<User> users = sqlSession.selectList("userMapperNamespace.selectUsers");
        for(User user : users){
            System.out.println(user);
        }
    }

    /**增加update*/
    @Test
    public void test4(){
        //JavaBean形式
//        User user = new User();
//        user.setUsername("wk");
//        user.setPassword("161616");
//        user.setAge(23);
//        user.setGender("male");
//        int insert = sqlSession.insert("userMapperNamespace.insertUser",user);

        //HashMap形式
        HashMap<String, Object> userMap = new HashMap<String, Object>();
        userMap.put("username","wk");
        userMap.put("password","161616");
        userMap.put("age",23);
        userMap.put("gender","male");
        int insert = sqlSession.insert("userMapperNamespace.insertUser", userMap);

        System.out.println("insert = " + insert);

        //增删改操作 涉及到修改数据库的数据 事务
//        sqlSession.commit();
//        sqlSession.close();
    }

    /**修改update*/
    @Test
    public void test5(){
        User user = new User();
        user.setAge(20);
        user.setId(8);
        int update = sqlSession.update("userMapperNamespace.updateUser", user);
        System.out.println("update = " + update);
    }

    /**删除delete*/
    @Test
    public void test6(){
//        User user = new User();
//        user.setId(8);
//        int delete = sqlSession.delete("userMapperNamespace.deleteUser", user);
        int delete = sqlSession.delete("userMapperNamespace.deleteUser", 8);
        System.out.println("delete = " + delete);
    }
}
