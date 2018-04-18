package by.slivki.trainings.rest.impl;

import by.slivki.trainings.dao.jpa.Category;
import by.slivki.trainings.rest.api.CategoriesController;
import by.slivki.trainings.rest.mapper.CategoryMapper;
import by.slivki.trainings.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/categories")
public class CategoriesControllerImpl implements CategoriesController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ResponseEntity<?> getAll(
            @RequestParam(value = "name", required = false, defaultValue = "") String categoryName) {
        List<Category> list = categoryService.findAllByCategoryName(categoryName);
        return ResponseEntity.ok(
                categoryMapper.toCategoryDtos(list));
    }

    @Override
    public ResponseEntity<?> create(String categoryName) {
        return ResponseEntity.ok(categoryService.create(categoryName));
    }

    @Override
    public ResponseEntity<?> update(int id, String name) {
        // FIXME: 4/3/2018
        return null;
    }

    @Override
    public ResponseEntity<?> delete(int id) {
        // FIXME: 4/3/2018
        return null;
    }
}
