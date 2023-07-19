package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSqlMapper {

    //模糊查询
    List<User> getUserByLike(@Param("mohu") String mohu);

    //批量删除
    void deleteMoreUser(String ids);

    //动态处理表名
    List<User> getUserList(@Param("tableName") String tableName);
}
