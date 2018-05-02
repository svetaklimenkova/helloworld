package by.slivki.trainings.rest.impl;

import by.slivki.trainings.dao.jpa.RoleEnum;
import by.slivki.trainings.dao.jpa.Training;
import by.slivki.trainings.rest.api.TrainingController;
import by.slivki.trainings.rest.dto.BaseTrainingDto;
import by.slivki.trainings.rest.dto.TrainingDto;
import by.slivki.trainings.rest.mapper.TrainingMapper;
import by.slivki.trainings.service.api.TrainingService;
import by.slivki.trainings.util.RestMessage;
import by.slivki.trainings.util.UserHelper;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@RestController
@RequestMapping("/rest/trainings")
public class TrainingControllerImpl implements TrainingController {

    @Autowired
    private TrainingService trainingService;
    @Autowired
    private TrainingMapper trainingMapper;
    @Autowired
    private UserHelper userHelper;
    @Autowired
    private MessageSource messageSource;

    @Override
    public ResponseEntity<TrainingDto> create(@RequestBody @Valid TrainingDto trainingDto) {
        return ResponseEntity.ok(trainingMapper.toTrainingDto(
                trainingService.saveOrUpdate(trainingMapper.toEntity(trainingDto))));
    }

    @Override
    public ResponseEntity<List<BaseTrainingDto>> getAll(
            @QuerydslPredicate(root = Training.class) Predicate predicate, Pageable pageable) {
        UserDetails userDetails = userHelper.getCurrentUser();

        List<Training> trainings = new ArrayList<>(0);
        if (userHelper.isRoleAuthority(userDetails, RoleEnum.ROLE_TRAINER)) {
            trainings = trainingService.findAllByUsername(userDetails.getUsername(), pageable);
        } else if (userHelper.isRoleAuthority(userDetails, RoleEnum.ROLE_USER)) {
            trainings = trainingService.findAll(predicate, pageable);
        }
        return ResponseEntity.ok(trainingMapper.toBaseTrainingDtos(trainings));
    }

    @Override
    public ResponseEntity<TrainingDto> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok(trainingMapper.toTrainingDto(trainingService.getById(id)));
    }

    @Override
    public ResponseEntity<TrainingDto> update(
            @PathVariable("id") int id, @RequestBody @Valid TrainingDto trainingDto) {
        return ResponseEntity.ok(trainingMapper.toTrainingDto(
                trainingService.saveOrUpdate(trainingMapper.toEntity(trainingDto))));
    }

    @Override
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
        trainingService.deleteTrainingById(id);
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<RestMessage> addUserToTraining(@PathVariable("id") int id, Locale locale) {
        trainingService.addUserToTraining(id, userHelper.getCurrentUser().getUsername());
        return ResponseEntity.ok(new RestMessage(200,
                messageSource.getMessage("trainings.participant.added", null, locale)));
    }
}
