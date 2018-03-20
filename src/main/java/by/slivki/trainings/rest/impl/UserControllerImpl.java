package by.slivki.trainings.rest.impl;

import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.rest.dto.SignUpUserDto;
import by.slivki.trainings.service.api.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserControllerImpl {
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Processes POST request to '/signUpUser'.
     * Creates a user by signUpUserDto.
     *
     * @param signUpUserDto signUpUserDto
     *
     * @return result of creating a user (true or false)
     * */
    @RequestMapping(value = "/signUpUser", method = RequestMethod.POST)
    public ResponseEntity<?> signUpUser(
            @RequestBody @Valid SignUpUserDto signUpUserDto) {
        User user = modelMapper.map(signUpUserDto, User.class);

        user.setPassword(encoder.encode(user.getPassword()));
        userService.createUser(user);

        return ResponseEntity.ok(true);
    }

    /**
     * Process GET request to '/register' and
     * check existing of username.
     *
     * @param username username
     *
     * @return result of check (true or false)
     * */
    @RequestMapping(value = "/valid", method = RequestMethod.GET)
    public ResponseEntity<?> isValidUsername(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "mail", required = false) String mail) {
        if (username != null) {
            return ResponseEntity.ok(userService.checkUsername(username));
        } else if (mail != null) {
            return ResponseEntity.ok(userService.checkMail(mail));
        } else {
            return ResponseEntity.ok(true);
        }
    }

    /**
     * Process GET request to '/username' and
     * return the username of the current user.
     *
     * @return username
     * */
    @RequestMapping(value = "/username", method = RequestMethod.GET)
    public ResponseEntity<?> getUsername() {
        UserDetails currentUser = getCurrentUser();
        if (currentUser != null) {
            return ResponseEntity.ok(currentUser.getUsername());
        } else {
            return ResponseEntity.ok(false);
        }
    }

    private UserDetails getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (null == auth) {
            return null;
        }

        Object obj = auth.getPrincipal();

        if (obj instanceof UserDetails) {
            return (UserDetails) obj;
        } else {
            return null;
        }
    }

}