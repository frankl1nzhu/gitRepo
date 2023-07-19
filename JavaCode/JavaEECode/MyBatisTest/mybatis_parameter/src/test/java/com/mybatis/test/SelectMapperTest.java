package com.mybatis.test;

import com.mybatis.mapper.SelectMapper;
import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.User;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SelectMapperTest {

    @Test
    public void testGetUserById(){
    SqlSession sqlSession = SqlSessionUtil.getSession();
    SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
/*    User user = mapper.getUserById(1);
    System.out.println(user);

    List<User> users = mapper.getAllUser();
    users.forEach(System.out::println);*/

    Map<String, Object> userMap = mapper.getUserByIdToMap(1);
    System.out.println(userMap);

    List<Map<String, Object>> userList = mapper.getAllUserToMap();
    userList.forEach(System.out::println);
    }

}
