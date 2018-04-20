package by.slivki.trainings.service.impl;

import by.slivki.trainings.dao.api.UserRepository;
import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * {@inheritDoc}
     * */
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public boolean checkUsername(String username) {
        return userRepository.findByUsername(username) == null;
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public boolean checkMail(String mail) {
        return userRepository.findByEmail(mail) == null;
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public User findByMail(String mail){
        return userRepository.findByEmail(mail);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public User update(User user){
        return userRepository.save(user);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> findAll() {
        return userRepository.findAllByOrderByRole_RoleName();
    }
}
