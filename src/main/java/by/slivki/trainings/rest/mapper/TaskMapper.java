package by.slivki.trainings.rest.mapper;

import by.slivki.trainings.dao.jpa.Task;
import by.slivki.trainings.rest.dto.TaskDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskMapper {

    public List<TaskDto> toTaskDtos(List<Task> tasks) {
        List<TaskDto> taskDtos = new ArrayList<>();
        if (tasks != null) {
            for (Task task : tasks) {
                taskDtos.add(toTaskDto(task));
            }
        }
        return taskDtos;
    }

    public TaskDto toTaskDto(Task task) {
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
