package by.slivki.trainings.rest.dto;

import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode
public class ReportDto extends BaseReportDto {
    private String training;
    private String task;
    private String from;

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
