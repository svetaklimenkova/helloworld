package by.slivki.trainings.rest.mapper;

import by.slivki.trainings.dao.api.TrainingMasterRepository;
import by.slivki.trainings.dao.jpa.Training;
import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.rest.dto.BaseTrainingDto;
import by.slivki.trainings.rest.dto.TrainingDto;
import by.slivki.trainings.rest.dto.TrainingExtDto;
import by.slivki.trainings.service.api.CategoryService;
import by.slivki.trainings.service.api.UserService;
import by.slivki.trainings.util.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class TrainingMapper {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private StageMapper stageMapper;
    @Autowired
    private UserHelper userHelper;
    @Autowired
    private TrainingMasterRepository trainingMasterRepository;

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
        trainingDto.setParticipantsCount(
                trainingMasterRepository.countByTraining_TrainingId(training.getTrainingId()));
        trainingDto.setUserName(training.getUser().getUsername());
        trainingDto.setStages(stageMapper.toStageDtos(training.getStages()));
        return trainingDto;
    }

    public TrainingExtDto toTrainingExtDto(Training training, User user, Locale locale) {
        TrainingExtDto trainingDto = new TrainingExtDto();
        trainingDto.setId(training.getTrainingId());
        trainingDto.setTitle(training.getTitle());
        trainingDto.setDescription(training.getDescription());
        trainingDto.setCategory(training.getCategory().getCategoryName());
        trainingDto.setForWhom(training.getForWhom());
        trainingDto.setGoal(training.getGoal());
        trainingDto.setMaxParticipants(training.getMaxParticipants());
        trainingDto.setParticipantsCount(
                trainingMasterRepository.countByTraining_TrainingId(training.getTrainingId()));
        trainingDto.setUserName(training.getUser().getUsername());
        trainingDto.setStages(stageMapper.toStageExtDtos(training.getStages(), user, locale));
        return trainingDto;
    }

    private BaseTrainingDto toBaseTrainingDto(Training training) {
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
        training.setUser(userService.findByUsername(userHelper.getCurrentUser().getUsername()));
        training.setCategory(categoryService.findAllByCategoryName(dto.getCategory()).get(0));
        training.setStages(stageMapper.toEntities(dto.getStages()));
        return training;
    }
}
