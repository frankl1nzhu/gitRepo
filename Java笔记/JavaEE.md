# Java Web

### Servlet

HttpServletRequest   和HttpServletResponse  两个类，用来请求和响应

在Servlet Java类上加`@WebServlet("/路径")`，以访问该路径实现类中内容

init方法，仅在服务器创建时执行一次。请求到达Servlet容器时会判断Servlet对象是否存在，如不存在便创建实例并初始化

service方法，可执行多次

destroy方法，仅在服务器销毁或应用程序停止时执行一次

# Spring

## IOC控制反转

1.  定义实体类User
2.  创建bean.xml（spring config），并创建bean标签 `<bean `*`id`*`="user" `*`class`*`="com.sc.spring6.User"/>`
3.  实现：

    ```java
    	/*在底层中，运用反射创建对象*/
        //加载spring配置文件，创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
    
        //获取创建的对象
        User user = (User) context.getBean("user");
        
        //使用对象调用方法进行测试
        user.add();
    ```

```java
//如果接口只对应一个实现类，则可用ApplicationContext直接生成代理实现类
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserDao userDao = context.getBean(UserDao.class);
        userDao.run();
//此时调用的是userDaoImpl中实现的run方法
```

### 依赖注入 DI

##### 一般注入

```xml
    <!--set方法注入,用property，无参构造 -->
    <bean id="book" class="com.sc.spring6.di.Book">
        <property name="author" value="zhangsan"/>
        <property name="name" value="学习手册"/>
    </bean>
    <!--构造器注入,用constructor-arg,有参构造 -->
    <bean id="bookCon" class="com.sc.spring6.di.Book">
        <constructor-arg name="author" value="lisi"/>
        <constructor-arg name="name" value="游戏手册"/>
    </bean>

<!--value用于普通属性， ref用于注入对象类型的属性-->
```

###### 数组array

```xml
        <property name = "hobbies">
            <array>
                <value>吃饭</value>
                <value>睡觉</value>
            </array>
        </property>
```

###### list

```xml
		<property name = "empList">
            <list>
                <ref bean="empOne"/>       <!--两个emp对象-->
                <ref bean="empTwo"/>
            </list>
        </property>

```

###### map

```xml
        <property name = "teacherMap">
            <map>
                <entry>
                    <key>
                        <value>001</value>
                    </key>
                    <ref bean = "teacherOne"/>
                </entry>
                <entry>
                    <key>
                        <value>002</value>
                    </key>
                    <ref bean = "teacherTwo"/>
                </entry>
            </map>
        </property>
```

###### 内部bean

```xml
    <bean id="book" class="com.sc.spring6.di.Book">
        <property name="author" value="zhangsan"/>
        <property name="name" value="学习手册"/>

        <property name="type">
            <bean id="type" class="com.sc.spring6.di.Type">
                <property name="dtype" value="童话书"/>
            </bean>
        </property>
    </bean>
```

p,c命名空间

```xml
    <!--p和c命名空间需要导入xml约束-->
    <!--p命名注入，property，无参构造-->
    <bean id="" class="" p:name="小明" p:age="20"/>

    <!--c命名注入，constructor,通过构造器有参构造-->
    <bean id="" class="" c:name="小明" c:age="20"/>
```

## AOP面向切面编程

简单的说，AOP 的作用就是保证开发者在不修改源代码的前提下，为系统中的业务组件添加某种通用功能。

1.  配置bean.xml

    ```xml
        <!--开启组件扫描-->
        <context:component-scan base-package="com.spring.aop.annotation"/>
    
        <!--开启aspectj自动代理，为目标对象生成代理-->
        <aop:aspectj-autoproxy/>
    ```
2.  配置beanaop.xml

    ```xml
        <!--开启组件扫描-->
        <context:component-scan base-package="com.spring.aop.xmlanno"/>
    
        <!--配置aop的五种通知类型-->
        <aop:config>
            <!--配置切面类,ref为类名-->
            <aop:aspect ref = "LogAspect">
                <!--配置切入点-->
                <aop:pointcut id="pointcut" expression="execution(* com.spring.aop.xmlanno.CalculatorImpl.*(..))"/>
    
                <!--前置通知-->
                <aop:before method="beforeMethod" pointcut-ref="pointcut"/>
                <!--后置通知-->
                <aop:after method="afterMethod" pointcut-ref="pointcut"/>
                <!--返回通知-->
                <aop:after-returning method="afterRetuningMethod" returning="result" pointcut-ref="pointcut"/>
                <!--异常通知-->
                <aop:after-throwing method="afterThrowingMethod" throwing="ex" pointcut-ref="pointcut"/>
                <!--环绕通知-->
                <aop:around method="aroundMethod" pointcut-ref="pointcut"/>
            </aop:aspect>
        </aop:config>
    ```
