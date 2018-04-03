package by.slivki.trainings.dao.api;

import by.slivki.trainings.dao.jpa.Category;

import java.util.List;

public interface CategoryDao extends CrudDao<Category> {
    List<Category> getAll();
    Category get(String name);
}
