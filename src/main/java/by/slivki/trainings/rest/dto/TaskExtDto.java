package by.slivki.trainings.rest.dto;

import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode
public class TaskExtDto extends TaskDto {
    private String status;
    private int statusId;
    private List<BaseReportDto> reports;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<BaseReportDto> getReports() {
        return reports;
    }

    public void setReports(List<BaseReportDto> reports) {
        this.reports = reports;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }
}
