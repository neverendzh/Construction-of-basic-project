import com.github.pagehelper.PageHelper;
import com.neverend.entity.Kaola;
import com.neverend.entity.KaolaExample;
import com.neverend.mapper.KaolaMapper;
import com.neverend.util.MybatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2018/2/25.
 */
public class KaoLaMapperTest {
    private SqlSession sqlSession;
    @Before
    public void getSqlSession(){
        SqlSessionFactory sessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
        sqlSession = sessionFactory.openSession(true);
    }

    @After
    public void closeSqlsession(){
        sqlSession.close();
    }

    @Test
    public void findById(){
        KaolaMapper kaolaMapper = sqlSession.getMapper(KaolaMapper.class);
        Kaola kaola = kaolaMapper.selectByPrimaryKey(2177);
        System.out.println(kaola);
    }

    @Test
    public void selectName(){
        PageHelper.startPage(0,5);
        KaolaExample kaolaExample = new KaolaExample();
        KaolaExample.Criteria criteria = kaolaExample.createCriteria();
        criteria.andProductNameLike("%陈伟霆%");
        criteria.andPlaceLike("%中国%");
        KaolaMapper kaolaMapper = sqlSession.getMapper(KaolaMapper.class);
        List<Kaola> kaolas = kaolaMapper.selectByExample(kaolaExample);
        for(Kaola kaola : kaolas){
            System.out.println(kaola);
        }
    }
}