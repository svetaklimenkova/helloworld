package by.slivki.trainings.dao.api;

import by.slivki.trainings.dao.jpa.User;

public interface UserDao {
    User findUserByUsername(String username);
    User findUserByMail(String mail);
    void createUser(User user);
    User updateUser(User user);
}
