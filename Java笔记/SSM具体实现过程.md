# 准备工作

#### 0.建立数据库文件

#### 1.导入maven工程，获取依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.mycom.ssm</groupId>
    <artifactId>SSM</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>war</packaging>

    <properties>
        <spring.version>5.3.1</spring.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <!--springmvc-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <!-- Mybatis核心 -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.7</version>
        </dependency>
        <!--mybatis和spring的整合包-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.6</version>
        </dependency>
        <!-- 连接池 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.0.9</version>
        </dependency>
        <!-- junit测试 -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
        <!-- MySQL驱动 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.33</version>
        </dependency>
        <!-- log4j日志 -->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.github.pagehelper/pagehelper -->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper</artifactId>
            <version>5.2.0</version>
        </dependency>
        <!-- 日志 -->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.2.3</version>
        </dependency>
        <!-- ServletAPI -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.12.1</version>
        </dependency>
        <dependency>
            <groupId>commons-fileupload</groupId>
            <artifactId>commons-fileupload</artifactId>
            <version>1.3.1</version>
        </dependency>
        <!-- Spring5和Thymeleaf整合包 -->
        <dependency>
            <groupId>org.thymeleaf</groupId>
            <artifactId>thymeleaf-spring5</artifactId>
            <version>3.0.12.RELEASE</version>
        </dependency>
    </dependencies>

</project>
```

#### 2.配置web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">

    <!--配置spring编码过滤器-->
    <filter>
        <filter-name>CharacterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>CharacterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    <!--配置处理请求方式的过滤器-->
    <filter>
        <filter-name>HiddenHttpMethodFilter</filter-name>
        <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>HiddenHttpMethodFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    <!--配置SpringMVC前端控制器DispatcherServlet-->
    <servlet>
        <servlet-name>SpringMVC</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>SpringMVC</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>

    <!--配置Spring监听器，在服务器启动时加载Spring配置文件-->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>

    <!--Spring配置文件自定义的位置和名称-->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring.xml</param-value>
    </context-param>
</web-app>
```

#### 3.Project Stucture中设置Module中web

#### 4.配置resources文件

##### jdbc.properties

配置连接数据库

```properties
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/spring?serverTimezone=UTC
jdbc.username=root
jdbc.password=0616
```

##### log4j.xml

日志

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE log4j:configuration SYSTEM "log4j.dtd">

<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">

    <appender name="STDOUT" class="org.apache.log4j.ConsoleAppender">
        <param name="Encoding" value="UTF-8"/>
        <layout class="org.apache.log4j.PatternLayout">
            <param name="ConversionPattern" value="%-5p %d{MM-dd HH:mm:ss,SSS} %m  (%F:%L) \n"/>
        </layout>
    </appender>
    <logger name="java.sql">
        <level value="debug"/>
    </logger>
    <logger name="org.apache.ibatis">
        <level value="info"/>
    </logger>
    <root>
        <level value="debug"/>
        <appender-ref ref="STDOUT"/>
    </root>
</log4j:configuration>
```

##### mybatis-config.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!--configuration内标签的顺序：
    properties?,settings?,typeAliases?,typeHandlers?,
    objectFactory?,objectWrapperFactory?,reflectorFactory?,
    plugins?,environments?,databaseIdProvider?,mappers? -->

    <settings>
        <!--将下划线映射为驼峰-->
        <setting name="mapUnderscoreToCamelCase" value="true"/>
        <!--开启延迟加载-->
        <setting name="lazyLoadingEnabled" value="true"/>
        <!--按需加载-->
        <setting name="aggressiveLazyLoading" value="false"/>
    </settings>
    
    <plugins>
        <!--配置分页插件-->
        <plugin interceptor="com.github.pagehelper.PageInterceptor"/>
    </plugins>

</configuration>
```

##### spring.xml

