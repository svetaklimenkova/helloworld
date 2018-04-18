package by.slivki.trainings.service.impl;

import by.slivki.trainings.dao.api.CategoryRepository;
import by.slivki.trainings.dao.jpa.Category;
import by.slivki.trainings.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category create(String categoryName) {
        Category category = new Category();
        category.setCategoryName(categoryName);
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAllByCategoryName(String categoryName) {
        return categoryRepository.findAllByCategoryNameContainingIgnoreCaseOrderByCategoryName(categoryName);
    }

    @Override
    public Category update(String oldName, String newName) {
        Category category = categoryRepository.findByCategoryName(oldName);
        category.setCategoryName(newName);
        return categoryRepository.save(category);
    }

    @Override
    public void delete(String categoryName) {
        Category category = categoryRepository.findByCategoryName(categoryName);
        categoryRepository.delete(category);
    }
}
