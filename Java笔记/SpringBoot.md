# 热部署
在不重启服务器情况下，对项目进行**即时编译**

#### 原理

启动项目后，改动代码，编辑器自动触发编译，替换掉历史class文件

项目检查到`classpath`有变化，触发重启

类加载器：对第三方jar包采用`baseClassLoader`，对开发代码使用`restartClassLoader`

#### 排除资源

在`application.properties`中设置`spring.devtools.restart.exclude=......`，自定义排除项

### 开始配置

1. 添加依赖 `spring-boot-devtools`

   ```xml
       <!--devtools热部署-->
       <dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-devtools</artifactId>
           <optional>true</optional>
           <scope>true</scope>
       </dependency>
   ```

2. 在application.yml中配置devtools

   ```yaml
   spring:
     devtools:
       restart:
         enabled: true  #设置开启热部署
         additional-paths: src/main/java #重启目录
         exclude: WEB-INF/**
     freemarker:
       cache: false    #页面不加载缓存，修改即时生效
   ```

   

# 全局配置文件

`application.properties`

`application.yml`使用键值对写法，冒号缩进

#### 使用注解

##### `@ConfigurationProperties(prefix = "person") `

将配置文件中以person开头的属性值通过`set方法`批量注入到实体类对应属性中

##### `@Component`

将当前注入属性值的Person类对象作为`Bean组件`放到Spring容器中，只有这样才能被`@ConfigurationProperties`注解进行赋值

##### `Configuration`

声明一个类作为配置类

##### `@Bean`

声明在方法上，将方法的返回值加入Bean容器

##### `@Value`

属性注入

# 日志框架

### 统一日志框架使用：

1. 排除系统中的其他日志框架
2. 使用中间包替换要替换的日志框架
3. 导入我们选择的 SLF4J 实现

Spring Boot 默认已经使用了 SLF4J + LogBack

### 输出日志文件路径

##### 默认输出在产品目录下

`logging.file.name=springboot.log`

##### 可在前面加路径，以输出在选择位置

`logging.file.name=D://springboot.log`

##### 归档

`logging.logback.rollingpolicy.file-name-pattern=${LOG_FILE}.%d{yyyy-MM-dd}.%i.gz`

##### 切割

`logging.logback.rollingpolicy.max-file-size=1MB`

# 源码分析

#### spring-boot-starter-parent

Spring Boot项目的统一版本父项目依赖管理

#### spring-boot-starter-web

Spring Boot项目的所依赖jar包进行打包起步依赖管理

注：druid数据源需要自己引入依赖启动器`druid-spring-boot-starter`

### @SpringBootConfiguration

核心启动类注解源码中含此注解，这个注解标注在某个类上，表示这是一个 Spring Boot的`配置类`

### @EnableAutoConfiguration

借助@Import来收集所有符合自动配置条件的bean定义，并加载到IoC容器

通俗点就是注册bean，然后根据 @AutoConfigurationPackage找到需要注册bean的类路径，这个路径就被自动保存了下来

### @ComponentScan

主要作用是从定义的扫描路径中，找出标识了需要装配的类自动装配到spring 的bean容器中

# Web

1. 整合web场景

   ```xml
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-web</artifactId>
           </dependency>
   ```

2. 引入了 `autoconfigure`功能
3. `@EnableAutoConfiguration`注解使用`@Import(AutoConfigurationImportSelector.class)`批量导入组件

### 静态资源

```properties
#开启静态资源映射规则
spring.web.resources.add-mappings=true
```



默认路径： `classpath:/META-INF/resources/`

​			    	`classpath:/resources/`

​					`classpath:/static/`

​	    			`classpath:/public/`

#### 欢迎页

1. 在**静态资源**目录下找 index.html
2. 没有就在 templates下找index模板页

#### Favicon网页小图标

1. 在静态资源目录下找 favicon.ico

#### 缓存

