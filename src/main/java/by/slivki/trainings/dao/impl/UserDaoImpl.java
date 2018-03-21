package by.slivki.trainings.dao.impl;

import by.slivki.trainings.dao.api.UserDao;
import by.slivki.trainings.dao.impl.criterias.UserCriteria;
import by.slivki.trainings.dao.jpa.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserCriteria userCriteria;

    @Override
    public User findUserByUsername(String username) {
        try {
            return entityManager.createQuery(userCriteria.getUserByUsername(username)).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public User findUserByMail(String mail) {
        try {
            return entityManager.createQuery(userCriteria.getUserByMail(mail)).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public User createUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public List<User> loadUserList() {
        return entityManager.createQuery(userCriteria.getAll()).getResultList();
    }
}
