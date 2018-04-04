package by.slivki.trainings.rest.mapper;

import by.slivki.trainings.TestGenerator;
import by.slivki.trainings.dao.jpa.Application;
import by.slivki.trainings.rest.dto.BaseApplicationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ApplicationMapperTestNg extends AbstractTestNGSpringContextTests {

    @Autowired
    private ApplicationMapper mapper;

    @Test
    public void toBaseApplicationDtosWithNullShouldReturnedEmptyList() throws Exception {
        // when
        List<BaseApplicationDto> result = mapper.toBaseApplicationDtos(null);

        //then
        Assert.assertNotNull(result);
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void toBaseApplicationDtosWithCorrectParamsShouldReturnedCorrectList() throws Exception {
        // given
        List<Application> applications = Arrays.asList(
                TestGenerator.createApplication(1),
                TestGenerator.createApplication(2)
        );

        // when
        List<BaseApplicationDto> result = mapper.toBaseApplicationDtos(applications);

        //then
        Assert.assertNotNull(result);
        Assert.assertEquals(applications.size(), result.size());
        Assert.assertEquals(applications.get(0).getApplicationId(), result.get(0).getId());
        Assert.assertEquals(applications.get(0).getUser().getEmail(), result.get(0).getMailOfReceiver());
        Assert.assertEquals(applications.get(0).getStatus().getStatusName(), result.get(0).getStatus());
        Assert.assertEquals(applications.get(0).getApplicationType().getApplicationTypeName(), result.get(0).getType());
    }
}