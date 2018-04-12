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
    public void toBaseApplicationDtosWithNullShouldReturnedEmptyList() {
        // when
        List<BaseApplicationDto> result = mapper.toBaseApplicationDtos(null);

        //then
        Assert.assertNotNull(result);
        Assert.assertEquals(result.size(), 0);
    }

    @Test
    public void toBaseApplicationDtosWithCorrectParamsShouldReturnedCorrectList() {
        // given
        List<Application> applications = Arrays.asList(
                TestGenerator.createApplication(1),
                TestGenerator.createApplication(2)
        );

        // when
        List<BaseApplicationDto> result = mapper.toBaseApplicationDtos(applications);

        //then
        Assert.assertNotNull(result);
        Assert.assertEquals(result.size(), applications.size());
        Assert.assertEquals(result.get(0).getId(), applications.get(0).getApplicationId());
        Assert.assertEquals(result.get(0).getMailOfReceiver(), applications.get(0).getUser().getEmail());
        Assert.assertEquals(result.get(0).getStatus(), applications.get(0).getStatus().getStatusName());
        Assert.assertEquals(result.get(0).getType(), applications.get(0).getApplicationType().getApplicationTypeName());
    }
}