扫描引入除controller层，引入jdbc.properties

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       https://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/tx
       http://www.springframework.org/schema/tx/spring-tx.xsd">

    <!--扫描组件（除controller层）-->
    <context:component-scan base-package="com.mycom.ssm">
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>

    <!--引入jdbc.properties-->
    <context:property-placeholder location="classpath:jdbc.properties"/>
    <!--配置数据源DataSource-->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${jdbc.driver}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>

    <!--配置事务管理器-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>

    <!--开启事务注解驱动
        将使用@transactional标识的方法或类中所有的方法进行事务管理-->
    <tx:annotation-driven transaction-manager="transactionManager"/>

    <!--配置sqlSessionfactoryBean,可以直接在spring的ioc中获取sqlSession-->
    <bean class="org.mybatis.spring.SqlSessionFactoryBean">
        <!--设置mybatis核心配置文件路径-->
        <property name="configLocation" value="classpath:mybatis-config.xml"/>
        <!--设置数据源-->
        <property name="dataSource" ref="dataSource"/>
        <!--设置类型别名-->
        <property name="typeAliasesPackage" value="com.mycom.ssm.pojo"/>
        <!--设置映射文件路径，只有mapper接口和映射文件路径不一致时需要设置-->
        <!--<property name="mapperLocations" value="classpath:mappers/*.xml"/>-->
    </bean>

    <!--
    配置mapper接口的扫描，可以将指定包下的所有mapper接口通过sqlSession创建代理实现类对象，并将其交给ioc管理
    -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.mycom.ssm.mapper"/>
    </bean>
</beans>
```

##### springmvc.xml

扫描引入controller层

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <!--扫描控制层组件-->
    <context:component-scan base-package="com.mycom.ssm.controller"/>

    <!--配置视图解析器-->
    <bean id="viewResolver" class="org.thymeleaf.spring5.view.ThymeleafViewResolver">
        <property name="order" value="1"/>
        <property name="characterEncoding" value="UTF-8"/>
        <property name="templateEngine">
            <bean class="org.thymeleaf.spring5.SpringTemplateEngine">
                <property name="templateResolver">
                    <bean class="org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver">
                        <!-- 视图前缀 -->
                        <property name="prefix" value="/WEB-INF/templates/"/>
                        <!-- 视图后缀 -->
                        <property name="suffix" value=".html"/>
                        <property name="templateMode" value="HTML5"/>
                        <property name="characterEncoding" value="UTF-8" />
                    </bean>
                </property>
            </bean>
        </property>
    </bean>

    <!--配置默认servlet处理静态资源-->
    <mvc:default-servlet-handler/>
    <!--开启mvc注解驱动-->
    <mvc:annotation-driven/>
    <!--配置视图控制器-->
    <mvc:view-controller path="/" view-name="index"/>

    <!--配置文件上传解析器-->
    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"/>
</beans>
```

#### 5.创建mapper层和resources中的mapper映射文件

注意两者要在同一目录，映射文件应在com/xxxx/ssm/mapper，而不是com.xxxx.ssm.mapper

#### 6.建立webapp/WEB-INF/templates文件夹

存放html文件

#### 7.webapp下导入static静态文件

css，js等文件

# 项目

### 1.创建pojo层

​	pojo.Employee

```java
public class Employee {
    private String empId;
    private String empName;
    private Integer age;
    private String gender;
    private String email;
    //...
}
```

### 2.创建mapper接口

​	mapper.EmployeeMapper

```java
public interface EmployeeMapper {
    /*查询所有员工信息*/
    List<Employee> getAllEmployee();
}
```

### 3.mapper映射文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--mapper接口的全类名和映射文件的namespace一致
    mapper接口中的方法的方法名要和映射文件中的sql语句的id保持一致   -->
<mapper namespace="com.mycom.ssm.mapper.EmployeeMapper">
    <!--<insert id="insertUser">
          insert into t_user values(null,'admin','123456',23,'男','12345@qq.com')
      </insert>   -->

    <!--List<Employee> getAllEmployee();-->
    <select id="getAllEmployee" resultType="Employee">
        select * from t_emp
    </select>
</mapper>
```

### 4.service接口和实现类

```java
public interface EmployeeService {

    /*查询所有的员工信息*/
    List<Employee> getAllEmployee();

