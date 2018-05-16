package by.slivki.trainings.service.api;

import by.slivki.trainings.dao.jpa.Report;
import by.slivki.trainings.dao.jpa.User;

import java.util.List;

public interface ReportService {
    Report create(String username, int taskId, String message);
    List<Report> findAllByFromUser(String username);
    List<Report> findAllByTrainer(String username);
    Report updateStatus(int id, int statusId);
}
