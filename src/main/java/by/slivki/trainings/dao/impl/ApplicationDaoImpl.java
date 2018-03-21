package by.slivki.trainings.dao.impl;

import by.slivki.trainings.dao.api.ApplicationDao;
import by.slivki.trainings.dao.jpa.Application;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ApplicationDaoImpl implements ApplicationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Application createApplication(Application application) {
        entityManager.persist(application);
        return application;
    }
}
