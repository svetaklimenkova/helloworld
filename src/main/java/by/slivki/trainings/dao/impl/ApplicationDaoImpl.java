package by.slivki.trainings.dao.impl;

import by.slivki.trainings.dao.api.ApplicationDao;
import by.slivki.trainings.dao.api.BaseDao;
import by.slivki.trainings.dao.impl.criterias.ApplicationCriteria;
import by.slivki.trainings.dao.jpa.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ApplicationDaoImpl extends BaseDao<Application> implements ApplicationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ApplicationCriteria applicationCriteria;

    @Override
    public Application getById(int id) {
        return super.get(applicationCriteria.getById(id));
    }

    @Override
    public List<Application> getAll() {
        return super.getAll(applicationCriteria.get());
    }

    @Override
    public List<Application> getAllByUserId(int id) {
        return super.getAll(applicationCriteria.getByUserId(id));
    }

}
