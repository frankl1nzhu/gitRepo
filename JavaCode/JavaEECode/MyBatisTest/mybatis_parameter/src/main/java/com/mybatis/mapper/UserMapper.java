package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/*mybatis获取参数值的两种方式：#{} 和 ${}    不同点为#{}会自动加单引号
* 1. 若mapper接口方法的参数为单个字面量类型，两种都可以，注意${}要加单引号
* 2. 若参数为多个字面量类型，{}内部要用arg0, arg1 ...
* 3. 若参数为map集合，用#{} 或${}访问map集合的键就可以
* 4. 若为实体类参数，两种方法访问实体类中的属性名
* 5. 可以在参数上设置@param注解，此时可以用注解的value属性值为键，或param1,param2, ...*/
public interface UserMapper {

    User getUserByUsername(String username);

    User checkLogin(String username, String password);
    User checkLoginByMap(Map<String,Object> map);
    void insertUser(User user);
    User checkLoginByParam(@Param("username1") String username, @Param("password1") String password);

}
