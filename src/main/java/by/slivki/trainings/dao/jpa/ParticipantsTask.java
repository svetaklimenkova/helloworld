package by.slivki.trainings.dao.jpa;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="participantstasks")
public class ParticipantsTask {
    @Id
    @Column
    private int participantTaskId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "taskId")
    private Task task;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "taskStatusId")
    private TaskStatus taskStatus;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public int getParticipantTaskId() {
        return participantTaskId;
    }

    public void setParticipantTaskId(int participantTaskId) {
        this.participantTaskId = participantTaskId;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
}
