package by.slivki.trainings.rest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
public class BaseApplicationDto {
    private int id;
    private String type;
    private String mailOfReceiver;
    private String status;
    private Date createdBy;
    private Date updatedBy;

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMailOfReceiver(String mailOfReceiver) {
        this.mailOfReceiver = mailOfReceiver;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedBy(Date createdBy) {
        this.createdBy = createdBy;
    }

    public void setUpdatedBy(Date updatedBy) {
        this.updatedBy = updatedBy;
    }
}
