package by.slivki.trainings.rest.dto;

public class ApplicationDto extends BaseApplicationDto {
    private String receiver;
    private String description;

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