```properties
#设置缓存
spring.web.resources.cache.period=3600
#缓存详细合并项控制，覆盖period
spring.web.resources.cache.cachecontrol.max-age=7200
#使用资源last-modified时间，对比服务器和浏览器资源有无变化，相同返回304
spring.web.resources.cache.use-last-modified=true
```



## 路径匹配语法

默认**PathPatternParser**

- *：表示**任意数量**的字符。
- ?：表示任意一个字符。
- **：表示任意数量的目录，只能用在末尾
- {}：表示一个命名的模式**占位符**。
- []：表示**字符集合**，例如[a-z]表示小写字母。

Ant老版语法，**可用在中间

## 内容协商

多端内容适配：基于**请求头(默认开启)**：HTTP标准的**Accept请求头**：`application/json`、`text/xml`、`text/yaml`

或**请求参数(手动开启)**：1. `GET/projects/spring-boot?format=json ` 2. 匹配到 `@GetMapping("/projects/spring-boot") `

进行内容协商

```properties
#开启基于请求参数的内容协商功能,默认参数名format
spring.mvc.contentnegotiation.favor-parameter=true
# 指定内容协商时使用的参数名。默认是 format
spring.mvc.contentnegotiation.parameter-name=type
```

<img src="C:\Users\zhuyz\AppData\Roaming\Typora\typora-user-images\image-20230718154725702.png" alt="image-20230718154725702" style="zoom:80%;" />

<img src="https://cdn.nlark.com/yuque/0/2023/png/1613913/1681220145378-86fabd90-a78c-4f60-9efa-eb2960915832.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_16%2Ctext_5bCa56GF6LC3IGF0Z3VpZ3UuY29t%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10" alt="image.png" style="zoom: 80%;" />

## 错误处理

- **前后分离**

- - 后台发生的所有错误，`@ControllerAdvice + @ExceptionHandler`进行统一异常处理。

- **服务端页面渲染**

- - **不可预知的一些，HTTP码表示的服务器或客户端错误**

- - - 给`classpath:/templates/error/`下面，放常用精确的错误码页面。`500.html`，`404.html`
    - 给`classpath:/templates/error/`下面，放通用模糊匹配的错误码页面。 `5xx.html`，`4xx.html`

- - **发生业务错误**

- - - **核心业务**，每一种错误，都应该代码控制，**跳转到自己定制的错误页**。
    - **通用业务**，`classpath:/templates/error.html`页面，**显示错误信息**。

<img src="https://cdn.nlark.com/yuque/0/2023/png/1613913/1681724501227-077073b7-349d-414f-8916-a822eb86c772.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_26%2Ctext_5bCa56GF6LC3IGF0Z3VpZ3UuY29t%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10" alt="image.png" style="zoom:80%;" />

## 全面接管SpringMVC

### 三种方式

| 方式         | 用法                                                         | 效果                         |                                                           |
| ------------ | ------------------------------------------------------------ | ---------------------------- | --------------------------------------------------------- |
| **全自动**   | 直接编写控制器逻辑                                           |                              | 全部使用**自动配置默认效果**                              |
| **手自一体** | `@Configuration` +   配置`WebMvcConfigurer`+ *配置 WebMvcRegistrations* | **不要标注** `@EnableWebMvc` | **保留自动配置效果** **手动设置部分功能** 定义MVC底层组件 |
| **全手动**   | `@Configuration` +   配置`WebMvcConfigurer`                  | **标注** `@EnableWebMvc`     | **禁用自动配置效果** **全手动设置**                       |

总结：

**给容器中写一个配置类**`@Configuration`**实现** `WebMvcConfigurer`**但是不要标注** `@EnableWebMvc`**注解，实现手自一体的效果。**

### 两种模式

1、**前后分离模式**： `@RestController `响应JSON数据

2、**前后不分离模式**：@Controller + Thymeleaf模板引擎

# 整合SSM

进行**数据访问场景**开发

1. ##### 创建SSM整合项目

```xml
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>3.1.1</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```

2. ##### 配置数据源

