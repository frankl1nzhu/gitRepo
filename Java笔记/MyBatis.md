## **MyBatis工程一般结构：**

*   src

    *   main

        *   java
        *   com.xxx.mybatis

            *   mapper ==（mapper接口层，定义增删改查操作）==
            *   pojo ==（普通java类，一般为数据的类型，如user）==
            *   utils ==（工具类，一般有SqlSessionUtil，用来直接获取sqlSession对象）==
        *   resources

            *   com/xxx/mybatis/mapper ==（mapper映射文件，需和mapper接口名称一致，写sql语句）==
            *   jdbc.properties ==（数据库驱动，地址，用户名，密码：以连接数据库）==
            *   mybatis-config.xml ==（需引入mapper映射文件包和定义pojo包类型别名）==
    *   test

id为mapper接口中操作的方法名

#### **增**：

*
    ```sql
    <insert id="insertUser">	
    	insert into t_user values(null,'admin','123456',23,'男','12345@qq.com') 
    </insert>*
    ```

#### **删**：&#x9;

```sql
<delete id="deleteUser">			
	delete from t_user where Id = 3	   
</delete>
```

#### **改**：

```sql
<update id="updateUser"> 			
	update t_user set username = 'root', password = '123456677' where Id = 3	   
</update>
```

#### **==查==**==：==

```sql
<select id="getUserById" resultType="com.mybatis.pojo.User"> 			
	select * from t_user where Id = #{Id}	   
</select>
```

```sql
<select id="getAllUser" resultType="User">      		
	select ** *from t_user      
</select>
```

查询操作需要有返回值，resultType或resultMap

查询结果为多条时，不能以实体类类型为返回值

## **测试**

通过SqlSessionUtil，可以直接获得sqlSession对象：`SqlSession sqlSession = SqlSessionUtil.`*`getSession`*`();`

&#x9;			   			而后	获取mapper代理实现类对象：`UserMapper mapper = sqlSession.getMapper(`*`UserMapper`*`.`*`class`*`);`

&#x20;   											调用mapper接口方法：`int result = mapper.insertUser();`

&#x9;																提交事务：`sqlSession.commit();`

&#x9;						     	  完成后关闭sqlSession对象：`sqlSession.close();`

### **获取参数值**

*#{} 和 \${}     	不同点为#{}会自动加单引号*

```sql
<insert id="insertUser">	 
	insert into t_user values(null,#{username},#{password},#{age},#{gender},#{email})
</insert>
```

#### **Parameter**

在形参前加@Param("别名")，可以使用注解的别名作为value属性值的键

```sql
<!--User checkLoginByParam(@Param("username1") String username, @Param("password1") String password);-->
<select id="checkLoginByParam" resultType="User">	 
	select * from t_user where username = #{username1} and password = #{password1}
</select>
```

### **特殊操作**

#### **模糊查询**

```sql
<!-- List<User> getUserByLike(@Param("mohu") String mohu);-->
<select id="getUserByLike" resultType="User">	 
	select * from t_user where username like "%"#{mohu}"%"
</select>
```

#### **批量删除**

```sql
<!--void deleteMoreUser(String ids);            只能使用${}-->
<select id="deleteMoreUser"> 	
	delete from t_user where Id in(${ids})
</select>
```

#### **动态处理表名**

```sql
<!--List<User> getUserList(@Param("tableName") String tableName);       只能用${}-->
<select id="getUserList" resultType="User"> 	
	select * from ${tableName}
</select>	
```

## **动态SQL**

1.  if:通过测试表达式判断标签中的内容是否有效（是否拼接到sql中）

    ```sql
    <select id="getEmpByConditionIf" resultType="Emp">
            select * from t_emp where
            <if test="empName != null and empName != ''">
                emp_name = #{empName}
            </if>
            <if test="age != null and age != ''">
                age = #{age}
            </if>
            <if test="gender != null and gender != ''">
                gender = #{gender}
            </if>
    </select>
    ```
