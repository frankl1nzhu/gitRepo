package com.mybatis.test;

import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.User;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void  testInsert() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSession();

        ////获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用mapper接口的方法
        int result = mapper.insertUser();

        //唯一标识是namespace.sqlID
/*        int result = sqlSession.insert("com.mybatis.mapper.UserMapper.insertUser");*/

        System.out.println("结果 = " + result);

        //提交事务
        //sqlSession.commit();
        //关闭sqlSession对象
        sqlSession.close();
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.close();
    }


    @Test
    public void testDelete(){
        SqlSession sqlSession = SqlSessionUtil.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlSession.close();
    }

    @Test
    public void testgetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        System.out.println(user);
    }

    @Test
    public void testgetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);
    }

}
