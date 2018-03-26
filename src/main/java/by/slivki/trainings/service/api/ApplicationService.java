package by.slivki.trainings.service.api;

import by.slivki.trainings.dao.jpa.Application;
import by.slivki.trainings.dao.jpa.StatusEnum;

import java.util.List;

public interface ApplicationService {
    /**
     * Creates new application.
     *
     * @param application application
     *
     * @return application
     * */
    Application create(Application application);

    /**
     * Loads application by id.
     *
     * @param id application id
     *
     * @return application
     * */
    Application getApplicationById(int id);

    /**
     * Deletes application by id.
     *
     * @param id application id
     *
     * */
    void deleteApplicationById(int id);

    /**
     * Loads all applications.
     *
     * @return applications
     * */
    List<Application> loadAll();

    /**
     * Loads all applications by user id.
     *
     * @return applications
     * */
    List<Application> loadAllByUserId(int id);

    /**
     * Update status of application.
     *
     * @param applicationId application id
     * @param statusEnum status
     *
     * @return application
     * */
    Application updateStatus(int applicationId, StatusEnum statusEnum);
}
