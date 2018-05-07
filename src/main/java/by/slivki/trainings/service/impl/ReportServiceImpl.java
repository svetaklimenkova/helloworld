package by.slivki.trainings.service.impl;

import by.slivki.trainings.dao.api.ReportRepository;
import by.slivki.trainings.dao.api.TaskRepository;
import by.slivki.trainings.dao.jpa.Report;
import by.slivki.trainings.dao.jpa.Status;
import by.slivki.trainings.dao.jpa.StatusEnum;
import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.service.api.ReportService;
import by.slivki.trainings.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Report create(String username, int taskId, String message) {
        Report report = new Report();
        report.setUser(userService.findByUsername(username));
        report.setTask(taskRepository.findByTaskId(taskId));
        report.setMessage(message);
        report.setStatus(new Status(StatusEnum.IN_PROGRESS));
        report.setCreatedBy(new Date());
        return reportRepository.save(report);
    }
}