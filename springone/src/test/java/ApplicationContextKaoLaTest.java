import com.neverend.entity.KaoLa;
import com.neverend.service.KaoLaService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/2/25.
 */
public class ApplicationContextKaoLaTest {
    @Test
    public void testDao(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        KaoLa kaola = (KaoLa) applicationContext.getBean("kaoLa");
        kaola.save();


        /*KaoLaService kaoLaService = (KaoLaService) applicationContext.getBean("kaoLaService");
        kaoLaService.save();*/
    }
}