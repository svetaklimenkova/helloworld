package by.slivki.trainings.rest.api;

import by.slivki.trainings.dao.jpa.Training;
import by.slivki.trainings.rest.dto.TrainingDto;
import by.slivki.trainings.util.RestMessage;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Locale;

public interface UserTrainingController {

    /**
     * Processes GET request to '/user/trainings'.
     * Loads all trainings by current user.
     *
     * @return list of trainings
     * */
    @GetMapping
    ResponseEntity<?> getAll(
            @QuerydslPredicate(root = Training.class) Predicate predicate, Pageable pageable);

    /**
     * Processes GET request to '/user/trainings/{id}'.
     * Gets training by id.
     *
     * @param id training id
     *
     * @return training dto
     * */
    @GetMapping(value = "/{id}")
    ResponseEntity<?> getById(@PathVariable("id") int id, Locale locale);
}
