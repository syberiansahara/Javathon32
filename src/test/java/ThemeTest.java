import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ru.team32.javathon.config.JpaConfig;
import ru.team32.javathon.entity.Theme;
import ru.team32.javathon.entity.repository.UserRepository;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { JpaConfig.class },
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class ThemeTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void givenUser_whenSave_thenGetOk() {
        Theme theme = new Theme(1, "john");
        userRepository.save(theme);

        Theme theme2 = userRepository.findOne(1L);
        assertEquals("john", theme2.getTheme());
    }
}