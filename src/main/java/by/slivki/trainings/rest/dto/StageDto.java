package by.slivki.trainings.rest.dto;

import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode
public class StageDto {
    private int id;
    private String name;
    private List<TaskDto> tasks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDto> tasks) {
        this.tasks = tasks;
    }
}
