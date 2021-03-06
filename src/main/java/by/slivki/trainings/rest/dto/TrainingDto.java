package by.slivki.trainings.rest.dto;

import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

@EqualsAndHashCode
public class TrainingDto extends TrainingWithoutStagesDto {

    private List<StageDto> stages;

    public List<StageDto> getStages() {
        return stages;
    }

    public void setStages(List<StageDto> stages) {
        this.stages = stages;
    }
}
