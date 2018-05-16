package by.slivki.trainings.rest.api;

import by.slivki.trainings.rest.dto.BaseReportDto;
import by.slivki.trainings.rest.dto.ReportDto;
import by.slivki.trainings.rest.dto.TrainingDto;
import by.slivki.trainings.util.RestMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ReportController {

    /**
     * Process POST request to '/trainings/'.
     * Creates training for current user.
     *
     * @return training
     * */
    @PostMapping("/rest/trainings/{trainingId}/tasks/{taskId}/reports")
    ResponseEntity<BaseReportDto> create(
            @PathVariable("taskId") int taskId, @RequestBody String message);

    @GetMapping("/rest/user/reports")
    @PreAuthorize("hasRole('ROLE_USER')")
    ResponseEntity<List<ReportDto>> getUserReports();

    @GetMapping("/rest/reports")
    @PreAuthorize("hasRole('ROLE_TRAINER')")
    ResponseEntity<List<ReportDto>> getTrainerReports();

    @PostMapping("/rest/reports/{reportId}")
    ResponseEntity<BaseReportDto> update(
            @PathVariable("reportId") int reportId, @RequestParam("statusId") int statusId);
}
