package by.slivki.trainings.rest.impl;

import by.slivki.trainings.dao.jpa.Role;
import by.slivki.trainings.dao.jpa.RoleEnum;
import by.slivki.trainings.dao.jpa.Training;
import by.slivki.trainings.rest.api.TrainingController;
import by.slivki.trainings.rest.dto.BaseTrainingDto;
import by.slivki.trainings.rest.dto.TrainingDto;
import by.slivki.trainings.rest.mapper.TrainingMapper;
import by.slivki.trainings.service.api.TrainingService;
import by.slivki.trainings.util.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/rest/trainings")
public class TrainingControllerImpl implements TrainingController {

    @Autowired
    private TrainingService trainingService;
    @Autowired
    private TrainingMapper trainingMapper;
    @Autowired
    private UserHelper userHelper;

    @Override
    public ResponseEntity<List<BaseTrainingDto>> getAll(Pageable pageable) {
        UserDetails userDetails = userHelper.getCurrentUser();

        List<Training> trainings = new ArrayList<>(0);
        if (userHelper.isRoleAuthority(userDetails, RoleEnum.ROLE_TRAINER)) {
            trainings = trainingService.loadAllByUsername(userDetails.getUsername(), pageable);
        } else if (userHelper.isRoleAuthority(userDetails, RoleEnum.ROLE_USER)) {
            trainings = trainingService.loadAll(pageable);
        }
        return ResponseEntity.ok(trainingMapper.toBaseTrainingDtos(trainings));
    }

    @Override
    public ResponseEntity<TrainingDto> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok(trainingMapper.toTrainingDto(trainingService.getById(id)));
    }

    @Override
    public ResponseEntity<TrainingDto> update(
            @PathVariable("id") int id, @Valid TrainingDto trainingDto) {
        return ResponseEntity.ok(trainingMapper.toTrainingDto(
                trainingService.update(trainingMapper.toEntity(trainingDto))));
    }

    @Override
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
        trainingService.deleteTrainingById(id);
        return ResponseEntity.ok(true);
    }
}