```properties
spring.datasource.url=jdbc:mysql://192.168.200.100:3306/demo
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.type=com.zaxxer.hikari.HikariDataSource
```

3. ##### 配置MyBatis

```properties
#指定mapper映射文件位置
mybatis.mapper-locations=classpath:/mapper/*.xml
#参数项调整
mybatis.configuration.map-underscore-to-camel-case=true
```

4. ##### CRUD编写

   - 编写Bean
   - 编写Mapper
   - 使用`mybatisx`插件，快速生成Mapper.XML
   - 测试CRUD

5. ##### Druid数据源整合

```properties
#数据源基本配置
spring.datasource.url=jdbc:mysql://192.168.200.100:3306/demo
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=0616
spring.datasource.type=com.alibaba.druid.pool.DruidDataSource

# 配置StatFilter监控
spring.datasource.druid.filter.stat.enabled=true
spring.datasource.druid.filter.stat.db-type=mysql
spring.datasource.druid.filter.stat.log-slow-sql=true
spring.datasource.druid.filter.stat.slow-sql-millis=2000
# 配置WallFilter防火墙
spring.datasource.druid.filter.wall.enabled=true
spring.datasource.druid.filter.wall.db-type=mysql
spring.datasource.druid.filter.wall.config.delete-allow=false
spring.datasource.druid.filter.wall.config.drop-table-allow=false
# 配置监控页，内置监控页面的首页是 /druid/index.html
spring.datasource.druid.stat-view-servlet.enabled=true
spring.datasource.druid.stat-view-servlet.login-username=admin
spring.datasource.druid.stat-view-servlet.login-password=admin
spring.datasource.druid.stat-view-servlet.allow=*

# 其他 Filter 配置不再演示
# 目前为以下 Filter 提供了配置支持，请参考文档或者根据IDE提示（spring.datasource.druid.filter.*）进行配置。
# StatFilter
# WallFilter
# ConfigFilter
# EncodingConvertFilter
# Slf4jLogFilter
# Log4jFilter
# Log4j2Filter
# CommonsLogFilter
```



# 整合框架

## 整合Junit

Service类

```java
@Service
public class UserService {
    public void add(){
        System.out.println("add()....");
    }
}
```

test

```java
/**
 * userService的测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJunitApplication.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void testAdd(){
        userService.add();
    }
}
```

## 整合Redis

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

```java
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootRedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testSet() {
        //存入数据
        redisTemplate.boundValueOps("name").set("zhangsan");
    }

    @Test
    public void testGet() {
        Object name = redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }
}
```

```yaml
spring:
  redis:
    host: 127.0.0.1 #redis的主机IP
    port: 6379
```

## 整合MySQL

```xml
<!--mysql驱动-->
<dependency>
   <groupId>mysql</groupId>
   <artifactId>mysql-connector-java</artifactId>
   <scope>runtime</scope>
</dependency>       
```

```yaml
#datasource
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/mysql1?characterEncoding=utf-8&useSSL=false
    username: root
    password: 0616
```

test

```java
@Controller
public class DeptController {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping
    @ResponseBody
    public String test1(){
        System.out.println(dataSource);
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from t_user");
        System.out.println(list);
        return "main";
    }
}
```

## 整合MyBatis

```xml
<dependency>
	<groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>3.1.1</version>
</dependency>            
```

```java
public interface UserMapper {
    @Select("select * from t_user")
    public List<User> queryAll();
}
```

扫描mapper接口

```java
@MapperScan("com.lanou.mapper")
@SpringBootApplication
public class SpringbootMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(Springboot6MybatisApplication.class, args);
    }
}
```

## 整合Email

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```

```properties
spring.mail.username=#发件人邮箱
spring.mail.password=#你的qq授权码
spring.mail.host=smtp.qq.com
#qq需要配置ssl
spring.mail.properties.mail.smtp.ssl.enable=true
```

test

```java
@SpringBootTest
public class SpringbootEmailApplicationTests {
    @Autowired
    public JavaMailSender javaMailSender;
    
