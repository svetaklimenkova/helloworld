package by.slivki.trainings.rest.mapper;

import by.slivki.trainings.dao.jpa.Stage;
import by.slivki.trainings.dao.jpa.StatusEnum;
import by.slivki.trainings.dao.jpa.TaskStatusEnum;
import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.rest.dto.StageDto;
import by.slivki.trainings.rest.dto.StageExtDto;
import by.slivki.trainings.rest.dto.TaskExtDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

@Component
public class StageMapper {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private TaskMapper taskMapper;

    public List<StageDto> toStageDtos(List<Stage> stages) {
        List<StageDto> stageDtos = new ArrayList<>();
        if (stages != null) {
            for (Stage stage : stages) {
                stageDtos.add(toStageDto(stage));
            }
        }
        stageDtos.sort(Comparator.comparingInt(StageDto::getIndex));
        return stageDtos;
    }

    public List<StageExtDto> toStageExtDtos(List<Stage> stages, User user, Locale locale) {
        List<StageExtDto> stageDtos = new ArrayList<>();
        if (stages != null) {
            for (Stage stage : stages) {
                stageDtos.add(toStageExtDto(stage, user, locale));
            }
        }
        stageDtos.sort(Comparator.comparingInt(StageExtDto::getIndex));
        return stageDtos;
    }

    private StageExtDto toStageExtDto(Stage stage, User user, Locale locale) {
        StageExtDto stageDto = new StageExtDto();
        stageDto.setId(stage.getStageId());
        stageDto.setIndex(stage.getStageIndex());
        stageDto.setName(stage.getStageName());
        stageDto.setTasks(taskMapper.toTaskExtDtos(stage.getTasks(), user, locale));
        if (stageDto.getTasks() != null) {
            String status = "";
            int statusId = 0;
            String notStarted = messageSource.getMessage(
                    "tasks.status." + TaskStatusEnum.NOT_STARTED.name().toLowerCase(),
                    null, locale);
            String inProgress = messageSource.getMessage(
                    "tasks.status." + TaskStatusEnum.IN_PROGRESS.name().toLowerCase(),
                    null, locale);
            String finished = messageSource.getMessage(
                    "tasks.status." + TaskStatusEnum.FINISHED.name().toLowerCase(),
                    null, locale);
            for (TaskExtDto task : stageDto.getTasks()) {
                if(task.getStatus() == null) {
                    status = notStarted;
                    statusId = TaskStatusEnum.NOT_STARTED.getI();
                    break;
                } else if (task.getStatus().equals(finished)) {
                    status = finished;
                    statusId = TaskStatusEnum.FINISHED.getI();
                } else {
                    status = inProgress;
                    statusId = TaskStatusEnum.IN_PROGRESS.getI();
                    break;
                }
            }
            stageDto.setStatusId(statusId);
            stageDto.setStatus(status);
        }
        return stageDto;
    }

    private StageDto toStageDto(Stage stage) {
        StageDto stageDto = new StageDto();
        stageDto.setId(stage.getStageId());
        stageDto.setIndex(stage.getStageIndex());
        stageDto.setName(stage.getStageName());
        stageDto.setTasks(taskMapper.toTaskDtos(stage.getTasks()));
        return stageDto;
    }

    public List<Stage> toEntities(List<StageDto> stageDtos) {
        List<Stage> stages = new ArrayList<>();
        if (stageDtos != null) {
            for (StageDto stageDto : stageDtos) {
                stages.add(toEntity(stageDto));
            }
        }
        return stages;
    }

    public Stage toEntity(StageDto stageDto) {
        Stage stage = new Stage();
        stage.setStageId(stageDto.getId());
        stage.setStageName(stageDto.getName());
        stage.setStageIndex(stageDto.getIndex());
        stage.setTasks(taskMapper.toEntities(stageDto.getTasks()));
        return stage;
    }
}
