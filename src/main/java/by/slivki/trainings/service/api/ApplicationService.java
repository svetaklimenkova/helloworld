package by.slivki.trainings.service.api;

import by.slivki.trainings.dao.jpa.Application;
import by.slivki.trainings.dao.jpa.User;

import java.util.List;

public interface ApplicationService {
    /**
     * Creates new application.
     *
     * @param application application
     * */
    Application createApplication(Application application);

}
