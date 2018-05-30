package by.slivki.trainings.rest.impl;

import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.rest.api.UserController;
import by.slivki.trainings.rest.dto.BaseUserDto;
import by.slivki.trainings.rest.dto.SignUpUserDto;
import by.slivki.trainings.rest.dto.UpdateUserDto;
import by.slivki.trainings.rest.mapper.UserMapper;
import by.slivki.trainings.service.api.UserService;
import by.slivki.trainings.util.UserHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(value = "/rest/users")
public class UserControllerImpl implements UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserControllerImpl.class);

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserHelper userHelper;

    /**
     * {@inheritDoc}
     * */
    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll(Locale locale) {
        List<User> users = userService.findAll();
        List<BaseUserDto> baseUserDtos = userMapper.toBaseUserDtos(users, locale);
        return ResponseEntity.ok(baseUserDtos);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(
            @RequestBody @Valid SignUpUserDto signUpUserDto) {
        User user = userMapper.from(signUpUserDto);
        userService.create(user);
        return ResponseEntity.ok(true);
    }

    /**
     * {@inheritDoc}
     * */
    @RequestMapping(value = "/valid", method = RequestMethod.GET)
    public ResponseEntity<?> isValid(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "mail", required = false) String mail) {
        Boolean result = false;

        if (username != null) {
            result = userService.checkUsername(username);
        } else if (mail != null) {
            result = userService.checkMail(mail);
        }
        return ResponseEntity.ok(result);
    }

    /**
     * {@inheritDoc}
     * */
    @RequestMapping(value = "/username", method = RequestMethod.GET)
    public ResponseEntity<?> getUsername() {
        Object result = false;
        UserDetails currentUser = userHelper.getCurrentUser();

        if (currentUser != null) {
            result = currentUser.getUsername();
        }

        return ResponseEntity.ok(result);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(
            @RequestBody(required = false) @Valid UpdateUserDto updateUserDto) {
        if (updateUserDto == null) {
            return ResponseEntity.ok(true);
        }
        logger.debug("--------------------------" + updateUserDto.getPassword());
        User user = userService.findByUsername(userHelper.getCurrentUser().getUsername());
        user = userMapper.from(updateUserDto, user);
        userService.update(user);
        return ResponseEntity.ok(true);
    }
}