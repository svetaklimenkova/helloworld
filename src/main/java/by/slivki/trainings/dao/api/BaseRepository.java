package by.slivki.trainings.dao.api;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface BaseRepository<T> {

    List<T> findAll();
    List<T> findAll(Specification<T> specification);
    T findOne(Specification<T> spec);
}
