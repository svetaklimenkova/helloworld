package by.slivki.trainings.dao.impl.criterias;

import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.dao.jpa.User_;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Component
public class UserCriteria {

    @PersistenceContext
    private EntityManager entityManager;

    public CriteriaQuery<User> get() {
        CriteriaQuery<User> query = getBuilder().createQuery(User.class);
        query.from(User.class);
        return query;
    }

    public CriteriaQuery<User> getById(int id) {
        CriteriaQuery<User> query = getBuilder().createQuery(User.class);
        Root<User> user = query.from(User.class);
        return query.where(getBuilder().equal(user.get(User_.userId), id));
    }

    public CriteriaQuery<User> getByUsername(String username) {
        CriteriaQuery<User> query = getBuilder().createQuery(User.class);
        Root<User> user = query.from(User.class);
        return query.where(getBuilder().equal(user.get(User_.username), username));
    }

    public CriteriaQuery<User> getByMail(String mail) {
        CriteriaQuery<User> query = getBuilder().createQuery(User.class);
        Root<User> user = query.from(User.class);
        return query.where(getBuilder().equal(user.get(User_.email), mail));
    }

    private CriteriaBuilder getBuilder() {
        return entityManager.getCriteriaBuilder();
    }
}
