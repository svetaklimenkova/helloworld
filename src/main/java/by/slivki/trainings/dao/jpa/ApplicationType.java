package by.slivki.trainings.dao.jpa;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="applicationtype")
public class ApplicationType {
    @Column
    @Id
    private int applicationTypeId;
    @Column
    private String applicationTypeName;

    public ApplicationType(ApplicationTypeEnum applicationTypeEnum) {
        this.applicationTypeId = applicationTypeEnum.getI();
        this.applicationTypeName = applicationTypeEnum.name();
    }

    public int getApplicationTypeId() {
        return applicationTypeId;
    }

    public void setApplicationTypeId(int applicationTypeId) {
        this.applicationTypeId = applicationTypeId;
    }

    public String getApplicationTypeName() {
        return applicationTypeName;
    }

    public void setApplicationTypeName(String applicationTypeName) {
        this.applicationTypeName = applicationTypeName;
    }
}
