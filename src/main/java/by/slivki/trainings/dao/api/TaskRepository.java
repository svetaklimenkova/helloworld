package by.slivki.trainings.dao.api;

import by.slivki.trainings.dao.jpa.QTask;
import by.slivki.trainings.dao.jpa.QTraining;
import by.slivki.trainings.dao.jpa.Task;
import by.slivki.trainings.dao.jpa.Training;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.domain.Pageable;
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
public interface TaskRepository extends
        CrudRepository<Task, Integer>,
        QuerydslPredicateExecutor<Task>,
        QuerydslBinderCustomizer<QTask> {

    Task findByTaskId(int taskId);

    @Override
    default void customize(QuerydslBindings bindings, QTask root) { }
}