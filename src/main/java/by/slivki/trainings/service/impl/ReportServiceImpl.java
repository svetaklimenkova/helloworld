package by.slivki.trainings.service.impl;

import by.slivki.trainings.dao.api.ParticipantsTasksRepository;
import by.slivki.trainings.dao.api.ReportRepository;
import by.slivki.trainings.dao.api.TaskRepository;
import by.slivki.trainings.dao.jpa.*;
import by.slivki.trainings.service.api.ReportService;
import by.slivki.trainings.service.api.UserService;
import by.slivki.trainings.util.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private ParticipantsTasksRepository participantsTasksRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserHelper userHelper;
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

    @Override
    public List<Report> findAllByFromUser(String username) {
        return reportRepository.findAllByUser_Username(username);
    }

    @Override
    public List<Report> findAllByTrainer(String username) {
        return reportRepository.findAllByTask_Stage_Training_User_Username(username);
    }

    @Override
    public Report updateStatus(int id, int statusId) {
        Report report = reportRepository.findById(id).orElse(null);
        if (report != null) {
            report.setStatus(new Status(StatusEnum.fromI(statusId)));
            report = reportRepository.save(report);
            if (report.getStatus().getStatusId() == StatusEnum.ACCEPTED.getI()) {
                ParticipantsTask parTask = participantsTasksRepository
                        .findByTask_TaskIdAndUser_UserId(
                                report.getTask().getTaskId(),
                                report.getUser().getUserId());
                if (parTask != null) {
                    parTask.setTaskStatus(new TaskStatus(TaskStatusEnum.FINISHED));
                    participantsTasksRepository.save(parTask);
                }
            }
        }
        return report;
    }
}
