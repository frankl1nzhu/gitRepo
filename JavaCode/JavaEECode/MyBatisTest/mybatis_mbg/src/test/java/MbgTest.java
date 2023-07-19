import com.mybatis.mapper.EmpMapper;
import com.mybatis.pojo.Emp;
import com.mybatis.pojo.EmpExample;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MbgTest {
    @Test
    public void testMbg() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        /*根据id查询数据
        Emp emp = mapper.selectByPrimaryKey(1);
        System.out.println(emp);*/

        /*查询所有数据
        list<emp> list = mapper.selectByExample(null);
        list.foreach(System.out::println)*/

        //根据条件查询
        EmpExample example = new EmpExample();
        example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThan(20);
        example.or().andGenderEqualTo("男");
        List<Emp> list = mapper.selectByExample(example);
        list.forEach(System.out::println);

        //测试普通修改功能
        Emp emp = new Emp(7,"小黑",10,"男",3);
        mapper.updateByPrimaryKey(emp);
        //选择性修改updateByPrimaryKeySelective：区别为如果新数据中有字段为null，则不修改该字段；
        //而普通修改为将其修改为null
    }
}
