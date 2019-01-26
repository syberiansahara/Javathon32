import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ru.sbt.ds.config.UserJpaConfig;
import ru.sbt.ds.entity.User;
import ru.sbt.ds.entity.repository.UserRepository;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { UserJpaConfig.class },
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