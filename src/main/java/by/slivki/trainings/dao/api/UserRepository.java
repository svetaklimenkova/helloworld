package by.slivki.trainings.dao.api;

import by.slivki.trainings.dao.jpa.QUser;
import by.slivki.trainings.dao.jpa.User;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(exported = false)
public interface UserRepository extends
        CrudRepository<User, Integer>, QuerydslPredicateExecutor<User>, QuerydslBinderCustomizer<QUser> {

    User findByUserId(int userId);
    User findByUsername(String username);
    User findByEmail(String email);

    List<User> findAllByOrderByRole_RoleName();

    @Override
    default void customize(QuerydslBindings bindings, QUser root) {

    }
}