package by.slivki.trainings.rest.api;

import by.slivki.trainings.rest.dto.SignUpUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

public interface UserController {

    /**
     * Processes GET request to '/users'.
     * Gets all users.
     *
     * @return list of user
     * */
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<?> getAll();

    /**
     * Processes POST request to '/users'.
     * Creates a user by signUpUserDto.
     *
     * @param signUpUserDto signUpUserDto
     *
     * @return result of creating a user (true or false)
     * */
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> create(@RequestBody @Valid SignUpUserDto signUpUserDto);

    /**
     * Process GET request to '/users/valid' and
     * check existing of username.
     *
     * @param username username
     *
     * @return result of check (true or false)
     * */
    @RequestMapping(value = "/valid", method = RequestMethod.GET)
    ResponseEntity<?> isValid(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "mail", required = false) String mail);

    /**
     * Process GET request to '/users/username' and
     * return the username of the current user.
     *
     * @return username
     * */
    @RequestMapping(value = "/username", method = RequestMethod.GET)
    ResponseEntity<?> getUsername();
}