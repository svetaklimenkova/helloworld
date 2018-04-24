package by.slivki.trainings.dao.api;

import by.slivki.trainings.dao.jpa.Category;
import by.slivki.trainings.dao.jpa.QCategory;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(exported = false)
public interface CategoryRepository extends
        CrudRepository<Category, Integer>, QuerydslPredicateExecutor<Category>, QuerydslBinderCustomizer<QCategory> {

    Category findByCategoryName(String categoryName);
    Category findByCategoryId(int categoryId);

    List<Category> findAllByCategoryNameContainingIgnoreCaseOrderByCategoryName(String categotyName);

    @Override
    default void customize(QuerydslBindings bindings, QCategory root) {
        bindings.bind(String.class).first(
                (SingleValueBinding<StringPath, String>) StringExpression::equalsIgnoreCase);
    }
}