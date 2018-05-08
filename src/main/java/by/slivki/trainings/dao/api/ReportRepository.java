package by.slivki.trainings.dao.api;

import by.slivki.trainings.dao.jpa.QReport;
import by.slivki.trainings.dao.jpa.Report;
import by.slivki.trainings.dao.jpa.User;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(exported = false)
public interface ReportRepository extends
        CrudRepository<Report, Integer>,
        QuerydslPredicateExecutor<Report>,
        QuerydslBinderCustomizer<QReport> {

    List<Report> findAllByTask_TaskIdAndUser_UserId(int taskId, int userId);
    List<Report> findAllByUser_Username(String username);

    @Override
    default void customize(QuerydslBindings bindings, QReport root) { }
}