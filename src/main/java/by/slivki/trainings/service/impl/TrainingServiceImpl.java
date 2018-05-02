package by.slivki.trainings.service.impl;

import by.slivki.trainings.dao.api.TrainingMasterRepository;
import by.slivki.trainings.dao.api.TrainingRepository;
import by.slivki.trainings.dao.api.UserRepository;
import by.slivki.trainings.dao.jpa.Stage;
import by.slivki.trainings.dao.jpa.Task;
import by.slivki.trainings.dao.jpa.Training;
import by.slivki.trainings.dao.jpa.TrainingMaster;
import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.exception.ErrorCode;
import by.slivki.trainings.exception.RestException;
import by.slivki.trainings.service.api.ParticipantsTasksService;
import by.slivki.trainings.service.api.TrainingService;
import com.querydsl.core.types.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {

    private static final Logger logger = LoggerFactory.getLogger(TrainingServiceImpl.class);

    @Autowired
    private TrainingRepository trainingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TrainingMasterRepository trainingMasterRepository;
    @Autowired
    private ParticipantsTasksService participantsTasksService;

    @Override
    public Training getById(int id) {
        return trainingRepository.findByTrainingId(id);
    }

    @Override
    public void deleteTrainingById(int id) {
        trainingRepository.deleteById(id);
    }

    @Override
    public List<Training> findAll(Predicate predicate, Pageable pageable) {
        return trainingRepository.findAll(predicate, pageable).getContent();
    }

    @Override
    public List<Training> findAllByUsername(String username, Pageable pageable) {
        return trainingRepository.findAllByUser_Username(username, pageable);
    }

    @Override
    public Training saveOrUpdate(Training training) {
        List<Stage> stages = training.getStages();
        for (Stage stage : stages) {
            if (stage.getTraining() == null) {
                stage.setTraining(training);
            }
            if (stage.getTasks() == null && stage.getTasks().size() == 0) {
                continue;
            }
            for (Task task : stage.getTasks()) {
                task.setStage(stage);
            }
        }
        return trainingRepository.save(training);
    }

    @Override
    public TrainingMaster addUserToTraining(int trainingId, String username) {
        Training training = trainingRepository.findByTrainingId(trainingId);
        User user = userRepository.findByUsername(username);
        checkTrainingIsOpen(training);
        checkUserAlreadyInTraining(training, username);

        TrainingMaster trainingMaster = new TrainingMaster();
        trainingMaster.setTraining(training);
        trainingMaster.setUser(user);
        trainingMaster = trainingMasterRepository.save(trainingMaster);

        if (training.getStages() != null && training.getStages().size() > 0) {
            participantsTasksService.addTasksToUser(training.getStages().get(0), user);
        }

        checkTrainingParticipants(training);
        return trainingMaster;
    }

    private void checkTrainingParticipants(Training training) {
        int trainingParticipantsCount =
                trainingMasterRepository.countByTraining_TrainingId(training.getTrainingId());
        if (trainingParticipantsCount >= training.getMaxParticipants()) {
            training.setOpen(false);
            trainingRepository.save(training);
        }
    }

    private void checkUserAlreadyInTraining(Training training, String username) {
        boolean userAlreadyInTraining =
                trainingMasterRepository.countByTraining_TrainingIdAndUser_Username(
                training.getTrainingId(), username) > 0;
        if (userAlreadyInTraining) {
            throw new RestException(ErrorCode.USER_ALREADY_IN_TRAINING);
        }
    }

    private void checkTrainingIsOpen(Training training) {
        if (!training.isOpen()) {
            throw new RestException(ErrorCode.TRAINING_CLOSED);
        }
    }
}
