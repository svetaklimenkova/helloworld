package by.slivki.trainings.dao.api;

import by.slivki.trainings.dao.jpa.Application;

import java.util.List;

public interface ApplicationDao extends CrudDao<Application>{
    Application getById(int id);
    List<Application> getAll();
    List<Application> getAllByUserId(int id);
}
