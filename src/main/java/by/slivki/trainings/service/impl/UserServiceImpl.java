package by.slivki.trainings.service.impl;

import by.slivki.trainings.dao.api.UserDao;
import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * {@inheritDoc}
     * */
    @Override
    public User createUser(User user) {
        return userDao.create(user);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public boolean checkUsername(String username) {
        return userDao.getByUsername(username) == null;
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public boolean checkMail(String mail) {
        return userDao.getByMail(mail) == null;
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public User loadUserByUsername(String username) {
        return userDao.getByUsername(username);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public User loadUserByMail(String mail){
        return userDao.getByMail(mail);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public User updateUser(User user){
        return userDao.update(user);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public void deleteUser(int id) {
        userDao.delete(userDao.getById(id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> loadAll() {
        return userDao.getAll();
    }
}
