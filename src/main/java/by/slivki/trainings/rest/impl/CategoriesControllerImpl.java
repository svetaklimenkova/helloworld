package by.slivki.trainings.rest.impl;

import by.slivki.trainings.rest.api.CategoriesController;
import by.slivki.trainings.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/categories")
public class CategoriesControllerImpl implements CategoriesController {

    @Autowired
    private CategoryService categoryService;

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(categoryService.loadAll());
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
