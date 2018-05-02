package by.slivki.trainings.rest.impl;

import by.slivki.trainings.dao.jpa.Application;
import by.slivki.trainings.dao.jpa.ApplicationTypeEnum;
import by.slivki.trainings.dao.jpa.Role;
import by.slivki.trainings.dao.jpa.RoleEnum;
import by.slivki.trainings.dao.jpa.StatusEnum;
import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.rest.api.ApplicationController;
import by.slivki.trainings.rest.dto.BaseApplicationDto;
import by.slivki.trainings.rest.dto.StatusDto;
import by.slivki.trainings.rest.dto.TrainerApplicationDto;
import by.slivki.trainings.rest.mapper.ApplicationMapper;
import by.slivki.trainings.service.api.ApplicationService;
import by.slivki.trainings.service.api.UserService;
import by.slivki.trainings.util.ApplicationHelper;
import by.slivki.trainings.util.UserHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/rest/applications")
public class ApplicationControllerImpl implements ApplicationController {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationControllerImpl.class);

    @Autowired
    private UserService userService;
    @Autowired
    private UserHelper userHelper;

    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private ApplicationMapper applicationMapper;
    @Autowired
    private ApplicationHelper applicationHelper;

    /**
     * {@inheritDoc}
     * */
    @Override
    public ResponseEntity<?> createApplicationOnPassword(@RequestParam String mail) {
        User user = userService.findByMail(mail);
        if (user != null) {
            Application application = applicationHelper.generate(user, ApplicationTypeEnum.PASSWORD, null);
            applicationService.create(application);
        }
        return ResponseEntity.ok(user != null);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public ResponseEntity<?> createApplicationOnTrainer(
            @RequestBody @Valid TrainerApplicationDto applicationDto) {
        User user = userHelper.generateTrainer(applicationDto);
        user = userService.create(user);

        Application application = applicationHelper.generate(
                user, ApplicationTypeEnum.TRAINER, applicationDto.getMessage()
        );

        applicationService.create(application);

        return ResponseEntity.ok(true);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public ResponseEntity<?> getAll(Locale locale) {
        GrantedAuthority admin = new SimpleGrantedAuthority(new Role(RoleEnum.ROLE_ADMIN).getRoleName());
        UserDetails currentUser = userHelper.getCurrentUser();

        List<Application> applications;
        if (currentUser.getAuthorities().contains(admin)) {
            applications = applicationService.loadAll();
        } else {
            User user = userService.findByUsername(currentUser.getUsername());
            applications = applicationService.loadAllByUserId(user.getUserId());
        }

        List<BaseApplicationDto> applicationDtos =
                applicationMapper.toBaseApplicationDtos(applications, locale);
        return ResponseEntity.ok(applicationDtos);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public ResponseEntity<?> getApplication (@PathVariable int id, Locale locale) {
        Application application = applicationService.getApplicationById(id);
        return ResponseEntity.ok(applicationMapper.toApplicationDto(application, locale));
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public ResponseEntity<?> updateApplication (
            @PathVariable int id,
            @RequestBody @Valid StatusDto statusDto) {
        Application application = applicationService.updateStatus(id, StatusEnum.valueOf(statusDto.getStatus()));
        applicationService.processApplication(application);
        return ResponseEntity.ok(application);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public ResponseEntity<?> deleteApplication(@PathVariable int id) {
        applicationService.deleteApplicationById(id);
        return ResponseEntity.ok(true);
    }
}
