package by.slivki.trainings.service.impl;

import by.slivki.trainings.dao.api.UserDao;
import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * {@inheritDoc}
     * */
    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public boolean checkUsername(String username) {
        return userDao.findUserByUsername(username) == null;
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public User loadUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }
}
