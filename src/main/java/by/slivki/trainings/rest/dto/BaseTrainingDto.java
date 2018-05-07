package by.slivki.trainings.rest.dto;

import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode
public class BaseTrainingDto {
    private int id;

    @NotNull(message = "trainings.title.not_null")
    @Size(min = 3, max = 52, message = "trainings.title.size")
    private String title;

    @NotNull(message = "trainings.category.not_null")
    private String category;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
