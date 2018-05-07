package by.slivki.trainings.rest.dto;

import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode
public class ReportDto extends BaseReportDto {
    private String training;
    private String task;
    private Date createdBy;

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

    public Date getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Date createdBy) {
        this.createdBy = createdBy;
    }
}
