package by.slivki.trainings.util;

import by.slivki.trainings.dao.jpa.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ApplicationHelper {
    public Application generate(User user, ApplicationTypeEnum applicationType, String description) {
        Application application = new Application();
        application.setApplicationType(new ApplicationType(applicationType));
        application.setDescription(description);
        application.setUser(user);
        application.setStatus(new Status(StatusEnum.IN_PROGRESS));
        application.setCreatedBy(new Date());
        application.setUpdatedBy(new Date());
        return application;
    }
}
