package by.slivki.trainings.dao.impl;

import by.slivki.trainings.dao.api.ApplicationDao;
import by.slivki.trainings.dao.impl.criterias.ApplicationCriteria;
import by.slivki.trainings.dao.jpa.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ApplicationDaoImpl implements ApplicationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ApplicationCriteria applicationCriteria;

    @Override
    public Application createApplication(Application application) {
        entityManager.persist(application);
        return application;
    }

    @Override
    public Application loadById(int id) {
        try {
            return entityManager.createQuery(applicationCriteria.getApplicationById(id)).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Application> loadAll() {
        return entityManager.createQuery(applicationCriteria.getAll()).getResultList();
    }

    @Override
    public Application modify(Application application) {
        return entityManager.merge(application);
    }
}
