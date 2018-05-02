package by.slivki.trainings.rest.impl;

import by.slivki.trainings.dao.jpa.Category;
import by.slivki.trainings.rest.api.CategoriesController;
import by.slivki.trainings.rest.dto.CategoryDto;
import by.slivki.trainings.rest.mapper.CategoryMapper;
import by.slivki.trainings.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<List<CategoryDto>> getAll(
            @RequestParam(value = "name", required = false, defaultValue = "") String categoryName) {
        List<Category> list = categoryService.findAllByCategoryName(categoryName);
        return ResponseEntity.ok(categoryMapper.toCategoryDtos(list));
    }

    @Override
    public ResponseEntity<?> create(@RequestBody String categoryName) {
        return ResponseEntity.ok(categoryService.create(categoryName));
    }

    @Override
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody String name) {
        CategoryDto category = categoryMapper.toCategoryDto(categoryService.update(id, name));
        return ResponseEntity.ok(category);
    }

    @Override
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        categoryService.delete(id);
        return null;
    }
}