3.  配置切面类，如LogAspect

    ```java
    @Component //ioc容器，交给spring管理
    @Aspect //表示这是一个切面类
    public class LogAspect {
    
        //设置切入点和通知类型
        //重用切入点表达式
        //切入点表达式：execution(访问修饰符 + 方法返回值 + 增强方法所在类全路径.方法名称(参数) )
        @Pointcut(value = "execution(* com.spring.aop.annotation.CalculatorImpl.*(..))")
        public void pointCut(){}
    
        //通知类型：前置 @Before(value = "切入点表达式")
        @Before(value = "execution(* com.spring.aop.annotation.CalculatorImpl.*(..))")
        public void beforeMethod(JoinPoint joinPoint){
            String methodName = joinPoint.getSignature().getName();
            Object[] args = joinPoint.getArgs();
            System.out.println("前置通知，方法为" +  methodName + "，参数："+ Arrays.toString(args));
        }
    
        //        后置 @After()
        @After(value = "pointCut()")
        public void afterMethod(JoinPoint joinPoint){
            String methodName = joinPoint.getSignature().getName();
            System.out.println("后置通知,方法为"+methodName);
        }
        //        返回 @AfterReturning
        @AfterReturning(value = "pointCut()", returning = "result")
        public void afterRetuningMethod(JoinPoint joinPoint, Object result){
            String methodName = joinPoint.getSignature().getName();
            System.out.println("返回通知，方法为" +  methodName + "，返回结果：" +result);
        }
    
        //        异常 @AfterThrowing
        @AfterThrowing(value = "pointCut()",throwing = "ex")
        public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex){
            String methodName = joinPoint.getSignature().getName();
            System.out.println("异常通知，方法为" +  methodName + "，异常信息：" +ex);
        }
    
        //        环绕 @Around()
        @Around(value = "pointCut()")
        public Object aroundMethod(ProceedingJoinPoint joinPoint){
            String methodName = joinPoint.getSignature().getName();
            Object[] args = joinPoint.getArgs();
            String argsString = Arrays.toString(args);
            Object result = null;
            try{
                System.out.println("环绕通知==目标方法之前执行");
    
                result = joinPoint.proceed();
    
                System.out.println("环绕通知==目标方法返回值之后");
            }catch (Throwable throwable){
                throwable.printStackTrace();
                System.out.println("环绕通知==目标方法出现异常执行");
            }finally {
                System.out.println("环绕通知==目标方法执行完毕执行");
            }
            return result;
        }
    
    }
    ```

## 事务 transactional

1.  配置beans.xml

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:aop="http://www.springframework.org/schema/aop"
           xmlns:tx="http://www.springframework.org/schema/tx"
           xmlns:context="http://www.springframework.org/schema/context"
           xsi:schemaLocation="http://www.springframework.org/schema/beans
                 http://www.springframework.org/schema/beans/spring-beans.xsd
                 http://www.springframework.org/schema/tx
                 http://www.springframework.org/schema/tx/spring-tx.xsd
                  http://www.springframework.org/schema/aop
                  http://www.springframework.org/schema/aop/spring-aop.xsd
                  http://www.springframework.org/schema/context
                  http://www.springframework.org/schema/context/spring-context.xsd">


```xml
    <!--引入外部属性文件，创建数据源对象-->
    <context:property-placeholder location="classpath:jdbc.properties"/>
    <bean id="druidDataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="url" value="${jdbc.url}"/>
        <property name="driverClassName" value="${jdbc.driver}"/>
        <property name="username" value="${jdbc.user}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>

    <!--组件扫描-->
    <context:component-scan base-package="com.spring.jdbc.tx"/>

    <!--创建jdbcTemplate对象，注入数据源-->
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="druidDataSource"/>
    </bean>

    <!--开启事务的注解驱动-->
    <bean id ="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="druidDataSource"/>
    </bean>
    <tx:annotation-driven transaction-manager="transactionManager" />

</beans>
```
2.  在service实现类上加@Transactional

    ```java
    @Transactional(propagation = Propagation.REQUIRES_NEW) //事务
    /*参数
    * readOnly = true       只读，只能查询
    * timeout =            超时时间，默认-1永不超时
    * norollbackFor  和  norollbackForClassName    不回滚
    * isolation =            隔离级别
    * propagation =          传播行为：默认required，没有就新建，有就加入
    *                        例：101买100和10元的两本书，都不会成功，因为两个行为在一个事务中
    *                        requires_new，开启新事务，新事务与之前事务无嵌套关系，之前事务被挂起
    *                        例：101买100和10两本书，会买100的，因为两个行为有两个事务
    * */
    ```

