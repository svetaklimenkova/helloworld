package by.slivki.trainings.dao.impl.criterias;

import by.slivki.trainings.dao.jpa.Category;
import by.slivki.trainings.dao.jpa.Category_;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Component
public class CategoryCriteria {

    @PersistenceContext
    private EntityManager entityManager;

    public CriteriaQuery<Category> get() {
        CriteriaQuery<Category> query = getBuilder().createQuery(Category.class);
        query.from(Category.class);
        return query;
    }

    public CriteriaQuery<Category> byCategoryName(String categoryName) {
        CriteriaQuery<Category> query = getBuilder().createQuery(Category.class);
        Root<Category> user = query.from(Category.class);
        return query.where(getBuilder().equal(user.get(Category_.categoryName), categoryName));
    }

    private CriteriaBuilder getBuilder() {
        return entityManager.getCriteriaBuilder();
    }
}
