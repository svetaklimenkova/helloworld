package by.slivki.trainings.dao.jpa;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@EqualsAndHashCode
@Entity
@Table(name="taskstatuses")
public class TaskStatus {
    @Column
    @Id
    private int taskStatusId;
    @Column
    private String taskStatusName;

    public TaskStatus() {}

    public TaskStatus(TaskStatusEnum statusEnum) {
        this.taskStatusId = statusEnum.getI();
        this.taskStatusName = statusEnum.name();
    }

    public int getTaskStatusId() {
        return taskStatusId;
    }

    public void setTaskStatusId(int taskStatusId) {
        this.taskStatusId = taskStatusId;
    }

    public String getTaskStatusName() {
        return taskStatusName;
    }

    public void setTaskStatusName(String taskStatusName) {
        this.taskStatusName = taskStatusName;
    }
}
