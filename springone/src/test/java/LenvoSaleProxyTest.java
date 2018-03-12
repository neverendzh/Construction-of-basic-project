import com.neverend.proxy.*;
import org.junit.Test;

/**
 * Created by Administrator on 2018/2/25.
 */
public class LenvoSaleProxyTest {
    @Test
    public void Proxy(){
        Lenvo lenvo = new Lenvo();
        Dell dell = new Dell();
        Proxy proxy = new Proxy(dell);
        proxy.salePc();
    }

    @Test

    public void MyinvocationHandlerTest(){

        Dell dell = new Dell();

        MyInvocationHandler invocationHandler = new MyInvocationHandler(dell);

        Salse salse = (Salse) java.lang.reflect.Proxy.newProxyInstance(dell.getClass().getClassLoader(),dell.getClass().getInterfaces(),invocationHandler);

        salse.salePc();

    }
}