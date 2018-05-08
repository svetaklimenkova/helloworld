package by.slivki.trainings.rest.api;

import by.slivki.trainings.rest.dto.BaseReportDto;
import by.slivki.trainings.rest.dto.ReportDto;
import by.slivki.trainings.rest.dto.TrainingDto;
import by.slivki.trainings.util.RestMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    ResponseEntity<List<ReportDto>> getUserReports();
}
