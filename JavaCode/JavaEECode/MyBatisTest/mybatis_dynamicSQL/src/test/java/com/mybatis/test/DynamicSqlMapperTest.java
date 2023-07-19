package com.mybatis.test;

import com.mybatis.mapper.DynamicSqlMapper;
import com.mybatis.pojo.Emp;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicSqlMapperTest {

    @Test
    public void test01(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        Emp emp = new Emp(null, "张三","男",20);
        List<Emp> list = mapper.getEmpByCondition(emp);
        list.forEach(System.out::println);
    }

    @Test
    public void test02(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        Emp emp = new Emp(null, "张三","男",20);
        List<Emp> list = mapper.getEmpByChoose(emp);
        list.forEach(System.out::println);
    }
    @Test
    public void test03() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        Emp emp1 = new Emp(null, "阿萨德", "女", 27);
        Emp emp2 = new Emp(null, "大哥", "男", 27);
        List<Emp> empList = Arrays.asList(emp1, emp2);
        mapper.insertMoreEmp(empList);
    }
    @Test
    public void test04() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        Integer[] emps =new Integer[]{5,6};
        mapper.deleteMoreEmp(emps);
    }
}
