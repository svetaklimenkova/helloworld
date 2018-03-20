package by.slivki.trainings.dao.impl;

import by.slivki.trainings.dao.api.UserRepository;
import by.slivki.trainings.dao.jpa.User;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findAll(Specification<User> specification) {
        return null;
    }

    @Override
    public User findOne(Specification<User> specification) {
        return null;
    }
}
