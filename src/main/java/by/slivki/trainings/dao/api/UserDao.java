package by.slivki.trainings.dao.api;

import by.slivki.trainings.dao.jpa.User;

public interface UserDao {
    User findUserByUsername(String username);
    void createUser(User user);
}
