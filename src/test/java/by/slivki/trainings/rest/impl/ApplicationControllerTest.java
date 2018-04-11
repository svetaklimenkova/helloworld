package by.slivki.trainings.rest.impl;

import by.slivki.trainings.exception.ErrorCode;
import by.slivki.trainings.util.RestMessage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class ApplicationControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @WithMockUser(authorities = "ROLE_ADMIN")
    public void deleteApplicationWithInProgressStatusShouldReturnErrorMessage() {
        // when
        TestRestTemplate testRestTemplate = new TestRestTemplate("user", "pass");
        ResponseEntity<RestMessage> responseEntity =
                restTemplate.exchange("/rest/applications/1", HttpMethod.DELETE,
                        null, RestMessage.class);
        RestMessage message = responseEntity.getBody();

        // then
        Assert.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        Assert.assertEquals(ErrorCode.APPLICATION_SHOULD_NOT_BE_WITH_CURRENT_STATUS, message.getCode());
    }
}