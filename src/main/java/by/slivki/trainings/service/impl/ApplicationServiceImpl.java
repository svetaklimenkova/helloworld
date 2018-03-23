package by.slivki.trainings.service.impl;

import by.slivki.trainings.dao.api.ApplicationDao;
import by.slivki.trainings.dao.jpa.Application;
import by.slivki.trainings.dao.jpa.Status;
import by.slivki.trainings.dao.jpa.StatusEnum;
import by.slivki.trainings.service.api.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationDao applicationDao;

    @Override
    public Application createApplication(Application application) {
        return applicationDao.createApplication(application);
    }

    @Override
    public Application loadApplicationById(int id) {
        /*TODO*/
        return null;
    }

    @Override
    public List<Application> loadAll() {
        return applicationDao.loadAll();
    }

    @Override
    public Application updateStatusOfApplication(int applicationId, StatusEnum statusEnum) {
        Application application = applicationDao.loadById(applicationId);
        application.setStatus(new Status(statusEnum));
        application = applicationDao.modify(application);
        return application;
    }
}
