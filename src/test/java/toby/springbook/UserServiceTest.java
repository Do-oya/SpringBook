package toby.springbook;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import toby.springbook.user.dao.DaoFactory;
import toby.springbook.user.domain.Level;
import toby.springbook.user.domain.User;
import toby.springbook.user.domain.UserDaoJdbc;
import toby.springbook.user.service.UserService;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoFactory.class)
public class UserServiceTest {
    @Autowired private UserService userService;
    @Autowired private UserDaoJdbc userDao;

    List<User> users;

    @BeforeEach
    public void setUp() {
        users = Arrays.asList(
                new User("test1", "test1", "test1", Level.BASIC, 49, 0),
                new User("test2", "test2", "test2", Level.BASIC, 50, 0),
                new User("test3", "test3", "test3", Level.SILVER, 60, 29),
                new User("test4", "test4", "test4", Level.SILVER, 60, 30),
                new User("test5", "test5", "test5", Level.GOLD, 100, 100)
        );
    }

    @Test
    public void upgradeLevels() {
        userDao.deleteAll();
        for(User user : users) userDao.add(user);

        userService.upgradeLevels();

        checkLevel(users.get(0), Level.BASIC);
        checkLevel(users.get(1), Level.SILVER);
        checkLevel(users.get(2), Level.SILVER);
        checkLevel(users.get(3), Level.GOLD);
        checkLevel(users.get(4), Level.GOLD);
    }

    private void checkLevel(User user, Level expectedLevel) {
        User userUpdate = userDao.get(user.getId());
        assertThat(userUpdate.getLevel()).isEqualTo(expectedLevel);
    }

}
