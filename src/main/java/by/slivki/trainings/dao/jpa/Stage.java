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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="stages")
public class Stage {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stageId;
    @Column
    private int stageIndex;
    @Column
    private String stageName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trainingId")
    private Training training;
    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL )
    @JoinColumn(name = "stageId")
    private List<Task> tasks;

    public int getStageId() {
        return stageId;
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public int getStageIndex() {
        return stageIndex;
    }

    public void setStageIndex(int stageIndex) {
        this.stageIndex = stageIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Stage stage = (Stage) o;

        return new EqualsBuilder()
                .append(stageId, stage.stageId)
                .append(stageIndex, stage.stageIndex)
                .append(stageName, stage.stageName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(stageId)
                .append(stageIndex)
                .append(stageName)
                .toHashCode();
    }
}
