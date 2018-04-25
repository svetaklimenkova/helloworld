package by.slivki.trainings.rest.api;

import by.slivki.trainings.rest.dto.TrainingDto;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Locale;

public interface TrainingController {

    /**
     * Processes GET request to '/trainings'.
     * Loads all trainings.
     *
     * @return list of trainings
     * */
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<?> getAll(Pageable pageable);

    /**
     * Processes GET request to '/trainings/{id}'.
     * Gets training by id.
     *
     * @param id training id
     *
     * @return training dto
     * */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
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
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    ResponseEntity<?> update(
            @PathVariable("id") int id,
            @RequestBody @Valid TrainingDto trainingDto
    );

    /**
     * Processes POST request to '/trainings/{id}'.
     * Deletes training by id.
     *
     * @param id application id
     *
     * @return result (true or false)
     * */
    @PreAuthorize("hasRole('ROLE_TRAINER')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteById(@PathVariable("id") int id);

}
