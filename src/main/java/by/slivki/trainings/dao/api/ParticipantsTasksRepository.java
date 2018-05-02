package by.slivki.trainings.dao.api;

import by.slivki.trainings.dao.jpa.ParticipantsTask;
import by.slivki.trainings.dao.jpa.QParticipantsTask;
import by.slivki.trainings.dao.jpa.QTrainingMaster;
import by.slivki.trainings.dao.jpa.TrainingMaster;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(exported = false)
public interface ParticipantsTasksRepository extends
        CrudRepository<ParticipantsTask, Integer>, QuerydslPredicateExecutor<ParticipantsTask>,
        QuerydslBinderCustomizer<QParticipantsTask> {

    @Override
    default void customize(QuerydslBindings bindings, QParticipantsTask root) { }
}