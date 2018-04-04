package by.slivki.trainings.dao.impl;

import by.slivki.trainings.TestConstants;
import by.slivki.trainings.dao.api.UserDao;
import by.slivki.trainings.dao.jpa.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void getByCorrectIdShouldReturnCorrectUser() {
        // given
        int userId = TestConstants.USER_ID;

        // when
        User result = userDao.getById(userId);

        // then
        Assert.assertNotNull(result);
        Assert.assertEquals(TestConstants.USER_ID, result.getUserId());
        Assert.assertEquals(TestConstants.USER_NAME, result.getUsername());
        Assert.assertEquals(TestConstants.USER_EMAIL, result.getEmail());
    }

    @Test
    public void getByNonexistentIdShouldReturnNull() {
        // given
        int nonexistentId = 100;

        // when
        User result = userDao.getById(nonexistentId);

        // then
        Assert.assertNull(result);
    }

    @Test
    public void getByCorrectUsernameShouldReturnCorrectUser() {
        // given
        String username = TestConstants.USER_NAME;

        // when
        User result = userDao.getByUsername(username);

        // then
        Assert.assertNotNull(result);
        Assert.assertEquals(TestConstants.USER_ID, result.getUserId());
        Assert.assertEquals(TestConstants.USER_NAME, result.getUsername());
        Assert.assertEquals(TestConstants.USER_EMAIL, result.getEmail());
    }

    @Test
    public void getByNonexistentUsernameShouldReturnNull() {
        // given
        String nonexistent = "nonexistent";

        // when
        User result = userDao.getByUsername(nonexistent);

        // then
        Assert.assertNull(result);
    }

    @Test
    public void getByCorrectEmailShouldReturnCorrectUser() {
        // given
        String email = TestConstants.USER_EMAIL;

        // when
        User result = userDao.getByMail(email);

        // then
        Assert.assertNotNull(result);
        Assert.assertEquals(TestConstants.USER_ID, result.getUserId());
        Assert.assertEquals(TestConstants.USER_NAME, result.getUsername());
        Assert.assertEquals(TestConstants.USER_EMAIL, result.getEmail());
    }

    @Test
    public void getByNonexistentEmailShouldReturnNull() {
        // given
        String nonexistent = "nonexistent";

        // when
        User result = userDao.getByMail(nonexistent);

        // then
        Assert.assertNull(result);
    }

    @Test
    public void getAllShouldReturnedAllUsers() {
        // when
        List<User> users = userDao.getAll();

        // then
        Assert.assertNotNull(users);
        Assert.assertEquals(2, users.size());
    }
}