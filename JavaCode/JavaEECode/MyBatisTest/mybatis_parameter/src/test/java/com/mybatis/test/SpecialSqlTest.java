package com.mybatis.test;

import com.mybatis.mapper.SpecialSqlMapper;
import com.mybatis.pojo.User;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SpecialSqlTest {
    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtil.getSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List<User> userList = mapper.getUserByLike("a");
        userList.forEach(System.out::println);
    }

    @Test
    public void testGetUserList(){
        SqlSession sqlSession = SqlSessionUtil.getSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List<User> list = mapper.getUserList("t_user");
        list.forEach(System.out::println);

    }
}
