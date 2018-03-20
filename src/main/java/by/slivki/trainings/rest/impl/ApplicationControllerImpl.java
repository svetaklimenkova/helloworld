package by.slivki.trainings.rest.impl;

import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.service.api.UserService;
import by.slivki.trainings.util.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application")
public class ApplicationControllerImpl {

    @Autowired
    private UserService userService;
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
    public ResponseEntity<?> postApplicationOnPassword(
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
}
