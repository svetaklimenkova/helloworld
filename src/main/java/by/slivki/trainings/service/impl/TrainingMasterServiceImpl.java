package by.slivki.trainings.service.impl;

import by.slivki.trainings.dao.api.TrainingMasterRepository;
import by.slivki.trainings.dao.jpa.Training;
import by.slivki.trainings.dao.jpa.TrainingMaster;
import by.slivki.trainings.service.api.TrainingMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingMasterServiceImpl implements TrainingMasterService {

    @Autowired
    private TrainingMasterRepository trainingMasterRepository;

    @Override
    public List<Training> findAllByParticipantName(String participantName) {
        List<TrainingMaster> trainingMasters = trainingMasterRepository.findAllByUser_Username(participantName);
        List<Training> trainings = new ArrayList<>();
        for (TrainingMaster trainingMaster : trainingMasters) {
            trainings.add(trainingMaster.getTraining());
        }
        return trainings;
    }
}
