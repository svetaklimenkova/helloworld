package by.slivki.trainings.rest.impl;

import by.slivki.trainings.dao.jpa.*;
import by.slivki.trainings.rest.dto.StatusDto;
import by.slivki.trainings.rest.dto.TrainerCreationApplicationDto;
import by.slivki.trainings.rest.mapper.UserMapper;
import by.slivki.trainings.service.api.ApplicationService;
import by.slivki.trainings.service.api.UserService;
import by.slivki.trainings.util.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/application")
public class ApplicationControllerImpl {

    @Autowired
    private UserService userService;
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder encoder;

    /**
     * Processes POST request to '/application/password'.
     * If user with the mail existed then it changes it and
     * receives a message to user mail.
     *
     * @param mail mail
     *
     * @return result (true or false)
     * */
    @RequestMapping(value = "/password", method = RequestMethod.POST)
    public ResponseEntity<?> createApplicationOnPassword(
            @RequestParam String mail) {

        User user = userService.loadUserByMail(mail);
        if (user == null) {
            return ResponseEntity.ok(false);
        }

        String password = PasswordHelper.generatePassword();
        user.setPassword(encoder.encode(password));

        // change for release
        System.out.println("USER: " + user.getUsername() + "; NEW PASSWORD : " + password);

        userService.updateUser(user);

        return ResponseEntity.ok(true);
    }

    /**
     * Processes POST request to '/application/password'.
     * If user with the mail existed then it changes it and
     * receives a message to user mail.
     *
     * @param applicationDto application with login, mail and message
     *
     * @return result (true or false)
     * */
    @RequestMapping(value = "/trainer", method = RequestMethod.POST)
    public ResponseEntity<?> createApplicationOnTrainer(
            @RequestBody @Valid TrainerCreationApplicationDto applicationDto) {

        User user = userMapper.from(applicationDto);
        user.setConfirmed(false);
        user.setRole(new Role(RoleEnum.TRAINER));

        String password = PasswordHelper.generatePassword();
        user.setPassword(encoder.encode(password));

        // change for release
        System.out.println("TRAINER: " + user.getUsername() + "; PASSWORD : " + password);

        user = userService.createUser(user);

        Application application = new Application();
        application.setApplicationType(new ApplicationType(ApplicationTypeEnum.TRAINER));
        application.setDescription(applicationDto.getMessage());
        application.setUser(user);
        application.setStatus(new Status(StatusEnum.IN_PROGRESS));

        applicationService.createApplication(application);

        return ResponseEntity.ok(true);
    }

    /**
     * Processes POST request to '/application/{id}'.
     * Modify status of application by id and statusDto.
     *
     * @param id application id
     * @param statusDto new status of application
     *
     * @return result (true or false)
     * */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> modifyApplicationStatus (
            @PathVariable int id,
            @RequestBody @Valid StatusDto statusDto) {
        applicationService.updateStatusOfApplication(id, StatusEnum.valueOf(statusDto.getStatus()));
        return ResponseEntity.ok(true);
    }

    /**
     * Processes POST request to '/application/{id}'.
     * Modify status of application by id and statusDto.
     *
     * @return result (true or false)
     * */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> loadAll() {
        /*TODO*/
        //applicationService.updateStatusOfApplication(id, StatusEnum.valueOf(statusDto.getStatus()));
        return ResponseEntity.ok(true);
    }
}
