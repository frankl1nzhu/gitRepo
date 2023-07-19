import com.mybatis.mapper.CacheMapper;
import com.mybatis.pojo.Emp;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/*缓存查询顺序：先查二级，没有再查一级，没有则查数据库
*
* sqlSession关闭后，一级缓存写入二级缓存*/

public class CacheMapperTest {
    @Test
    public void testCache() throws Exception {
        /*二级缓存是sqlSessionFactory级别
        *
        * 开启条件：
        * 1.映射文件中配置<cache/>
        * 2.二级缓存必须在sqlSession关闭或提交后有效
        * 3.查询的数据实体类必须实现序列化接口
        *
        * 失效条件：两次查询之间进行任意增删改
        * */
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpById(1);
        System.out.println(emp2);
    }
    @Test
    public void testGetEmpById(){
        /*一级缓存是sqlSession级别，即第一次通过同一个sqlSession查询的数据会被缓存，
        再次使用这个sqlSession查询同一条数据，会从缓存中获取

        使一级缓存失效的四种情况：1.不同sqlSession
        2.同一个sqlSession：a.查询条件不同
                           b.两次查询期间进行了任何增删改
                           c.两次查询期间手动清空了缓存
         */
        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp = mapper1.getEmpById(1);
        System.out.println(emp);
        sqlSession1.clearCache();  //清空一级缓存

    }
}
