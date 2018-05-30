package by.slivki.trainings.service.impl;

import by.slivki.trainings.dao.api.CategoryRepository;
import by.slivki.trainings.dao.api.TrainingRepository;
import by.slivki.trainings.dao.jpa.Category;
import by.slivki.trainings.exception.ErrorCode;
import by.slivki.trainings.exception.RestException;
import by.slivki.trainings.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TrainingRepository trainingRepository;

    @Override
    public Category create(String categoryName) {
        checkDuplicateName(categoryName);
        Category category = new Category();
        category.setCategoryName(categoryName);

        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAllByCategoryName(String categoryName) {
        return categoryRepository.findAllByCategoryNameContainingIgnoreCaseOrderByCategoryName(categoryName);
    }

    @Override
    public Category update(int id, String newName) {
        checkDuplicateName(newName);
        Category category = categoryRepository.findByCategoryId(id);
        category.setCategoryName(newName);
        return categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        if (trainingRepository.countByCategory_CategoryId(id) > 0) {
            throw new RestException(ErrorCode.CATEGORY_UNDER_TRAINING);
        }
        categoryRepository.deleteById(id);
    }

    private void checkDuplicateName(String categoryName) {
        if (categoryRepository.findByCategoryName(categoryName) != null) {
            throw new RestException(ErrorCode.CATEGORY_ALREADY_EXIST);
        }
    }
}