    //发邮件
    @Test
    void contextLoads1() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("springboot整合email发送信息或文件！");//设置标题
        message.setText("你真好看。");//设置内容
        message.setFrom("xxxxxx@qq.com");//发送端
        message.setTo("xxxxx@163.com");//接收端
        javaMailSender.send(message);
    }
    
    //发送含有html页面的邮件
    @Test
    void contextLoads2() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
        //邮件设置
        messageHelper.setSubject("验证码邮件");//主题 需要抛出异常
        messageHelper.setText("邮件内容");
        messageHelper.setText("<h1>验证码内容: 9093</h1>",true);
        messageHelper.setFrom("xxxxxx@qq.com");//发送端
        messageHelper.setTo("xxxxx@163.com");//接收端
        javaMailSender.send(mimeMessage);
    }

    //发送内嵌图片的邮件
    @Test
    void contextLoads3() throws MessagingException {
        MimeMessage mimeMessage2 = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper2 = new MimeMessageHelper(mimeMessage2,true);
        //邮件设置
        String id = "3";
        String ImgPath = "C:\\Users\\24329\\Pictures\\Saved Pictures\\3.jpeg";
        messageHelper2.setSubject("含有图片的邮件");//主题 需要抛出异常
        messageHelper2.setText("<h1>图片:</h1><img src='cid:"+id+"'/>",true);
        FileSystemResource fileSystemResource = new FileSystemResource(new File(ImgPath));
        messageHelper2.addInline(id,fileSystemResource);
        messageHelper2.setFrom("xxxxxx@qq.com");//发送端
        messageHelper2.setTo("xxxxx@163.com");//接收端
        javaMailSender.send(mimeMessage2);
    }

    //发送含有附件的邮件
    @Test
    void contextLoads4() throws MessagingException {
        MimeMessage mimeMessage2 = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper2 = new MimeMessageHelper(mimeMessage2,true);
        //邮件设置
        String id = "3";
        String ImgPath = "C:\\Users\\24329\\Pictures\\Saved Pictures\\1.jpeg";
        messageHelper2.setSubject("含有附件的邮件");//主题 需要抛出异常
        messageHelper2.setText("<h1>图片:</h1><img src='cid:"+id+"'/>",true);
        FileSystemResource fileSystemResource = new FileSystemResource(new File(ImgPath));
        messageHelper2.addInline(id,fileSystemResource);
        //添加addAttachment方法可是实现发送附件
        messageHelper2.addAttachment("1.jepg",fileSystemResource);
        message.setFrom("xxxxxx@qq.com");//发送端
        message.setTo("xxxxx@163.com");//接收端
        javaMailSender.send(mimeMessage2);
    }
    
}
```

## 整合异步处理

用多线程

```java
@EnableAsync //开启异步注解功能 这个注解需要在启动控制类上加
@Async //异步方法
```

```properties
spring.mail.username=#发件人邮箱
spring.mail.password=#你的qq授权码
spring.mail.host=smtp.qq.com
#qq需要配置ssl
spring.mail.properties.mail.smtp.ssl.enable=true
```

```java
@EnableAsync //开启异步注解功能
@SpringBootApplication
public class SpringbootAsyncEmailApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootAsyncEmailApplication.class, args);
    }
}
```

```java
@Service
public class AsyncService {

    @Autowired
    public JavaMailSender javaMailSender;

    @Async //声明email是一个异步方法
    public void email() throws InterruptedException {
        Thread.sleep(3000);//等3秒钟
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("异步email发送信息或文件！");//设置主题
        message.setText("你真好看。");//设置内容
        message.setFrom("xxxxxx@qq.com");//发送端
        message.setTo("xxxxxx@163.com");//接收端
        javaMailSender.send(message);
    }
}
```

```java
@RestController
public class AsyncController {
    @Autowired
    public AsyncService asyncService;

