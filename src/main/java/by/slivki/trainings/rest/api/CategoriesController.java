package by.slivki.trainings.rest.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.constraints.Size;

@Validated
public interface CategoriesController {

    /**
     * Processes GET request to '/categories'.
     * Gets all categories.
     *
     * @return list of categories
     * */
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<?> getAll(String categoryName);

    /**
     * Processes POST request to '/categories'.
     * Creates a category by its name.
     *
     * @param categoryName category name
     *
     * @return result of creating a category (true or false)
     * */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> create(@RequestBody @Size(min = 2, max = 50, message = "form.categoryName.size")  String categoryName);

    /**
     * Process POST request to '/categories/{id}' and
     * updates category name.
     *
     * @return username
     * */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody @Size(min = 2, max = 50, message = "form.categoryName.size") String name);

    /**
     * Process DELETE request to '/categories/{id}' and
     * delete category.
     *
     * @return username
     * */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> delete(@PathVariable("id") int id);
}