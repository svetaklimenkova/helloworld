package by.slivki.trainings.service.api;

import by.slivki.trainings.dao.jpa.Training;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TrainingService {
    /**
     * Creates new training.
     *
     * @param training training
     *
     * @return created training
     * */
    Training create(Training training);

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
     *
     * */
    void deleteTrainingById(int id);

    /**
     * Loads all trainings.
     *
     * @return trainings
     * */
    List<Training> loadAll(Pageable pageable);

    /**
     * Loads all trainings by user id.
     *
     * @param username user name
     * @return trainings
     * */
    List<Training> loadAllByUsername(String username, Pageable pageable);

    /**
     * Update training.
     *
     * @param training training
     *
     * @return updated training
     * */
    Training update(Training training);
}
