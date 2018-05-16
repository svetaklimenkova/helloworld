package by.slivki.trainings.rest.impl;

import by.slivki.trainings.rest.api.ReportController;
import by.slivki.trainings.rest.dto.BaseReportDto;
import by.slivki.trainings.rest.dto.ReportDto;
import by.slivki.trainings.rest.dto.TrainingDto;
import by.slivki.trainings.rest.mapper.ReportMapper;
import by.slivki.trainings.service.api.ReportService;
import by.slivki.trainings.util.RestMessage;
import by.slivki.trainings.util.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportControllerImpl implements ReportController {

    @Autowired
    private ReportService reportService;
    @Autowired
    private ReportMapper reportMapper;
    @Autowired
    private UserHelper userHelper;

    @Override
    public ResponseEntity<BaseReportDto> create(@PathVariable("taskId") int taskId, @RequestBody String message) {
        return ResponseEntity.ok(
                reportMapper.toBaseReportDto(reportService.create(
                        userHelper.getCurrentUser().getUsername(), taskId, message
        )));
    }

    @Override
    public ResponseEntity<List<ReportDto>> getUserReports() {
        return ResponseEntity.ok(reportMapper.toReportDtos(
                reportService.findAllByFromUser(userHelper.getCurrentUser().getUsername())));
    }

    @Override
    public ResponseEntity<List<ReportDto>> getTrainerReports() {
        return ResponseEntity.ok(reportMapper.toReportDtos(
                reportService.findAllByTrainer(userHelper.getCurrentUser().getUsername())));
    }

    @Override
    public ResponseEntity<BaseReportDto> update(
            @PathVariable("reportId") int reportId, @RequestParam("statusId") int statusId) {
        return ResponseEntity.ok(reportMapper.toBaseReportDto(reportService.updateStatus(reportId, statusId)));
    }
}