2.  where:若标签中有条件成立，自动生成where关键字；自动去除内容前多余and；若都不成立，则无任何功能

    ```sql
        <select id="getEmpByConditionWhere" resultType="Emp">
            select * from t_emp
            <where>
                <if test="empName != null and empName != ''">
                    emp_name = #{empName}
                </if>
                <if test="age != null and age != ''">
                    age = #{age}
                </if>
                <if test="gender != null and gender != ''">
                    gender = #{gender}
                </if>
            </where>
        </select>
    ```
3.  trim:自动在前后生成或删除多余关键字

    ```sql
        <select id="getEmpByCondition" resultType="Emp">
            select * from t_emp
            <trim prefix="where" suffixOverrides="and">
                <if test="empName != null and empName != ''">
                    emp_name = #{empName} and
                </if>
                <if test="age != null and age != ''">
                    age = #{age} and
                </if>
                <if test="gender != null and gender != ''">
                    gender = #{gender}
                </if>
            </trim>
        </select>
    ```
4.  choose\:when，otherwise 相当于if...else...\
    &#x20;when至少一个，otherwise至多一个

    ```sql
        <!--List<Emp> getEmpByChoose(Emp emp);-->
        <select id="getEmpByChoose" resultType="emp">
            select * from t_emp
            <where>
                <choose>
                    <when test="empName != null and empName !=''">
                        emp_name = #{empName}
                    </when>
                    <when test="age != null and age !=''">
                        age = #{age}
                    </when>
                    <when test="gender != null and gender !=''">
                        gender = #{gender}
                    </when>
    
                </choose>
            </where>
        </select>
    ```
5.  sql片段：记录一段sql，在需要的地方用include引入

    ```sql
        <sql id="empColumns">
            emp_id,emp_name,age,gender,dept_id
        </sql>
    ```
6.  foreach批量添加和删除

    ```sql
        <!--void insertMoreEmp(List<Emp> emps);-->    
        <select id="insertMoreEmp">
            insert into t_emp values
            <foreach collection="emps" item="emp" separator=",">
                (null, #{emp.empName}, #{emp.age}, #{emp.gender}, null)
            </foreach>
        </select>
        <!--void deleteMoreEmp(@Param("empIds") Integer[] empIds);-->
        <select id="deleteMoreEmp">
            delete from t_emp where emp_id in
            <foreach collection="empIds" item="empId" separator="," open="(" close=")">
                #{empId}
            </foreach>
        </select>
    ```

## **缓存 cache**

在xml文件中   `<cache/>` 开启二级缓存

缓存查询数据：先二级再一级

**一级缓存是sqlSession级别**，即第一次通过同一个sqlSession查询的数据会被缓存，\
再次使用这个sqlSession查询同一条数据，会从缓存中获取\
使一级缓存失效的四种情况：

1.不同sqlSession\
2.同一个sqlSession：	a.查询条件不同\
&#x20;										b.两次查询期间进行了任何增删改\
&#x20;										c.两次查询期间手动清空了缓存

`sqlSession.clearCache();`    //清空一级缓存

**二级缓存是sqlSessionFactory级别**\*\
\*开启条件：\
1.映射文件中配置\<cache/>\
2.二级缓存必须在sqlSession关闭或提交后有效\
3.查询的数据实体类必须实现序列化接口\
失效条件：两次查询之间进行任意增删改

## **逆向工程 generator (MBG)**

1.  在resources中创建generatorConfig.xml文件
2.  修改其中数据库连接信息
3.  修改javaModelGenerator标签中的属性和地址
4.  javaClientGenerator标签
5.  table标签为要生成的目标表信息

常用方法：`mapper.selectByPrimaryKey(1);`     **根据id查询**

&#x9;			  `mapper.selectByExample(null);` 		**查询所有数据**

```java
根据条件查询：
EmpExample example = new EmpExample();						  example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThan(20);						  example.or().andGenderEqualTo("男");						  
List<Emp> list = mapper.selectByExample(example);
```

```java
普通修改：
Emp emp = new Emp(7,"小黑",10,"男",3);				  
mapper.updateByPrimaryKey(emp);
```

**选择性修改**（若有值为null，则跳过）

## **ResultMap**

