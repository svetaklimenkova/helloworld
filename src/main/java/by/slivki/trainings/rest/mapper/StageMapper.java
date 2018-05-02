package by.slivki.trainings.rest.mapper;

import by.slivki.trainings.dao.jpa.Stage;
import by.slivki.trainings.rest.dto.StageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class StageMapper {

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

    public StageDto toStageDto(Stage stage) {
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
