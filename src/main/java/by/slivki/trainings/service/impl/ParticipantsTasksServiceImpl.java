package by.slivki.trainings.service.impl;

import by.slivki.trainings.dao.api.ParticipantsTasksRepository;
import by.slivki.trainings.dao.jpa.ParticipantsTask;
import by.slivki.trainings.dao.jpa.Stage;
import by.slivki.trainings.dao.jpa.Task;
import by.slivki.trainings.dao.jpa.TaskStatus;
import by.slivki.trainings.dao.jpa.TaskStatusEnum;
import by.slivki.trainings.dao.jpa.Training;
import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.service.api.ParticipantsTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantsTasksServiceImpl implements ParticipantsTasksService {

    @Autowired
    private ParticipantsTasksRepository participantsTasksRepository;

    @Override
    public void addTasksToUser(Stage stage, User user) {
        for (Task task : stage.getTasks()) {
            ParticipantsTask participantsTask = new ParticipantsTask();
            participantsTask.setUser(user);
            participantsTask.setTask(task);
            participantsTask.setTaskStatus(new TaskStatus(TaskStatusEnum.NOT_STARTED));
            participantsTasksRepository.save(participantsTask);
        }
    }
}
