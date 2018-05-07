package by.slivki.trainings.dao.api;

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
public interface TrainingMasterRepository extends
        CrudRepository<TrainingMaster, Integer>, QuerydslPredicateExecutor<TrainingMaster>,
        QuerydslBinderCustomizer<QTrainingMaster> {

    List<TrainingMaster> findAllByUser_Username(String username);
    TrainingMaster findByTraining_TrainingIdAndUser_Username(Integer trainingId, String username);

    int countByTraining_TrainingId(int trainingId);
    int countByTraining_TrainingIdAndUser_Username(Integer trainingId, String username);

    @Override
    default void customize(QuerydslBindings bindings, QTrainingMaster root) { }
}