    @RequestMapping("/sendEmail")
    public String sendEamil() throws InterruptedException {
        asyncService.email();
        return "ok";
    }

}
```

## 切换内置服务器

```xml
<!--springboot的web项目依赖-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <!--切换内置服务器-->
    <!--从spring-boot-satrt-web中排除tomcat依赖-->
    <exclusions>
    <exclusion>
       <groupId>spring-boot-starter-tomcat</groupId>
       <artifactId>org.springframework.boot</artifactId>
    </exclusion>
    </exclusions>
</dependency>

<!--引入jetty依赖-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jetty</artifactId>
</dependency>
```

# 基础特性

## 自定义Banner

即程序开始运行时显示公司或项目的信息

```properties
#通过在resources下的banner.txt编写
spring.banner.location=classpath:banner.txt

#关闭banner
spring.main.banner-mode=off
```

## 自定义SpringApplication

Boot应用的核心API入口

配置文件优先级高于程序

```java
@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        //自定义SpringApplication的底层设置
        SpringApplication application = new SpringApplication(MyApplication.class);
        //调整参数
        application.setBannerMode(Banner.Mode.OFF);
        //运行SpringApplication
        application.run(args);
    }
}
```

FluentBuilder API，流式

```java
new SpringApplicationBuilder()
    .sources(Parent.class)
    .child(Application.class)
    .bannerMode(Banner.Mode.OFF)
    .run(args);
```

## Profiles 环境隔离

步骤：

1. **标识环境**：指定哪些组件、配置在哪个环境生效
2. **切换环境**：这个环境对应的所有组件和配置就应该生效

使用 @Profile 标记，如@Profile("dev"),@Profile("prod"),@Profile("test")

```properties
#激活环境
spring.profiles.active=prod
#包含环境
spring.profiles.include[0]=prod
spring.profiles.include[1]=dev
```

最佳实战：

- **生效的环境** = **激活的环境/默认环境**  + **包含的环境**
- 项目里面这么用

- - 基础的配置`mybatis`、`log`、`xxx`：写到**包含环境中**
  - 需要动态切换变化的 `db`、`redis`：写到**激活的环境中**

```properties
#环境分组
spring.profiles.group.prod[0]=db
spring.profiles.group.prod[1]=mq
#使用--spring.profiles.active=prod ，就会激活db，mq配置文件
```

#### 配置环境

```properties
 #application.properties：主配置文件，任意时候都生效
 #application-{profile}.properties：指定环境配置文件，激活指定环境生效
      #如application-dev.properties
      
