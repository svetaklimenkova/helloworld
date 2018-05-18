package by.slivki.trainings.rest.api;

import by.slivki.trainings.rest.dto.StatusDto;
import by.slivki.trainings.rest.dto.TrainerApplicationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Locale;

public interface ApplicationController {

    /**
     * Processes GET request to '/rest/applications'.
     * Loads all applications.
     *
     * @return list of applications
     * */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<?> getAll(Locale locale);

    /**
     * Processes GET request to '/rest/applications/{id}'.
     * Gets application by id.
     *
     * @param id application id
     *
     * @return application dto
     * */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<?> getApplication (@PathVariable int id, Locale locale);

    /**
     * Processes POST request to '/rest/applications/{id}'.
     * Modifies status of application by id and statusDto.
     *
     * @param id application id
     * @param statusDto new status of application
     *
     * @return result (true or false)
     * */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    ResponseEntity<?> updateApplication (
            @PathVariable int id,
            @RequestBody @Valid StatusDto statusDto,
            Locale locale
    );

    /**
     * Processes POST request to '/rest/applications/{id}'.
     * Deletes application by id.
     *
     * @param id application id
     *
     * @return result (true or false)
     * */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteApplication(@PathVariable int id);

    /**
     * Processes POST request to '/rest/applications/password'.
     * If user with the mail existed then it changes it and
     * receives a message to user mail.
     *
     * @param mail mail
     *
     * @return result (true or false)
     * */
    @RequestMapping(value = "/password", method = RequestMethod.POST)
    ResponseEntity<?> createApplicationOnPassword(@RequestParam String mail);

    /**
     * Processes POST request to '/rest/applications/password'.
     * If user with the mail existed then it changes it and
     * receives a message to user mail.
     *
     * @param applicationDto application with login, mail and message
     *
     * @return result (true or false)
     * */
    @RequestMapping(value = "/trainer", method = RequestMethod.POST)
    ResponseEntity<?> createApplicationOnTrainer(
            @RequestBody @Valid TrainerApplicationDto applicationDto);
}