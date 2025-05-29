import com.example.project.domain.repository.ProductRepository;
import jakarta.annotation.Resource;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaServerApplicationTests {
    @Resource
    private ProductRepository productRepository;

    /*@Test
    public void countByAge() {
        System.out.println(productRepository.findByProductName("beef").get(0));
    }*/
}
