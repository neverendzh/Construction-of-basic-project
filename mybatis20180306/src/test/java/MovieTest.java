import com.neverend.entity.Movie;
import com.neverend.entity.User;
import com.neverend.mapper.MovieMapper;
import com.neverend.service.Java8New;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/6.
 */
public class MovieTest {
    @Test
    public void findAll(){
        SqlSession sqlSession = null;
        try {
            Reader reader =  Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
             sqlSession = sessionFactory.openSession();
            MovieMapper movieMapper = sqlSession.getMapper(MovieMapper.class);
            List<Movie> movieList = movieMapper.find();
            for (Movie m: movieList) {
                System.out.println(m);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void tsetjava8(){
        Java8New java8New = new Java8New() {
            @Override
            public void find() {
                System.out.println("1");
            }

            @Override
            public String find1() {
                return "2";
            }

            @Override
            public List<User> user() {
                return new ArrayList<>();
            }
        };
        User user = new User(1,"admin");
        String user1 = java8New.findUser(user).toString();
        System.out.println(user1);
    }

    @Test
    public void exception(){
        for(int i =0;i<200000000;i++){
            for(int j = 0;j<200000000;j++){
                int [] arr = new int[2000000000];
            }
        }
    }
}