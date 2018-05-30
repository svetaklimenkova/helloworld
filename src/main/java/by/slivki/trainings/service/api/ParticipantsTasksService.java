package by.slivki.trainings.service.api;

import by.slivki.trainings.dao.jpa.Stage;
import by.slivki.trainings.dao.jpa.Training;
import by.slivki.trainings.dao.jpa.User;

public interface ParticipantsTasksService {
    void addTasksToUser(Training training, User user);
    void delTasksFromUser(Training training, User user);
}
