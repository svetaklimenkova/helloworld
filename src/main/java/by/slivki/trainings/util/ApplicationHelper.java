package by.slivki.trainings.util;

import by.slivki.trainings.dao.jpa.Application;
import by.slivki.trainings.dao.jpa.ApplicationType;
import by.slivki.trainings.dao.jpa.ApplicationTypeEnum;
import by.slivki.trainings.dao.jpa.Status;
import by.slivki.trainings.dao.jpa.StatusEnum;
import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.exception.ErrorCode;
import by.slivki.trainings.exception.RestException;
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

    public void checkApplicationHasNoStatus(Application application, StatusEnum status) {
        if (application.getStatus().getStatusId() == status.getI()) {
            throw new RestException(ErrorCode.APPLICATION_TO_DELETE_SHOULD_NOT_BE_IN_PROGRESS, null);
        }
    }
}