#### 处理多对一映射：如根据empId获取emp和对应dept信息，多个emp对应一个dept

1.  级联关系映射：

    ```sql
    	<resultMap id="EmpAndDeptResultMapOne" type="Emp"> <!--级联方式--> 
    		<id column="emp_id" property="empId"/> 
    		<result column="emp_name" property="empName"/> 
    		<result column="age" property="age"/> 
    		<result column="gender" property="gender"/> 
    		<result column="dept_id" property="dept.deptId"/> 
    		<result column="dept_name" property="dept.deptName"/>
    	</resultMap>
    ```
2.  association：对于emp来说，对应dept内容可用association

    ```sql
        <resultMap id="EmpAndDeptResultMapTwo" type="Emp"> <!--association-->
            <id column="emp_id" property="empId"/>
            <result column="emp_name" property="empName"/>
            <result column="age" property="age"/>
            <result column="gender" property="gender"/>
            <association property="dept" javaType="Dept">
                <id column="dept_id" property="deptId"/>
                <result column="dept_name" property="deptName"/>
            </association>
        </resultMap>
    ```

**使用：**

```sql
    <!--    Emp getEmpAndDeptByEmpId(@Param("empId") int id);-->
    <select id="getEmpAndDeptByEmpId" resultMap="EmpAndDeptResultMapTwo">
        select *
        from t_emp
        left join t_dept
        on t_emp.dept_id = t_dept.dept_id
        where t_emp.emp_id = #{empId}
    </select>
```

#### 处理一对多映射：如根据deptId获取所有包含emp和dept

1.  collection

    ```sql
        <!--一对多collection-->
        <resultMap id="deptAndEmpResultMap" type="Dept">
            <id column="dept_id" property="deptId"/>
            <result column="dept_name" property="deptName"/>
            <collection property="emps" ofType="Emp">
                <id column="emp_id" property="empId"/>
                <result column="emp_name" property="empName"/>
                <result column="age" property="age"/>
                <result column="gender" property="gender"/>
            </collection>
        </resultMap>
    ```

**使用：**

```sql
    <!--Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);-->
    <select id="getDeptAndEmpByDeptId" resultMap="deptAndEmpResultMap">
        SELECT *
        FROM t_dept
        LEFT JOIN t_emp
        ON t_dept.dept_id = t_emp.dept_id
        WHERE t_dept.dept_id = #{deptId}
    </select>
```

### 分步查询：在association或collection基础上，利用其中select标签实现

多对一：

```sql
    <resultMap id="EmpAndDeptResultByStep" type="Emp"> <!--association分步查询-->
        <id column="emp_id" property="empId"/>
        <result column="emp_name" property="empName"/>
        <result column="age" property="age"/>
        <result column="gender" property="gender"/>
        <!--
            property：需要处理的映射属性名
            select：设置分步查询的sql的唯一标识，即第二步方法名
            column：设置分步查询的条件字段
            fetchType：在开启延迟加载的环境中，通过该属性设置当前分步查询是否使用延迟加载
                        eagle|lazy
        -->
        <association property="dept" fetchType="lazy"
                     select="com.mybatis.mapper.DeptMapper.getEmpAndDeptByStepTwo"
                     column="dept_id">
        </association>
    </resultMap>
```

使用：EmpMapper第一步，DeptMapper第二步

```sql
    <!-- Emp getEmpAndDeptByStepOne(@Param("empId") int empId);-->
    <select id="getEmpAndDeptByStepOne" resultMap="EmpAndDeptResultByStep">
        select * from t_emp where emp_id = #{empId}
    </select>
```

```sql
    <!--Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);-->
    <select id="getEmpAndDeptByStepTwo" resultType="dept">
        select * from t_dept where dept_id = #{deptId}
    </select>
```

一对多同理，association改为collection

```sql
    <resultMap id="DeptAndEmpResultMapByStep" type="Dept">
        <id column="dept_id" property="deptId"/>
        <result column="dept_name" property="deptName"/>
        <collection property="emps"
                    select="com.mybatis.mapper.EmpMapper.getDeptAndEmpByStepTwo"
                    column="dept_id"/>
    </resultMap>
```

