package by.slivki.trainings.rest.dto;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class UserTaskDto {
    private int id;
    private String name;
    private String status;

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
}