# SpringMVC

一般只有表单提交需要post方法，其余都get

### 准备步骤

1.  配置web.xml文件

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
             http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
             version="4.0">
    
        <!--配置Spring编码过滤器-->
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
    </web-app>
    ```
2.  在resources中配置springmvc.xml文件

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:context="http://www.springframework.org/schema/context"
           xmlns:mvc="http://www.springframework.org/schema/mvc"
           xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context
           https://www.springframework.org/schema/context/spring-context.xsd
           http://www.springframework.org/schema/mvc
           https://www.springframework.org/schema/mvc/spring-mvc.xsd">
    
        <!--扫描控制层组件-->
        <context:component-scan base-package="com.controller"/>
    
        <!-- 配置Thymeleaf视图解析器 -->
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
    
        <!--开启mvc的注解驱动-->
        <mvc:annotation-driven/>
    
        <!--
            视图控制器：为当前的请求直接设置视图名称实现页面跳转
            若设置视图控制器，则只有视图控制器所设置的请求会被处理，其他的请求将全部404
            此时必须在配置一个标签：<mvc:annotation-driven />
        -->
        <mvc:view-controller path="/" view-name="index"/>
    
    </beans>
    ```

### 常用注解

#### `@RequestMapping`

(value = "/路径", method = RequestMethod.GET)&#x20;

设置请求路径和方法

*   `@Getmapping `

*   `@Postmapping`								直接确定method的注解&#x9;

类和方法上都可以加，绝对路径为先`/类路径`，再加上`/方法路径`

##### 其他属性

    /*  params属性:
        "param":请求参数必须携带param参数
        "!param":请求参数必须不携带param参数
        "param=value":必须携带param参数且=value
        "param!=value":可不携带参数，如果携带必须不等于value
    */
        //headers属性为请求头参数，用法与params相同
    
        //特殊字符：可用于路径中
        //？代表任意单个字符
        //*代表0或多个字符
        //**表示任意层数的任意目录，必须使用/**/xxxx的方式，即要有最终目录

##### 占位符

```java
    @RequestMapping("/abc/{username}/{id}")
    public String testRest(@PathVariable String username, @PathVariable Integer id){
        System.out.println("username=" + username + "id=" + id);
        return "success";
    }
```

#### @RequestParam，@RequestHeader, @CookieValue

```java
/*
@RequestParam
通过控制器方法获取形参
只需要在控制器形参位置设置形参，名字和请求参数名字相同即可
设置形参和控制器方法的形参绑定
value:设置和形参绑定的请求参数名
required：是否必需传输
defaultValue:默认值，若不传入此名称的形参，则为默认值*/

//@RequestHeader获取请求头信息
//@CookieValue获取cookie信息

public String getParam(@RequestParam(value = "username", required = true, defaultValue = "admin") String username456,
                           String password,
                           @RequestHeader("Referer") String referer,
                           @CookieValue("JSESSIONID")String jsessionid) {
         System.out.println("username=" + username456 + " password=" + password);
        return "success";
    }
```

### ModelAndView

Model: 向请求域中共享数据
View: 设计逻辑视图实现页面跳转

向请求域中共享数据：

1. 使用ModelAndView

   ```java
   	@RequestMapping("/test/mav")
       public ModelAndView TestMAV() {
           /*
           * Model:向请求域中共享数据
           * View：设计逻辑视图实现页面跳转
           * */
           ModelAndView mav = new ModelAndView();
           //向请求域中共享数据
           mav.addObject("testRequestScope", "hello,mav");
           //设置逻辑视图
           mav.setViewName("success");
           return mav;
       }
   ```

2. 使用Model

   ```java
       @RequestMapping("/test/model")
       public String testModel(Model model) {
           model.addAttribute("testRequestScope", "hello,model");
           return "success";
       }
   ```

### Session, Application

```java
    //session生效为浏览器开启到关闭期间
    @RequestMapping("/test/session")
    public String testSession(HttpSession session) {
        session.setAttribute("testSessionScope", "hello,session");
        return "success";
    }

    //application生效为服务器开启到关闭
    @RequestMapping("/test/application")
    public String testApplication(HttpSession session ) {
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope","hello,application");
        return "success";
    }
```

