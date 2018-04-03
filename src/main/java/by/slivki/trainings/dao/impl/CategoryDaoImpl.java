package by.slivki.trainings.dao.impl;

import by.slivki.trainings.dao.api.BaseDao;
import by.slivki.trainings.dao.api.CategoryDao;
import by.slivki.trainings.dao.impl.criterias.CategoryCriteria;
import by.slivki.trainings.dao.jpa.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDaoImpl extends BaseDao<Category> implements CategoryDao {

    @Autowired
    private CategoryCriteria categoryCriteria;

    @Override
    public List<Category> getAll() {
        return super.getAll(categoryCriteria.get());
    }

    @Override
    public Category get(String name) {
        return super.get(categoryCriteria.byCategoryName(name));
    }
}
