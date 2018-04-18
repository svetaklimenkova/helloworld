package by.slivki.trainings.dao.impl;

import by.slivki.trainings.TestConstants;
import by.slivki.trainings.TestGenerator;
import by.slivki.trainings.dao.api.UserRepository;
import by.slivki.trainings.dao.jpa.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserDaoTestNg extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getByCorrectIdShouldReturnCorrectUser() {
        // given
        int userId = TestConstants.USER_ID;

        // when
        User result = userRepository.findByUserId(userId);

        // then
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getUserId(), TestConstants.USER_ID);
        Assert.assertEquals(result.getUsername(), TestConstants.USER_NAME);
        Assert.assertEquals(result.getEmail(), TestConstants.USER_EMAIL);
    }

    @Test
    public void getByNonexistentIdShouldReturnNull() {
        // given
        int nonexistentId = 100;

        // when
        User result = userRepository.findByUserId(nonexistentId);

        // then
        Assert.assertNull(result);
    }

    @Test
    public void getByCorrectUsernameShouldReturnCorrectUser() {
        // given
        String username = TestConstants.USER_NAME;

        // when
        User result = userRepository.findByUsername(username);

        // then
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getUserId(), TestConstants.USER_ID);
        Assert.assertEquals(result.getUsername(), TestConstants.USER_NAME);
        Assert.assertEquals(result.getEmail(), TestConstants.USER_EMAIL);
    }

    @Test
    public void getByNonexistentUsernameShouldReturnNull() {
        // given
        String nonexistent = "nonexistent";

        // when
        User result = userRepository.findByUsername(nonexistent);

        // then
        Assert.assertNull(result);
    }

    @Test
    public void getByCorrectEmailShouldReturnCorrectUser() {
        // given
        String email = TestConstants.USER_EMAIL;

        // when
        User result = userRepository.findByEmail(email);

        // then
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getUserId(), TestConstants.USER_ID);
        Assert.assertEquals(result.getUsername(), TestConstants.USER_NAME);
        Assert.assertEquals(result.getEmail(), TestConstants.USER_EMAIL);
    }

    @Test
    public void getByNonexistentEmailShouldReturnNull() {
        // given
        String nonexistent = "nonexistent";

        // when
        User result = userRepository.findByEmail(nonexistent);

        // then
        Assert.assertNull(result);
    }

    @Test
    public void getAllShouldReturnedAllUsers() {
        // when
        List<User> users = userRepository.findAll();

        // then
        Assert.assertNotNull(users);
        Assert.assertEquals(users.size(), 2);
    }

    @Test
    public void createUserShouldCreatedUserInDataBase() {
        // given
        User user = TestGenerator.createUser();
        user.setUserId(0);

        // when
        userRepository.save(user);
        User created = userRepository.findByUsername(user.getUsername());

        // then
        Assert.assertNotNull(created);
        Assert.assertEquals(created.getUsername(), user.getUsername());
        Assert.assertEquals(created.getEmail(), user.getEmail());

        // after
        userRepository.delete(created);
    }

    @Test
    public void updateUserShouldUpdatedUserInDataBase() {
        // given
        String newUsername = "new username";
        User user = userRepository.findByUserId(TestConstants.USER_ID);
        user.setUsername(newUsername);

        // when
        User updated = userRepository.save(user);

        // then
        Assert.assertNotNull(updated);
        Assert.assertEquals(updated.getUsername(), newUsername);
    }

    @Test
    public void deleteUserShouldDeletedUserFromDataBase() {
        // given
        User user = TestGenerator.createUser();
        user.setUserId(0);
        userRepository.save(user);

        // when
        userRepository.delete(user);

        // then
        User deleted = userRepository.findByUsername(user.getUsername());
        Assert.assertNull(deleted);
    }
}