package by.slivki.trainings.service.impl;

import by.slivki.trainings.dao.api.ApplicationRepository;
import by.slivki.trainings.dao.api.UserRepository;
import by.slivki.trainings.dao.jpa.Application;
import by.slivki.trainings.dao.jpa.ApplicationTypeEnum;
import by.slivki.trainings.dao.jpa.Status;
import by.slivki.trainings.dao.jpa.StatusEnum;
import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.service.api.ApplicationService;
import by.slivki.trainings.util.ApplicationHelper;
import by.slivki.trainings.util.UserHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationServiceImpl.class);

    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private ApplicationHelper applicationHelper;
    @Autowired
    private UserHelper userHelper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public Application create(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public Application getApplicationById(int id) {
        return applicationRepository.findByApplicationId(id);
    }

    @Override
    public void deleteApplicationById(int id) {
        Application application = applicationRepository.findByApplicationId(id);
        applicationHelper.checkApplicationHasNoStatus(application, StatusEnum.IN_PROGRESS);
        applicationRepository.deleteById(id);

        if (application.getStatus().getStatusName().equalsIgnoreCase(StatusEnum.REJECTED.name())) {
            userRepository.delete(application.getUser());
        }
    }

    @Override
    public List<Application> loadAll() {
        return applicationRepository.findAll();
    }

    @Override
    public List<Application> loadAllByUserId(int id) {
        return applicationRepository.findByUser_UserId(id);
    }

    @Override
    public Application updateStatus(int applicationId, StatusEnum statusEnum) {
        Application application = applicationRepository.findByApplicationId(applicationId);
        application.setStatus(new Status(statusEnum));
        application.setUpdatedBy(new Date());
        application = applicationRepository.save(application);
        return application;
    }

    @Override
    public void processApplication(Application application) {
        if (application.getStatus().getStatusName().equals(StatusEnum.ACCEPTED.name())) {
            acceptApplication(application);
        } else if (application.getStatus().getStatusName().equals(StatusEnum.REJECTED.name())) {
            rejectApplication(application);
        }
    }

    private void acceptApplication(Application application) {
        if (application.getApplicationType().getApplicationTypeName()
                .equals(ApplicationTypeEnum.TRAINER.name())) {
            User user = application.getUser();
            user.setConfirmed(true);
            userRepository.save(user);

        } else if (application.getApplicationType().getApplicationTypeName()
                .equals(ApplicationTypeEnum.PASSWORD.name())) {
            User user = application.getUser();
            String password = userHelper.generatePassword();
            user.setPassword(encoder.encode(password));

            logger.info(String.format("USER: %s || PASSWORD: %s", user.getUsername(), password));

            userRepository.save(user);
        }
    }

    private void rejectApplication(Application application) {

    }
}