    /*获取员工分页信息*/
    PageInfo<Employee> getEmployeePage(Integer pageNum);
}
```

实现类中自动装配mapper接口

```java
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
        //开启分页功能
        PageHelper.startPage(pageNum, 4);
        //查询所有员工信息
        List<Employee> list = employeeMapper.getAllEmployee();
        //获取分页相关数据        navigatePage为导航分页，即选择页面处的选项数
        PageInfo<Employee> page = new PageInfo<>(list, 5);
        return page;
    }
}
```

### 5.controller实现具体操作

自动装配service接口

配置操作的请求路径和方法，注意占位符（未知数）需要在形参中加入@PathVariable

```java
/* 查询所有的员工信息-->/employee-->get
 * 查询员工的分页信息-->/employee/page/1-->get
 * 根据id查询员工信息-->/employee/1-->get
 * 跳转到添加页面-->/to/add-->get
 * 添加员工信息-->/employee-->post
 * 修改员工信息-->/employee-->put
 * 删除员工信息-->/employee/1-->delete
 * */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee/page/{pageNum}", method = RequestMethod.GET)
    public  String getEmployeePage(@PathVariable("pageNum") Integer pageNum, Model model) {
        //获取员工分页信息
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum);
        //将分页信息在请求域中共享
        model.addAttribute("page", page);
        //跳转到employee_list_page.html
        return "employee_list_page";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        //查询所有的员工信息
        List<Employee> list = employeeService.getAllEmployee();
        //将员工信息在请求域中共享
        model.addAttribute("list", list);
        //跳转到employee_list.html
        return "employee_list";
    }
}
```

### 6.index.xml首页

操作RequestMapping为	/employee	和	/employee/page/{pageNum}

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>
<h1>index.html</h1>
<a th:href="@{/employee}">查询所有的员工信息</a>
<br/>
<a th:href="@{/employee/page/1}">查询员工的分页信息</a>
</body>
</html>
```

### 7.操作具体网页

如对查询所有员工信息操作，return至employee_list.html

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>员工列表</title>
    <link rel="stylesheet" th:href="@{/static/css/index_work.css}">
</head>
<body>
<table>
    <tr>
        <th colspan="6">员工列表</th>
    </tr>
    <tr>
        <th>流水号</th>
        <th>员工姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>邮箱</th>
        <th>操作</th>
    </tr>
    <tr th:each="employee,status : ${list}">
        <td th:text="${status.count}"></td>
        <td th:text="${employee.empName}"></td>
        <td th:text="${employee.age}"></td>
        <td th:text="${employee.gender}"></td>
        <td th:text="${employee.email}"></td>
        <td>
            <a href="">删除</a>
            <a href="">修改</a>
        </td>
    </tr>
</table>
</body>
</html>
```

对查询分页操作，return至employee_list_page.html

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <title>员工列表</title>
  <link rel="stylesheet" th:href="@{/static/css/index_work.css}">
</head>
<body>
<table>
  <tr>
    <th colspan="6">员工列表</th>
  </tr>
  <tr>
    <th>流水号</th>
    <th>员工姓名</th>
    <th>年龄</th>
    <th>性别</th>
    <th>邮箱</th>
    <th>操作</th>
  </tr>
  <tr th:each="employee,status : ${page.list}">
    <td th:text="${status.count}"></td>
    <td th:text="${employee.empName}"></td>
    <td th:text="${employee.age}"></td>
    <td th:text="${employee.gender}"></td>
    <td th:text="${employee.email}"></td>
    <td>
      <a href="">删除</a>
      <a href="">修改</a>
    </td>
  </tr>
</table>
<div style="text-align: center;">
  <a th:if="${page.hasPreviousPage}" th:href="@{/employee/page/1}">首页</a>
  <a th:if="${page.hasPreviousPage}" th:href="@{'/employee/page/'+${page.prePage}}">上一页</a>
  <!--导航分页-->
  <span th:each="num : ${page.navigatepageNums}">
      <a th:if="${page.pageNum == num}" style="color: red" th:href="@{'/employee/page/'+${num}}" th:text="'['+${num}+']'"></a>
      <a th:if="${page.pageNum != num}" th:href="@{'/employee/page/'+${num}}" th:text="${num}"></a>
  </span>
  <a th:if="${page.hasNextPage}" th:href="@{'/employee/page/'+${page.nextPage}}">下一页</a>
  <a th:if="${page.hasNextPage}" th:href="@{'/employee/page/'+${page.pages}}">末页</a>
</div>
</body>
</html>
```





