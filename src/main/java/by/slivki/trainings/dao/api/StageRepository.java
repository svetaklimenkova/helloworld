package by.slivki.trainings.dao.api;

import by.slivki.trainings.dao.jpa.QStage;
import by.slivki.trainings.dao.jpa.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(exported = false)
public interface StageRepository extends
        JpaRepository<Stage, Integer>, QuerydslPredicateExecutor<Stage>, QuerydslBinderCustomizer<QStage> {

    Stage findByStageId(int stageId);

    List<Stage> findAllByTraining_TrainingId(int trainingId);

    @Override
    default void customize(QuerydslBindings bindings, QStage root) {}
}