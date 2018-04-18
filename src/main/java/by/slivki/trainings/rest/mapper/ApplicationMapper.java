package by.slivki.trainings.rest.mapper;

import by.slivki.trainings.dao.jpa.Application;
import by.slivki.trainings.rest.dto.ApplicationDto;
import by.slivki.trainings.rest.dto.BaseApplicationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class ApplicationMapper {

    @Autowired
    private MessageSource messageSource;

    public List<BaseApplicationDto> toBaseApplicationDtos(List<Application> applications, Locale locale) {
        List<BaseApplicationDto> baseApplicationDtos = new ArrayList<>();
        if (applications != null) {
            for (Application application : applications) {
                baseApplicationDtos.add(toBaseApplicationDto(application, locale));
            }
        }
        return baseApplicationDtos;
    }

    public ApplicationDto toApplicationDto(Application application, Locale locale) {
        ApplicationDto applicationDto = new ApplicationDto();
        applicationDto.setId(application.getApplicationId());
        applicationDto.setType(messageSource.getMessage(
                "applications." + application.getApplicationType().getApplicationTypeName().toLowerCase(locale),
                null, locale));
        applicationDto.setMailOfReceiver(application.getUser().getEmail());
        applicationDto.setStatus(application.getStatus().getStatusName());
        applicationDto.setCreatedBy(application.getCreatedBy());
        applicationDto.setUpdatedBy(application.getUpdatedBy());
        applicationDto.setReceiver(application.getUser().getUsername());
        applicationDto.setDescription(application.getDescription());
        return applicationDto;
    }

    public BaseApplicationDto toBaseApplicationDto(Application application, Locale locale) {
        BaseApplicationDto baseApplicationDto = new BaseApplicationDto();
        baseApplicationDto.setId(application.getApplicationId());
        baseApplicationDto.setType(messageSource.getMessage(
                "applications." + application.getApplicationType().getApplicationTypeName().toLowerCase(locale),
                null, locale));
        baseApplicationDto.setMailOfReceiver(application.getUser().getEmail());
        baseApplicationDto.setStatus(application.getStatus().getStatusName());
        baseApplicationDto.setCreatedBy(application.getCreatedBy());
        baseApplicationDto.setUpdatedBy(application.getUpdatedBy());
        return baseApplicationDto;
    }
}
