package by.slivki.trainings.dao.api;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public interface CrudDao<T> {
    /**
     * Creates entity.
     *
     * @param object object
     *
     * @return object
     * */
    T create(T object);

    /**
     * Loads entity from db by criteria query.
     *
     * @param criteriaQuery criteria query
     *
     * @return object
     * */
    T get(CriteriaQuery<T> criteriaQuery);

    /**
     * Loads all entities from db by criteria query.
     *
     * @param criteriaQuery criteria query
     *
     * @return list of objects
     * */
    List<T> getAll(CriteriaQuery<T> criteriaQuery);

    /**
     * Updates entity.
     *
     * @param object object
     *
     * @return object
     * */
    T update(T object);

    /**
     * Deletes entity.
     *
     * @param object object
     * */
    void delete(T object);
}
