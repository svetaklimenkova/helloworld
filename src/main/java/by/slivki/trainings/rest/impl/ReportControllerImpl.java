package by.slivki.trainings.rest.impl;

import by.slivki.trainings.rest.api.ReportController;
import by.slivki.trainings.rest.dto.BaseReportDto;
import by.slivki.trainings.rest.dto.TrainingDto;
import by.slivki.trainings.rest.mapper.ReportMapper;
import by.slivki.trainings.service.api.ReportService;
import by.slivki.trainings.util.RestMessage;
import by.slivki.trainings.util.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportControllerImpl implements ReportController {

    @Autowired
    private ReportService reportService;
    @Autowired
    private ReportMapper reportMapper;
    @Autowired
    private UserHelper userHelper;

    @Override
    public ResponseEntity<BaseReportDto> create(int taskId, String message) {
        return ResponseEntity.ok(
                reportMapper.toBaseReportDto(reportService.create(
                        userHelper.getCurrentUser().getUsername(), taskId, message
        )));
    }
}
