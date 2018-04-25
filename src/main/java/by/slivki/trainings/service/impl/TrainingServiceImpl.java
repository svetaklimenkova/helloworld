package by.slivki.trainings.service.impl;

import by.slivki.trainings.dao.api.TrainingRepository;
import by.slivki.trainings.dao.api.UserRepository;
import by.slivki.trainings.dao.jpa.Application;
import by.slivki.trainings.dao.jpa.ApplicationTypeEnum;
import by.slivki.trainings.dao.jpa.Status;
import by.slivki.trainings.dao.jpa.StatusEnum;
import by.slivki.trainings.dao.jpa.Training;
import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.service.api.TrainingService;
import by.slivki.trainings.util.ApplicationHelper;
import by.slivki.trainings.util.UserHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {

    private static final Logger logger = LoggerFactory.getLogger(TrainingServiceImpl.class);

    @Autowired
    private TrainingRepository trainingRepository;

    @Override
    public Training create(Training training) {
        return trainingRepository.save(training);
    }

    @Override
    public Training getById(int id) {
        return trainingRepository.findByTrainingId(id);
    }

    @Override
    public void deleteTrainingById(int id) {
        trainingRepository.deleteById(id);
    }

    @Override
    public List<Training> loadAll(Pageable pageable) {
        return trainingRepository.findAll(pageable);
    }

    @Override
    public List<Training> loadAllByUsername(String username, Pageable pageable) {
        return trainingRepository.findAllByUser_Username(username, pageable);
    }

    @Override
    public Training update(Training training) {
        return trainingRepository.save(training);
    }
}
