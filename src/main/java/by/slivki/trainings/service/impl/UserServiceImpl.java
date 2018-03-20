package by.slivki.trainings.service.impl;

import by.slivki.trainings.dao.api.UserDao;
import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.rest.dto.UserListItemDto;
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
    public boolean checkMail(String mail) {
        return userDao.findUserByMail(mail) == null;
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public User loadUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public User loadUserByMail(String mail){
        return userDao.findUserByMail(mail);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public User updateUser(User user){
        return userDao.updateUser(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> loadUserList() {
        return userDao.loadUserList();
    }
}
