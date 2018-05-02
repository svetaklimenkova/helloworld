package by.slivki.trainings.service.api;

import by.slivki.trainings.dao.jpa.Training;
import by.slivki.trainings.dao.jpa.TrainingMaster;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TrainingMasterService {
    List<Training> findAllByParticipantName(String participantName);
}
