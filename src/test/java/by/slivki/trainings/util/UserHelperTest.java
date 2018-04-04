package by.slivki.trainings.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserHelperTest {

    @Autowired
    private UserHelper userHelper;

    @Test
    @WithMockUser(username = "user")
    public void getCurrentUserWithAuthenticatedUserShouldReturnedCorrectUser() throws Exception {
        // when
        UserDetails currentUser = userHelper.getCurrentUser();

        // then
        Assert.assertNotNull(currentUser);
        Assert.assertEquals("user", currentUser.getUsername());
    }

    @Test
    public void getCurrentUserWithoutAuthenticatedUserShouldReturnedNull() throws Exception {
        // when
        UserDetails currentUser = userHelper.getCurrentUser();

        // then
        Assert.assertNull(currentUser);
    }
}