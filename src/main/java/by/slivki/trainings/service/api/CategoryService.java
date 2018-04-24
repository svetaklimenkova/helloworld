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
    List<Category> findAllByCategoryName(String categoryName);

    /**
     * Update status of application.
     *
     * @param id category id
     * @param newName new name of category
     *
     * @return application
     * */
    Category update(int id, String newName);

    /**
     * Deletes application by id.
     *
     * @param id category id
     *
     * */
    void delete(int id);
}
