package by.slivki.trainings.rest.impl;

import by.slivki.trainings.dao.jpa.*;
import by.slivki.trainings.rest.api.ApplicationController;
import by.slivki.trainings.rest.dto.BaseApplicationDto;
import by.slivki.trainings.rest.dto.StatusDto;
import by.slivki.trainings.rest.dto.TrainerApplicationDto;
import by.slivki.trainings.rest.mapper.ApplicationMapper;
import by.slivki.trainings.rest.mapper.UserMapper;
import by.slivki.trainings.service.api.ApplicationService;
import by.slivki.trainings.service.api.UserService;
import by.slivki.trainings.util.ApplicationHelper;
import by.slivki.trainings.util.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/applications")
public class ApplicationControllerImpl implements ApplicationController {

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
        User user = userService.loadUserByMail(mail);
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
        user = userService.createUser(user);

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
    public ResponseEntity<?> getAll() {
        GrantedAuthority admin = new SimpleGrantedAuthority(new Role(RoleEnum.ADMIN).getRoleName());
        UserDetails currentUser = userHelper.getCurrentUser();

        List<Application> applications;
        if (currentUser.getAuthorities().contains(admin)) {
            applications = applicationService.loadAll();
        } else {
            User user = userService.loadUserByUsername(currentUser.getUsername());
            applications = applicationService.loadAllByUserId(user.getUserId());
        }

        List<BaseApplicationDto> applicationDtos = applicationMapper.toBaseApplicationDtos(applications);
        return ResponseEntity.ok(applicationDtos);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public ResponseEntity<?> getApplication (@PathVariable int id) {
        Application application = applicationService.getApplicationById(id);
        return ResponseEntity.ok(applicationMapper.toApplicationDto(application));
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public ResponseEntity<?> updateApplication (
            @PathVariable int id,
            @RequestBody @Valid StatusDto statusDto) {
        Application application = applicationService.updateStatus(id, StatusEnum.valueOf(statusDto.getStatus()));
        return ResponseEntity.ok(application);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public ResponseEntity<?> deleteApplication(int id) {
        applicationService.deleteApplicationById(id);
        return ResponseEntity.ok(true);
    }
}
