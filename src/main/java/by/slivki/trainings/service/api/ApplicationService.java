package by.slivki.trainings.service.api;

import by.slivki.trainings.dao.jpa.Application;
import by.slivki.trainings.dao.jpa.StatusEnum;
import by.slivki.trainings.dao.jpa.User;

import java.util.List;

public interface ApplicationService {
    /**
     * Creates new application.
     *
     * @param application application
     *
     * @return application
     * */
    Application createApplication(Application application);

    /**
     * Loads application by id.
     *
     * @param id application id
     *
     * @return application
     * */
    Application loadApplicationById(int id);

    /**
     * Loads all applications.
     *
     * @return applications
     * */
    List<Application> loadAll();

    /**
     * Update status of application.
     *
     * @param applicationId application id
     * @param statusEnum status
     *
     * @return application
     * */
    Application updateStatusOfApplication(int applicationId, StatusEnum statusEnum);
}
