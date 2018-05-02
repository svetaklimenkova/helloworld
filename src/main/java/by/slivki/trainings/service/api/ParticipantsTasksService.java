package by.slivki.trainings.service.api;

import by.slivki.trainings.dao.jpa.Stage;
import by.slivki.trainings.dao.jpa.User;

public interface ParticipantsTasksService {
    void addTasksToUser(Stage stage, User user);
}
