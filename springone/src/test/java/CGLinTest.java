import com.neverend.entity.KaoLa;
import com.neverend.proxy.CgLibProxyMotherdInterceptor;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

/**
 * Created by Administrator on 2018/2/25.
 */
public class CGLinTest {

    @Test
    public void KaoLaCGLin(){

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(KaoLa.class);
        enhancer.setCallback(new CgLibProxyMotherdInterceptor());
        KaoLa kaoLa =  (KaoLa) enhancer.create();
        kaoLa.save();

    }
}