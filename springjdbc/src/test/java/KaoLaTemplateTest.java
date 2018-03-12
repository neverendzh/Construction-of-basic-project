import com.neverend.dao.KaoLaDao;
import com.neverend.entity.KaoLa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2018/2/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class KaoLaTemplateTest {

    @Autowired
    private KaoLaDao kaoLaDao;
    @Test
    public void findbayid(){
        KaoLa kaoLa = kaoLaDao.findById(2177);
        System.out.println(kaoLa.getProductName());
    }


}