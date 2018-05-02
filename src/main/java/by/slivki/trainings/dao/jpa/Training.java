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
@Table(name="trainings")
public class Training {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trainingId;
    @Column
    private String title;
    @Column
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId")
    private Category category;
    @Column
    private String forWhom;
    @Column
    private String goal;
    @Column
    private int maxParticipants;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;
    @Column
    private boolean isOpen;
    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL )
    @JoinColumn(name = "trainingId")
    private List<Stage> stages;

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getForWhom() {
        return forWhom;
    }

    public void setForWhom(String forWhom) {
        this.forWhom = forWhom;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Training training = (Training) o;

        return new EqualsBuilder()
                .append(trainingId, training.trainingId)
                .append(maxParticipants, training.maxParticipants)
                .append(title, training.title)
                .append(description, training.description)
                .append(category, training.category)
                .append(forWhom, training.forWhom)
                .append(goal, training.goal)
                .append(user, training.user)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(trainingId)
                .append(title)
                .append(description)
                .append(category)
                .append(forWhom)
                .append(goal)
                .append(maxParticipants)
                .append(user)
                .toHashCode();
    }
}
