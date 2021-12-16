package com.bupt;

import com.bupt.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author czgggggggg
 * @Date 2021/12/16
 * @Description
 */
public class SettingTest {
    SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml")).openSession();
    }

    @After
    public void commitAndClose(){
        if(sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void test1(){
        String username = sqlSession.selectOne("userMapperNamespace.selectUsernameById",1);
        System.out.println("username = " + username);
    }

    @Test
    public void test2(){
        User user = sqlSession.selectOne("userMapperNamespace.selectUserById", 1);
        System.out.println("user = " + user);
    }
}
