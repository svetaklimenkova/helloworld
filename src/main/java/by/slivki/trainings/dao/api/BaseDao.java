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
    @Override
    public T create(T object) {
        getEntityManager().persist(object);
        return object;
    }

    @Override
    public T get(CriteriaQuery<T> criteriaQuery) {
        T object = null;
        try {
            object = getEntityManager().createQuery(criteriaQuery).getSingleResult();
        } catch (NoResultException ignored) {

        }
        return object;
    }

    @Override
    public List<T> getAll(CriteriaQuery<T> criteriaQuery) {
        List<T> list = new ArrayList<>();
        try {
            list = getEntityManager().createQuery(criteriaQuery).getResultList();
        } catch (NoResultException ignored) {

        }
        return list;
    }

    @Override
    public T update(T object) {
        return getEntityManager().merge(object);
    }

    @Override
    public void delete(T object) {
        getEntityManager().remove(object);
    }

    public abstract EntityManager getEntityManager();
}
