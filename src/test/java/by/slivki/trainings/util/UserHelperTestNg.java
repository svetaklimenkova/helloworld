package by.slivki.trainings.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithSecurityContextTestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint.SYSTEM_ERR;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;

@SpringBootTest(webEnvironment = MOCK)
@AutoConfigureMockMvc(print = SYSTEM_ERR)
@TestExecutionListeners(WithSecurityContextTestExecutionListener.class)
public class UserHelperTestNg extends AbstractTestNGSpringContextTests {

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