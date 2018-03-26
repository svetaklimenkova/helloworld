package by.slivki.trainings.dao.api;

import by.slivki.trainings.dao.jpa.User;

import java.util.List;

public interface UserDao extends CrudDao<User> {
    User getById(int id);
    User getByUsername(String username);
    User getByMail(String mail);
    List<User> getAll();
}
