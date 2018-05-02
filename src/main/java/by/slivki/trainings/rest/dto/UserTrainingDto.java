package by.slivki.trainings.rest.dto;

import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

@EqualsAndHashCode
public class UserTrainingDto {

    private int id;
    @NotNull(message = "trainings.title.not_null")
    @Size(min = 3, max = 52, message = "trainings.title.size")
    private String title;
    @NotNull(message = "trainings.description.not_null")
    @Size(min = 100, max = 5000, message = "trainings.description.size")
    private String description;
    @NotNull(message = "trainings.category.not_null")
    private String category;
    @NotNull(message = "trainings.for_whom.not_null")
    @Size(min = 4, max = 255, message = "trainings.for_whom.size")
    private String forWhom;
    @NotNull(message = "trainings.goal.not_null")
    @Size(min = 3, max = 255, message = "trainings.goal.size")
    private String goal;
    @NotNull
    @Positive(message = "trainings.maxParticipants.positive")
    private int maxParticipants;

    private int participantsCount;

    private String userName;

    private List<StageDto> stages;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getForWhom() {
        return forWhom;
    }

    public void setForWhom(String forWhom) {
        this.forWhom = forWhom;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<StageDto> getStages() {
        return stages;
    }

    public void setStages(List<StageDto> stages) {
        this.stages = stages;
    }

    public int getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(int participantsCount) {
        this.participantsCount = participantsCount;
    }
}
