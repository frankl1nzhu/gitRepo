package com.spring.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //增删改
    @Test
    public void testTemplate() {
        //添加

        String sql = "INSERT INTO t_emp VALUES (NULL,?,?,?)";
        int rows = jdbcTemplate.update(sql, "Paul", 20, "M");
        System.out.println(rows);


        //修改
        /*
        String sql = "UPDATE t_emp SET name =?, age =? WHERE id =?";
        int rows = jdbcTemplate.update(sql, "Theo", 18, 1);
        System.out.println(rows);
        */

        //删除
        /*
        String sql = "DELETE FROM t_emp WHERE id =?";
        int rows = jdbcTemplate.update(sql, 1);
        System.out.println(rows);
        */
    }
    //查询
    @Test
    public void testSelect() {
        //返回对象
        String sql ="select * from t_emp where id = ?";
        Emp emp =jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 1);
        System.out.println(emp);
        /* 写法二
        String sql ="select * from t_emp where id = ?";
        Emp empResult = jdbcTemplate.queryForObject(sql,
                (rs, rowNum) -> {
                    Emp emp = new Emp();
                    emp.setId(rs.getInt("id"));
                    emp.setName(rs.getString("name"));
                    emp.setAge(rs.getInt("age"));
                    emp.setSex(rs.getString("sex"));
                    return emp;
                }, 1);
        System.out.println(empResult);
        */

        //返回 list集合
        List<Emp> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class), 1);
        System.out.println(list);

        //返回单个值
        //表中数据数量
        String sql1 = "select count(*) from t_emp";
        Integer count = jdbcTemplate.queryForObject(sql1, Integer.class);
        System.out.println(count);
    }

}
