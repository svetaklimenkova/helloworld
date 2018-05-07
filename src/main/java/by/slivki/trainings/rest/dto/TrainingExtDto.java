package by.slivki.trainings.rest.dto;

import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

@EqualsAndHashCode
public class TrainingExtDto extends TrainingWithoutStagesDto {
    private List<StageExtDto> stages;

    public List<StageExtDto> getStages() {
        return stages;
    }

    public void setStages(List<StageExtDto> stages) {
        this.stages = stages;
    }
}
