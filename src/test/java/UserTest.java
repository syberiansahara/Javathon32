import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ru.team32.javathon.config.JpaConfig;
import ru.team32.javathon.entity.User;
import ru.team32.javathon.entity.repository.UserRepository;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { JpaConfig.class },
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class UserTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void givenUser_whenSave_thenGetOk() {
        User user = new User(1, "john");
        userRepository.save(user);

        User user2 = userRepository.findOne(1L);
        assertEquals("john", user2.getName());
    }
}