#激活环境优先级>主配置，发生冲突以激活环境为准
```

## 外部化配置

#### 配置优先级

由低到高，高优先级配置覆盖低优先级

1. **默认属性**（通过`SpringApplication.setDefaultProperties`指定的）
2. @PropertySource指定加载的配置（需要写在@Configuration类上才可生效）
3. **配置文件（application.properties/yml等）**
4. RandomValuePropertySource支持的random.*配置（如：@Value("${random.int}")）
5. OS 环境变量
6. Java 系统属性（System.getProperties()）
7. JNDI 属性（来自java:comp/env）
8. ServletContext 初始化参数
9. ServletConfig 初始化参数
10. SPRING_APPLICATION_JSON属性（内置在环境变量或系统属性中的 JSON）
11. **命令行参数**
12. 测试属性。(@SpringBootTest进行测试时指定的属性)
13. 测试类@TestPropertySource注解
14. Devtools 设置的全局属性。($HOME/.config/spring-boot)

> 结论：配置可以写到很多位置，**常见的优先级顺序**：
>
> - `命令行`> `配置文件`> `SpringApplication配置`



**配置文件优先级**如下：(**后面覆盖前面**)

1. **jar 包内**的application.properties/yml
2. **jar 包内**的application-{profile}.properties/yml
3. **jar 包外**的application.properties/yml
4. **jar 包外**的application-{profile}.properties/yml

**建议：用一种格式的配置文件**。如果.properties和.yml同时存在,则.**properties优先**



结论：包外 > 包内； 同级情况：profile配置 > application配置

![img](https://cdn.nlark.com/yuque/0/2023/svg/1613913/1682073869709-2cba18c8-55bd-4bf1-a9df-ac784e30d89a.svg)

##### 规律：最外层的最优先

- 命令行 > 所有
- 包外 > 包内
- config目录 > 根目录
- profile > application 

#### 导入配置

使用`spring.config.import`可以导入额外配置

```properties
spring.config.import=my.properties
my.property=value
```

#### 属性占位符

配置文件中可以使用 ${name:default}形式取出之前配置过的值

```properties
app.name=MyApp
app.description=${app.name} is a Spring Boot application written by ${username:Unknown}
```

## Junit5

#### 注解

- **@Test :**表示方法是测试方法。但是与JUnit4的@Test不同，他的职责非常单一不能声明任何属性，拓展的测试将会由Jupiter提供额外测试
- **@ParameterizedTest :**表示方法是参数化测试，下方会有详细介绍
- **@RepeatedTest :**表示方法可重复执行，下方会有详细介绍
- **@DisplayName :**为测试类或者测试方法设置展示名称
- **@BeforeEach :**表示在每个单元测试之前执行，可多次
- **@AfterEach :**表示在每个单元测试之后执行，可多次
- **@BeforeAll :**表示在所有单元测试之前执行，仅一次
- **@AfterAll :**表示在所有单元测试之后执行，仅一次
- **@Tag :**表示单元测试类别，类似于JUnit4中的@Categories
- **@Disabled :**表示测试类或测试方法不执行，类似于JUnit4中的@Ignore
- **@Timeout :**表示测试方法运行如果超过了指定时间将会返回错误
- **@ExtendWith :**为测试类或测试方法提供扩展类引用

#### 断言Assertion

| 方法              | 说明                                 |
| ----------------- | ------------------------------------ |
| assertEquals      | 判断两个对象或两个原始类型是否相等   |
| assertNotEquals   | 判断两个对象或两个原始类型是否不相等 |
| assertSame        | 判断两个对象引用是否指向同一个对象   |
| assertNotSame     | 判断两个对象引用是否指向不同的对象   |
| assertTrue        | 判断给定的布尔值是否为 true          |
| assertFalse       | 判断给定的布尔值是否为 false         |
| assertNull        | 判断给定的对象引用是否为 null        |
| assertNotNull     | 判断给定的对象引用是否不为 null      |
| assertArrayEquals | 数组断言                             |
| assertAll         | 组合断言                             |
| assertThrows      | 异常断言                             |
| assertTimeout     | 超时断言                             |
| fail              | 快速失败                             |

#### 参数化测试 @ParameterizedTest

@ParameterizedTest 表示参数化测试

利用**@ValueSource**等注解，指定入参，我们将可以使用不同的参数进行多次单元测试

```java
@ParameterizedTest
@ValueSource(strings = {"one", "two", "three"})
@DisplayName("参数化测试1")
public void parameterizedTest1(String string) {
    System.out.println(string);
    Assertions.assertTrue(StringUtils.isNotBlank(string));
}


@ParameterizedTest
@MethodSource("method")    //指定方法名
@DisplayName("方法来源参数")
public void testWithExplicitLocalMethodSource(String name) {
    System.out.println(name);
    Assertions.assertNotNull(name);
}

