package by.slivki.trainings.service.impl;

import by.slivki.trainings.dao.api.ApplicationDao;
import by.slivki.trainings.dao.api.UserDao;
import by.slivki.trainings.dao.jpa.Application;
import by.slivki.trainings.dao.jpa.ApplicationTypeEnum;
import by.slivki.trainings.dao.jpa.Status;
import by.slivki.trainings.dao.jpa.StatusEnum;
import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.service.api.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationDao applicationDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Application create(Application application) {
        return applicationDao.create(application);
    }

    @Override
    public Application getApplicationById(int id) {
        return applicationDao.getById(id);
    }

    @Override
    public void deleteApplicationById(int id) {
        applicationDao.delete(applicationDao.getById(id));
    }

    @Override
    public List<Application> loadAll() {
        return applicationDao.getAll();
    }

    @Override
    public List<Application> loadAllByUserId(int id) {
        return applicationDao.getAllByUserId(id);
    }

    @Override
    public Application updateStatus(int applicationId, StatusEnum statusEnum) {
        Application application = applicationDao.getById(applicationId);
        application.setStatus(new Status(statusEnum));
        application.setUpdatedBy(new Date());
        application = applicationDao.update(application);
        return application;
    }

    @Override
    public void processApplication(Application application) {
        if (application.getStatus().getStatusName().equals(StatusEnum.ACCEPTED.name())) {
            if (application.getApplicationType().getApplicationTypeName().equals(ApplicationTypeEnum.TRAINER.name())) {
                User user = application.getUser();
                user.setConfirmed(true);
                userDao.update(user);
            }
        }
    }
}
