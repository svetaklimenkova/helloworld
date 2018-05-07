package by.slivki.trainings.rest.dto;

import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode
public class StageExtDto {
    private int id;
    private int index;
    private String name;
    private String status;
    private int statusId;
    private List<TaskExtDto> tasks;

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

    public List<TaskExtDto> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskExtDto> tasks) {
        this.tasks = tasks;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }
}