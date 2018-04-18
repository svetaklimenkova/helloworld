package by.slivki.trainings.rest.mapper;

import by.slivki.trainings.TestGenerator;
import by.slivki.trainings.dao.jpa.Application;
import by.slivki.trainings.rest.dto.BaseApplicationDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationMapperTest {

    @Autowired
    private ApplicationMapper mapper;

    @Test
    public void toBaseApplicationDtosWithNullShouldReturnedEmptyList() {
        // when
        List<BaseApplicationDto> result = mapper.toBaseApplicationDtos(null, Locale.getDefault());

        //then
        Assert.assertNotNull(result);
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void toBaseApplicationDtosWithCorrectParamsShouldReturnedCorrectList() {
        // given
        List<Application> applications = Arrays.asList(
                TestGenerator.createApplication(1),
                TestGenerator.createApplication(2)
        );

        // when
        List<BaseApplicationDto> result = mapper.toBaseApplicationDtos(applications, Locale.getDefault());

        //then
        Assert.assertNotNull(result);
        Assert.assertEquals(applications.size(), result.size());
        Assert.assertEquals(applications.get(0).getApplicationId(), result.get(0).getId());
        Assert.assertEquals(applications.get(0).getUser().getEmail(), result.get(0).getMailOfReceiver());
        Assert.assertEquals(applications.get(0).getStatus().getStatusName(), result.get(0).getStatus());
    }
}