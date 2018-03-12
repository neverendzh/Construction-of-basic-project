import com.neverend.dao.UserDao;
import com.neverend.service.UserService;
import com.neverend.service.impl.UserserviceMpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/2/25.
 */
public class UserDaoTest {

    @Test
    public void userdao(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.save();;
    }

    @Test
    public void save(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userserviceMpl = (UserService) applicationContext.getBean("userserviceMpl");
        userserviceMpl.save();
    }
}