package by.slivki.trainings.dao.impl.criterias;

import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.dao.jpa.User_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserCriteria {

    private CriteriaBuilder builder;

    public UserCriteria(CriteriaBuilder builder) {
        this.builder = builder;
    }

    public CriteriaQuery<User> getAll() {
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> user = query.from(User.class);
        return query.where(builder.equal(user.get(User_.isConfirmed), true));
    }

    public CriteriaQuery<User> getUserByUsername(String username) {
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> user = query.from(User.class);
        return query.where(builder.equal(user.get(User_.username), username));
    }
}
