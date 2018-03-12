import com.neverend.entity.Movie;
import com.neverend.service.MovieService;
import com.neverend.service.impl.MovieServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2018/2/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MoviceServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    public void save(){
        Movie movie = new Movie();
        movie.setName("jak");
        movie.setPassword("123");
        movieService.save(movie);
    }

}