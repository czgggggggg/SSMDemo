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
}
