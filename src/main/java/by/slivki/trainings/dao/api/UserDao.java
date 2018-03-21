package by.slivki.trainings.dao.api;

import by.slivki.trainings.dao.jpa.User;

import java.util.List;

public interface UserDao {
    User findUserByUsername(String username);
    User findUserByMail(String mail);
    User createUser(User user);
    User updateUser(User user);
    List<User> loadUserList();
}
