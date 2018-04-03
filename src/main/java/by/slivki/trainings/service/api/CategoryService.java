package by.slivki.trainings.service.api;

import by.slivki.trainings.dao.jpa.Category;

import java.util.List;

public interface CategoryService {
    /**
     * Creates new category.
     *
     * @param categoryName category
     *
     * @return application
     * */
    Category create(String categoryName);

    /**
     * Loads all categories.
     *
     * @return list of categories
     * */
    List<Category> loadAll();

    /**
     * Update status of application.
     *
     * @param oldName old name of category
     * @param newName new name of category
     *
     * @return application
     * */
    Category update(String oldName, String newName);

    /**
     * Deletes application by id.
     *
     * @param categoryName category name
     *
     * */
    void delete(String categoryName);
}
