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
     * Process POST request to '/rest/trainings/{trainingId}/tasks/{taskId}/reports'.
     * Creates report for current user.
     *
     * @param taskId task id
     * @param message message of report
     *
     * @return report
     * */
    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/rest/trainings/{trainingId}/tasks/{taskId}/reports")
    ResponseEntity<BaseReportDto> create(
            @PathVariable("taskId") int taskId, @RequestBody String message);

    /**
     * Process GET request to '/rest/user/reports'.
     * Loads all users reports.
     *
     * @return reports
     * */
    @GetMapping("/rest/user/reports")
    @PreAuthorize("hasRole('ROLE_USER')")
    ResponseEntity<List<ReportDto>> getUserReports();

    /**
     * Process GET request to '/rest/reports'.
     * Loads all users reports for current trainer.
     *
     * @return reports
     * */
    @GetMapping("/rest/reports")
    @PreAuthorize("hasRole('ROLE_TRAINER')")
    ResponseEntity<List<ReportDto>> getTrainerReports();

    /**
     * Process POST request to '/rest/reports/{reportId}'.
     * Updates report status.
     *
     * @return report
     * */
    @PostMapping("/rest/reports/{reportId}")
    @PreAuthorize("hasRole('ROLE_TRAINER')")
    ResponseEntity<BaseReportDto> update(
            @PathVariable("reportId") int reportId, @RequestParam("statusId") int statusId);
}
