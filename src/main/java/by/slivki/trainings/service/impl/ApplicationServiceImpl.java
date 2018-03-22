package by.slivki.trainings.service.impl;

import by.slivki.trainings.dao.api.ApplicationDao;
import by.slivki.trainings.dao.jpa.Application;
import by.slivki.trainings.service.api.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }
}
