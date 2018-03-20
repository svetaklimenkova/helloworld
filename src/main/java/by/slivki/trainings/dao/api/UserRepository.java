package by.slivki.trainings.dao.api;

import by.slivki.trainings.dao.jpa.User;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface UserRepository extends BaseRepository<User> {
    List<User> findAll();
    List<User> findAll(Specification<User> specification);
    User findOne(Specification<User> specification);
}
