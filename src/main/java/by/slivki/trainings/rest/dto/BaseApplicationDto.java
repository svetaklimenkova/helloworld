package by.slivki.trainings.rest.dto;

import java.util.Date;

public class BaseApplicationDto {
    private int id;
    private String type;
    private String mailOfReceiver;
    private String status;
    private Date createdBy;
    private Date updatedBy;

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getMailOfReceiver() {
        return mailOfReceiver;
    }

    public String getStatus() {
        return status;
    }

    public Date getCreatedBy() {
        return createdBy;
    }

    public Date getUpdatedBy() {
        return updatedBy;
    }

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
