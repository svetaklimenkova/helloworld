package by.slivki.trainings.rest.dto;

import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode
public class TrainingDto {
    private int id;
    private String title;
    private String description;
    private String category;
    private String forWhom;
    private String goal;
    private int maxParticipants;
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
}
