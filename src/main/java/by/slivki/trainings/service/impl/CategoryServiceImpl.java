package by.slivki.trainings.service.impl;

import by.slivki.trainings.dao.api.CategoryDao;
import by.slivki.trainings.dao.jpa.Category;
import by.slivki.trainings.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category create(String categoryName) {
        Category category = new Category();
        category.setCategoryName(categoryName);
        return categoryDao.create(category);
    }

    @Override
    public List<Category> loadAll() {
        return categoryDao.getAll();
    }

    @Override
    public Category update(String oldName, String newName) {
        Category category = categoryDao.get(oldName);
        category.setCategoryName(newName);
        return categoryDao.update(category);
    }

    @Override
    public void delete(String categoryName) {
        Category category = categoryDao.get(categoryName);
        categoryDao.delete(category);
    }
}
