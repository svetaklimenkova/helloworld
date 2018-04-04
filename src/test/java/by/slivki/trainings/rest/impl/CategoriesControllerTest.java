package by.slivki.trainings.rest.impl;

import by.slivki.trainings.TestConstants;
import by.slivki.trainings.rest.dto.CategoryDto;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@SqlGroup({
        @Sql(scripts = "classpath:sql/all_create.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        @Sql(scripts = "classpath:sql/all_drop.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
})
@TestPropertySource(locations = "classpath:application-test.properties")
public class CategoriesControllerTest extends AbstractTestNGSpringContextTests {

    @LocalServerPort
    private int port;

    @Test
    public void testGetAllShouldReturnedAllCategories() throws Exception {
        // when
        ResponseEntity<List> responseEntity =
                new TestRestTemplate().getForEntity(TestConstants.URI + port + "/rest/categories", List.class);
        List categories = responseEntity.getBody();

        // then
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertNotNull(categories);
        Assert.assertEquals(((CategoryDto)categories.get(0)).getCategoryName(), "test category 1");
        Assert.assertEquals(categories.size(), 2);
    }

}