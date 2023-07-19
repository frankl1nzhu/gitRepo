package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    User getUserById(@Param("id") Integer id);

    List<User> getAllUser();

    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

    List<Map<String, Object>> getAllUserToMap();
}
