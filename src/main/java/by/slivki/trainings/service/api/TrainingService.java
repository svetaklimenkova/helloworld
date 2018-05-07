package by.slivki.trainings.service.api;

import by.slivki.trainings.dao.jpa.Training;
import by.slivki.trainings.dao.jpa.TrainingMaster;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TrainingService {

    /**
     * Loads training by id.
     *
     * @param id training id
     *
     * @return training
     * */
    Training getById(int id);

    /**
     * Deletes training by id.
     *
     * @param id training id
     * */
    void deleteTrainingById(int id);

    /**
     * Finds trainings by predicate.
     *
     * @param predicate search predicate
     * @param pageable pageable object
     *
     * @return trainings
     * */
    List<Training> findAll(Predicate predicate, Pageable pageable);

    /**
     * Finds trainings by user id.
     *
     * @param username user name
     * @param pageable pageable object
     *
     * @return trainings
     * */
    List<Training> findAllByUsername(String username, Pageable pageable);

    /**
     * Saves or updates training. If training id = null, it saves.
     * Otherwise, training updates.
     *
     * @param training training
     *
     * @return updated training
     * */
    Training saveOrUpdate(Training training);

    /**
     * Added user to training by training id and user name.
     *
     * @param trainingId training id
     * @param username user name
     *
     * @return user master object
     * */
    TrainingMaster addUserToTraining(int trainingId, String username);

    /**
     * Deletes user from training by training id and user name.
     *
     * @param trainingId training id
     * @param username user name
     * */
    void deleteUserFromTraining(int trainingId, String username);
}
