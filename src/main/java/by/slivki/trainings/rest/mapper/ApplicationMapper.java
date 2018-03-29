package by.slivki.trainings.rest.mapper;

import by.slivki.trainings.dao.jpa.Application;
import by.slivki.trainings.rest.dto.ApplicationDto;
import by.slivki.trainings.rest.dto.BaseApplicationDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationMapper {

    public List<BaseApplicationDto> toBaseApplicationDtos(List<Application> applications) {
        List<BaseApplicationDto> baseApplicationDtos = new ArrayList<>();
        if (applications != null) {
            for (Application application : applications) {
                baseApplicationDtos.add(toBaseApplicationDto(application));
            }
        }
        return baseApplicationDtos;
    }

    public ApplicationDto toApplicationDto(Application application) {
        ApplicationDto applicationDto = new ApplicationDto();
        applicationDto.setId(application.getApplicationId());
        applicationDto.setType(application.getApplicationType().getApplicationTypeName());
        applicationDto.setMailOfReceiver(application.getUser().getEmail());
        applicationDto.setStatus(application.getStatus().getStatusName());
        applicationDto.setCreatedBy(application.getCreatedBy());
        applicationDto.setUpdatedBy(application.getUpdatedBy());
        applicationDto.setReceiver(application.getUser().getUsername());
        applicationDto.setDescription(application.getDescription());
        return applicationDto;
    }

    public BaseApplicationDto toBaseApplicationDto(Application application) {
        BaseApplicationDto baseApplicationDto = new BaseApplicationDto();
        baseApplicationDto.setId(application.getApplicationId());
        baseApplicationDto.setType(application.getApplicationType().getApplicationTypeName());
        baseApplicationDto.setMailOfReceiver(application.getUser().getEmail());
        baseApplicationDto.setStatus(application.getStatus().getStatusName());
        baseApplicationDto.setCreatedBy(application.getCreatedBy());
        baseApplicationDto.setUpdatedBy(application.getUpdatedBy());
        return baseApplicationDto;
    }
}
