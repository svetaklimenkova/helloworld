package by.slivki.trainings.dao.impl.criterias;

import by.slivki.trainings.dao.jpa.Application;
import by.slivki.trainings.dao.jpa.Application_;
import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.dao.jpa.User_;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

@Component
public class ApplicationCriteria {

    @PersistenceContext
    private EntityManager entityManager;

    public CriteriaQuery<Application> get() {
        CriteriaQuery<Application> query = getBuilder().createQuery(Application.class);
        query.from(Application.class);
        return query;
    }

    public CriteriaQuery<Application> getById(int id) {
        CriteriaQuery<Application> query = getBuilder().createQuery(Application.class);
        Root<Application> application = query.from(Application.class);
        return query.where(getBuilder().equal(application.get(Application_.applicationId), id));
    }

    public CriteriaQuery<Application> getByUserId(int id) {
        CriteriaQuery<Application> query = getBuilder().createQuery(Application.class);
        Root<Application> application = query.from(Application.class);
        Join<Application, User> user = application.join(Application_.user);
        return query.where(getBuilder().equal(user.get(User_.userId), id));
    }

    private CriteriaBuilder getBuilder() {
        return entityManager.getCriteriaBuilder();
    }
}
