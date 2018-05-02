package by.slivki.trainings.dao.jpa;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tasks")
public class Task {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId;
    @Column
    private String taskName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stageId")
    private Stage stage;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return new EqualsBuilder()
                .append(taskId, task.taskId)
                .append(taskName, task.taskName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(taskId)
                .append(taskName)
                .toHashCode();
    }
}
