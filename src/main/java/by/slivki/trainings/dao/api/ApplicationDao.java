package by.slivki.trainings.dao.api;

import by.slivki.trainings.dao.jpa.Application;

import java.util.List;

public interface ApplicationDao {
    Application createApplication(Application application);
    Application loadById(int id);
    List<Application> loadAll();
    Application modify(Application application);
}
