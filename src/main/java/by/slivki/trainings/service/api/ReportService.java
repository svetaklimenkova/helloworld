package by.slivki.trainings.service.api;

import by.slivki.trainings.dao.jpa.Report;
import by.slivki.trainings.dao.jpa.User;

public interface ReportService {
    Report create(String username, int taskId, String message);
}
