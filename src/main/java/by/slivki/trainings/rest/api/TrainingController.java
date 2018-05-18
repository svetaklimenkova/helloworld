package by.slivki.trainings.rest.api;

import by.slivki.trainings.dao.jpa.Training;
import by.slivki.trainings.rest.dto.TrainingDto;
import by.slivki.trainings.util.RestMessage;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Locale;

public interface TrainingController {

    /**
     * Process POST request to '/trainings/'.
     * Creates training for current user.
     *
     * @return training
     * */
    @PostMapping
    @PreAuthorize("hasRole('ROLE_TRAINER')")
    ResponseEntity<TrainingDto> create(@RequestBody @Valid TrainingDto trainingDto);

    /**
     * Processes GET request to '/trainings'.
     * Loads all trainings.
     *
     * @return list of trainings
     * */
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_TRAINER', 'ROLE_USER')")
    ResponseEntity<?> getAll(
            @QuerydslPredicate(root = Training.class) Predicate predicate, Pageable pageable);

    /**
     * Processes GET request to '/trainings/{id}'.
     * Gets training by id.
     *
     * @param id training id
     *
     * @return training dto
     * */
    @PreAuthorize("hasAnyRole('ROLE_TRAINER', 'ROLE_USER')")
    @GetMapping("/{id}")
    ResponseEntity<?> getById(@PathVariable("id") int id);

    /**
     * Processes POST request to '/trainings/{id}'.
     * Modifies training.
     *
     * @param id training id
     * @param trainingDto training dto
     *
     * @return result updated dto
     * */
    @PreAuthorize("hasRole('ROLE_TRAINER')")
    @PostMapping("/{id}")
    ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody @Valid TrainingDto trainingDto);

    /**
     * Processes DELETE request to '/trainings/{id}'.
     * Deletes training by id.
     *
     * @param id application id
     *
     * @return result (true or false)
     * */
    @PreAuthorize("hasRole('ROLE_TRAINER')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteById(@PathVariable("id") int id);

    /**
     * Processes POST request to '/trainings/{id}/user'.
     * Added user to training by user id.
     *
     * @param id training id
     *
     * @return message
     * */
    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping(value = "/{id}/user")
    ResponseEntity<RestMessage> addUserToTraining(@PathVariable("id") int id, Locale locale);

    /**
     * Processes DELETE request to '/trainings/{id}/user'.
     * Deletes user from training by user id.
     *
     * @param id training id
     *
     * @return message
     * */
    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping(value = "/{id}/user")
    ResponseEntity<RestMessage> deleteUserFromTraining(@PathVariable("id") int id, Locale locale);
}
