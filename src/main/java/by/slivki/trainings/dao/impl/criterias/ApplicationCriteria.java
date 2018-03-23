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
import javax.persistence.criteria.Root;

@Component
public class ApplicationCriteria {

    @PersistenceContext
    private EntityManager entityManager;

    public CriteriaQuery<Application> getAll() {
        CriteriaQuery<Application> query = getBuilder().createQuery(Application.class);
        query.from(Application.class);
        return query;
    }

    public CriteriaQuery<Application> getApplicationById(int id) {
        CriteriaQuery<Application> query = getBuilder().createQuery(Application.class);
        Root<Application> application = query.from(Application.class);
        return query.where(getBuilder().equal(application.get(Application_.applicationId), id));
    }

    private CriteriaBuilder getBuilder() {
        return entityManager.getCriteriaBuilder();
    }
}
