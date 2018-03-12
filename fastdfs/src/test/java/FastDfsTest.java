import org.apache.commons.io.IOUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2018/3/11.
 */
public class FastDfsTest {
    @Test
    public void upLoader() throws IOException, MyException {
        Properties properties = new Properties();
        properties.setProperty(ClientGlobal.PROP_KEY_TRACKER_SERVERS,"42.24.339.43:22122");
            ClientGlobal.initByProperties(properties);
        TrackerClient client  = new TrackerClient();
        TrackerServer trackerServer = client.getConnection();
        StorageServer storageServer = new StorageServer("42.24.339.43:22122",1);
//        存储客户端
        StorageClient storageClient = new StorageClient(trackerServer,storageServer);
        InputStream inputStream = new FileInputStream("D:/12.txt");
        System.out.println(inputStream.toString());
//        byte [] bytes = IOUtils.toByteArray(inputStream);
       String [] strings = storageClient.upload_file(IOUtils.toByteArray(inputStream),".txt",null);
           for (int i = 0;i<strings.length;i++){
               System.out.println(strings[i]);
       }

    }
}