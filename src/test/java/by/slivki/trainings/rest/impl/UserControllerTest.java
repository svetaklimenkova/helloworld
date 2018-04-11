package by.slivki.trainings.rest.impl;

import by.slivki.trainings.rest.api.UserController;
import by.slivki.trainings.service.api.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserControllerTest {

    @Autowired
    private UserController userController;
    @MockBean
    private UserService userService;

    @Before
    public void setUp(){
        Mockito.when(userService.checkUsername(Mockito.anyString())).thenReturn(true);
        Mockito.when(userService.checkMail(Mockito.anyString())).thenReturn(true);
    }

    @Test
    public void isValidWithUsernameShouldReturnTrue() {
        // given
        String username = "test";

        // when
        Boolean result = (Boolean) userController.isValid(username, null).getBody();

        // then
        Assert.assertTrue(result);
    }

    @Test
    public void isValidWithMailShouldReturnTrue() {
        // given
        String mail = "test";

        // when
        Boolean result = (Boolean) userController.isValid(null, mail).getBody();

        // then
        Assert.assertTrue(result);
    }

    @Test
    public void isValidWithoutParamsShouldReturnFalse() {
        // when
        Boolean result = (Boolean) userController.isValid(null, null).getBody();

        // then
        Assert.assertFalse(result);
    }
}