static Stream<String> method() {
    return Stream.of("apple", "banana");
}
```

# 核心原理

## 事件Event和监听器Listener

### 自定义监听器

1. 编写`SpringApplicationRunListener` **实现类**
2. 在 `resources/META-INF/spring.factories` 中配置 `org.springframework.boot.SpringApplicationRunListener=自己的Listener`
### 生命周期监听

```java
/**
 * Listener先要从 META-INF/spring.factories 读到
 *
 * 1、引导： 利用 BootstrapContext 引导整个项目启动
 *      starting：              应用开始，SpringApplication的run方法一调用，只要有了 BootstrapContext 就执行
 *      environmentPrepared：   环境准备好（把启动参数等绑定到环境变量中），但是ioc还没有创建；【调一次】
 * 2、启动：
 *      contextPrepared：       ioc容器创建并准备好，但是sources（主配置类）没加载。并关闭引导上下文；组件都没创建  【调一次】
 *      contextLoaded：         ioc容器加载。主配置类加载进去了。但是ioc容器还没刷新（我们的bean没创建）。
 *      =======截止以前，ioc容器里面还没造bean呢=======
 *      started：               ioc容器刷新了（所有bean造好了），但是 runner 没调用。
 *      ready:                  ioc容器刷新了（所有bean造好了），所有 runner 调用完了。
 * 3、运行
 *     以前步骤都正确执行，代表容器running。
 */
```

<img src="https://cdn.nlark.com/yuque/0/2023/png/1613913/1682322663331-25a89875-7ce3-40ae-9be7-9ea752fbab20.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_31%2Ctext_5bCa56GF6LC3IGF0Z3VpZ3UuY29t%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10" alt="image.png" style="zoom:67%;" />

### 事件触发时机

####  各种回调监听器

- `BootstrapRegistryInitializer`：    **感知特定阶段：**感知**引导初始化**

- - `META-INF/spring.factories`
  - 创建引导上下文`bootstrapContext`的时候触发。
  - application.`addBootstrapRegistryInitializer`();
  - 场景：`进行密钥校对授权。`

- ApplicationContextInitializer：   **感知特定阶段：** 感知ioc容器初始化

- - `META-INF/spring.factories`
  - application.addInitializers();

- **ApplicationListener：    感知全阶段：基于事件机制，感知事件。 一旦到了哪个阶段可以做别的事**

- - `@Bean`或`@EventListener`： `事件驱动`
  - `SpringApplication.addListeners(…)`或 `SpringApplicationBuilder.listeners(…)`
  - `META-INF/spring.factories`

- **SpringApplicationRunListener：       感知全阶段生命周期 + 各种阶段都能自定义操作； 功能更完善。**

- - `META-INF/spring.factories`

- **ApplicationRunner:          感知特定阶段：感知应用就绪Ready。卡死应用，就不会就绪**

- - `@Bean`

- **CommandLineRunner：   感知特定阶段：感知应用就绪Ready。卡死应用，就不会就绪**

- - `@Bean`

#### 最佳实战

- 如果项目启动前做事： `BootstrapRegistryInitializer` 和 `ApplicationContextInitializer`
- 如果想要在项目启动完成后做事：`ApplicationRunner`**和** `CommandLineRunner`
- **如果要干涉生命周期做事：**`SpringApplicationRunListener`
- **如果想要用事件机制：**`ApplicationListener`

#### 完整触发流程

`9大事件`触发顺序&时机

1. `ApplicationStartingEvent`：应用启动但未做任何事情, 除过注册listeners and initializers.
2. `ApplicationEnvironmentPreparedEvent`：  Environment 准备好，但context 未创建.
3. `ApplicationContextInitializedEvent`: ApplicationContext 准备好，ApplicationContextInitializers 调用，但是任何bean未加载
4. `ApplicationPreparedEvent`： 容器刷新之前，bean定义信息加载
5. `ApplicationStartedEvent`： 容器刷新完成， runner未调用

=========以下就开始插入了**探针机制**============

1. `AvailabilityChangeEvent`： `LivenessState.CORRECT`应用存活； **存活探针**
2. `ApplicationReadyEvent`: 任何runner被调用
3. `AvailabilityChangeEvent`：`ReadinessState.ACCEPTING_TRAFFIC`**就绪探针**，可以接请求
4.  `ApplicationFailedEvent `：启动出错

<img src="https://cdn.nlark.com/yuque/0/2023/png/1613913/1682332243584-e7dd3527-b00f-4f65-a44c-19b88e0943fc.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_32%2Ctext_5bCa56GF6LC3IGF0Z3VpZ3UuY29t%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10" alt="image.png" style="zoom:80%;" />
