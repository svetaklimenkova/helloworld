package by.slivki.trainings.rest.mapper;

import by.slivki.trainings.dao.api.ParticipantsTasksRepository;
import by.slivki.trainings.dao.api.ReportRepository;
import by.slivki.trainings.dao.jpa.ParticipantsTask;
import by.slivki.trainings.dao.jpa.Task;
import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.rest.dto.TaskDto;
import by.slivki.trainings.rest.dto.TaskExtDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class TaskMapper {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private ParticipantsTasksRepository participantsTasksRepository;
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private ReportMapper reportMapper;

    public List<TaskDto> toTaskDtos(List<Task> tasks) {
        List<TaskDto> taskDtos = new ArrayList<>();
        if (tasks != null) {
            for (Task task : tasks) {
                taskDtos.add(toTaskDto(task));
            }
        }
        return taskDtos;
    }

    public List<TaskExtDto> toTaskExtDtos(List<Task> tasks, User user, Locale locale) {
        List<TaskExtDto> taskDtos = new ArrayList<>();
        if (tasks != null) {
            for (Task task : tasks) {
                taskDtos.add(toTaskExtDto(task, user, locale));
            }
        }
        return taskDtos;
    }

    private TaskExtDto toTaskExtDto(Task task, User user, Locale locale) {
        TaskExtDto taskDto = new TaskExtDto();
        taskDto.setId(task.getTaskId());
        taskDto.setName(task.getTaskName());
        ParticipantsTask userTask = participantsTasksRepository
                .findByTask_TaskIdAndUser_UserId(task.getTaskId(), user.getUserId());
        if (userTask != null) {
            taskDto.setStatus(messageSource.getMessage(
                    "tasks.status." + userTask.getTaskStatus().getTaskStatusName().toLowerCase(locale),
                    null, locale));
            taskDto.setStatusId(userTask.getTaskStatus().getTaskStatusId());
        }
        taskDto.setReports(reportMapper.toBaseReportDtos(
                reportRepository.findAllByTask_TaskIdAndUser_UserId(
                        task.getTaskId(), user.getUserId()
                )));
        return taskDto;
    }

    private TaskDto toTaskDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getTaskId());
        taskDto.setName(task.getTaskName());
        return taskDto;
    }

    public List<Task> toEntities(List<TaskDto> taskDtos) {
        List<Task> tasks = new ArrayList<>();
        if (taskDtos != null) {
            for (TaskDto taskDto : taskDtos) {
                tasks.add(toEntity(taskDto));
            }
        }
        return tasks;
    }

    public Task toEntity(TaskDto taskDto) {
        Task task = new Task();
        task.setTaskId(taskDto.getId());
        task.setTaskName(taskDto.getName());
        return task;
    }
}
