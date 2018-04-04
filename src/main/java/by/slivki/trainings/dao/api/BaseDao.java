package by.slivki.trainings.dao.api;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public abstract class BaseDao<T> implements CrudDao<T> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public T create(T object) {
        entityManager.persist(object);
        return object;
    }

    @Override
    public T get(CriteriaQuery<T> criteriaQuery) {
        T object;
        try {
            object = entityManager.createQuery(criteriaQuery).getSingleResult();
        } catch (NoResultException e) {
            object = null;
        }
        return object;
    }

    @Override
    public List<T> getAll(CriteriaQuery<T> criteriaQuery) {
        List<T> list;
        try {
            list = entityManager.createQuery(criteriaQuery).getResultList();
        } catch (NoResultException e) {
            list = new ArrayList<>();
        }
        return list;
    }

    @Override
    public T update(T object) {
        return entityManager.merge(object);
    }

    @Override
    public void delete(T object) {
        entityManager.remove(object);
    }
}
