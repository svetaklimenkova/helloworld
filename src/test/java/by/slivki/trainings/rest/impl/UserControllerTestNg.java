package by.slivki.trainings.rest.impl;

import by.slivki.trainings.rest.api.UserController;
import by.slivki.trainings.service.api.UserService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.*;

@SpringBootTest
public class UserControllerTestNg extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeMethod
    public void setUp(){
        MockitoAnnotations.initMocks(this);
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