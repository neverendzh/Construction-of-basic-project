import com.neverend.ApplicationContext;
import com.neverend.dao.AdminDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2018/2/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContext.class)
public class AdminDaoTest {

    @Autowired
    private AdminDao adminDao;
    @Test
    public void adminDao(){
        adminDao.save();
    }
}