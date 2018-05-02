package by.slivki.trainings.rest.impl;

import by.slivki.trainings.dao.jpa.Training;
import by.slivki.trainings.rest.api.UserTrainingController;
import by.slivki.trainings.rest.dto.BaseTrainingDto;
import by.slivki.trainings.rest.dto.TrainingDto;
import by.slivki.trainings.rest.mapper.TrainingMapper;
import by.slivki.trainings.service.api.TrainingMasterService;
import by.slivki.trainings.service.api.TrainingService;
import by.slivki.trainings.util.UserHelper;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/rest/user/trainings")
public class UserTrainingControllerImpl implements UserTrainingController {

    @Autowired
    private TrainingService trainingService;
    @Autowired
    private TrainingMasterService trainingMasterService;
    @Autowired
    private TrainingMapper trainingMapper;
    @Autowired
    private UserHelper userHelper;

    @Override
    public ResponseEntity<List<BaseTrainingDto>> getAll(
            @QuerydslPredicate(root = Training.class) Predicate predicate, Pageable pageable) {
        UserDetails userDetails = userHelper.getCurrentUser();
        return ResponseEntity.ok(trainingMapper.toBaseTrainingDtos(
                trainingMasterService.findAllByParticipantName(userDetails.getUsername())));
    }

    @Override
    public ResponseEntity<TrainingDto> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok(trainingMapper.toTrainingDto(trainingService.getById(id)));
    }
}
