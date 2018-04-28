package by.slivki.trainings.rest.mapper;

import by.slivki.trainings.dao.jpa.Training;
import by.slivki.trainings.rest.dto.BaseTrainingDto;
import by.slivki.trainings.rest.dto.TrainingDto;
import by.slivki.trainings.service.api.CategoryService;
import by.slivki.trainings.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TrainingMapper {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private StageMapper stageMapper;

    public List<BaseTrainingDto> toBaseTrainingDtos(List<Training> trainings) {
        List<BaseTrainingDto> baseTrainingDtos = new ArrayList<>();
        if (trainings != null) {
            for (Training training : trainings) {
                baseTrainingDtos.add(toBaseTrainingDto(training));
            }
        }
        return baseTrainingDtos;
    }

    public TrainingDto toTrainingDto(Training training) {
        TrainingDto trainingDto = new TrainingDto();
        trainingDto.setId(training.getTrainingId());
        trainingDto.setTitle(training.getTitle());
        trainingDto.setDescription(training.getDescription());
        trainingDto.setCategory(training.getCategory().getCategoryName());
        trainingDto.setForWhom(training.getForWhom());
        trainingDto.setGoal(training.getGoal());
        trainingDto.setMaxParticipants(training.getMaxParticipants());
        trainingDto.setUserName(training.getUser().getUsername());
        trainingDto.setStages(stageMapper.toStageDtos(training.getStages()));
        return trainingDto;
    }

    public BaseTrainingDto toBaseTrainingDto(Training training) {
        BaseTrainingDto baseTrainingDto = new BaseTrainingDto();
        baseTrainingDto.setId(training.getTrainingId());
        baseTrainingDto.setTitle(training.getTitle());
        baseTrainingDto.setCategory(training.getCategory().getCategoryName());
        return baseTrainingDto;
    }

    public Training toEntity(TrainingDto dto) {
        Training training = new Training();
        training.setTrainingId(dto.getId());
        training.setTitle(dto.getTitle());
        training.setDescription(dto.getDescription());
        training.setForWhom(dto.getForWhom());
        training.setGoal(dto.getGoal());
        training.setMaxParticipants(dto.getMaxParticipants());
        training.setUser(userService.findByUsername(dto.getUserName()));
        training.setCategory(categoryService.findAllByCategoryName(dto.getCategory()).get(0));
        training.setStages(stageMapper.toEntities(dto.getStages()));
        return training;
    }
}
