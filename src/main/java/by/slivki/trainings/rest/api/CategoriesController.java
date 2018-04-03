package by.slivki.trainings.rest.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface CategoriesController {

    /**
     * Processes GET request to '/categories'.
     * Gets all categories.
     *
     * @return list of categories
     * */
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<?> getAll();

    /**
     * Processes POST request to '/categories'.
     * Creates a category by its name.
     *
     * @param categoryName category name
     *
     * @return result of creating a category (true or false)
     * */
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> create(@RequestBody String categoryName);

    /**
     * Process POST request to '/categories/{id}' and
     * updates category name.
     *
     * @return username
     * */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody String name);

    /**
     * Process DELETE request to '/categories/{id}' and
     * delete category.
     *
     * @return username
     * */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> delete(@PathVariable("id") int id);
}