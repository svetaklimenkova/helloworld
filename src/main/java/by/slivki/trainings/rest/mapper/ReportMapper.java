package by.slivki.trainings.rest.mapper;

import by.slivki.trainings.dao.jpa.Report;
import by.slivki.trainings.rest.dto.BaseReportDto;
import by.slivki.trainings.rest.dto.ReportDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReportMapper {

    public List<ReportDto> toReportDtos(List<Report> reports) {
        List<ReportDto> reportDtos = new ArrayList<>();
        if (reports != null) {
            for (Report report : reports) {
                reportDtos.add(toReportDto(report));
            }
        }
        return reportDtos;
    }

    private ReportDto toReportDto(Report report) {
        ReportDto dto = new ReportDto();
        dto.setId(report.getReportId());
        dto.setMessage(report.getMessage());
        dto.setStatus(report.getStatus().getStatusName());
        dto.setStatusId(report.getStatus().getStatusId());
        dto.setCreatedBy(report.getCreatedBy());
        dto.setTraining(report.getTask().getStage().getTraining().getTitle());
        dto.setTask(report.getTask().getTaskName());
        dto.setFrom(report.getUser().getUsername());
        return dto;
    }

    public List<BaseReportDto> toBaseReportDtos(List<Report> reports) {
        List<BaseReportDto> reportDtos = new ArrayList<>();
        if (reports != null) {
            for (Report report : reports) {
                reportDtos.add(toBaseReportDto(report));
            }
        }
        return reportDtos;
    }

    public BaseReportDto toBaseReportDto(Report report) {
        BaseReportDto dto = new BaseReportDto();
        dto.setId(report.getReportId());
        dto.setMessage(report.getMessage());
        dto.setStatus(report.getStatus().getStatusName());
        dto.setStatusId(report.getStatus().getStatusId());
        dto.setCreatedBy(report.getCreatedBy());
        return dto;
    }
}
