package by.slivki.trainings.dao.impl;

import by.slivki.trainings.dao.api.UserDao;
import by.slivki.trainings.dao.impl.criterias.UserCriteria;
import by.slivki.trainings.dao.jpa.User;
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

    @Override
    public User findUserByUsername(String username) {
        try {
            UserCriteria userCriteria = new UserCriteria(entityManager.getCriteriaBuilder());
            return entityManager.createQuery(userCriteria.getUserByUsername(username)).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public User findUserByMail(String mail) {
        try {
            return (User) entityManager.createQuery("FROM User WHERE email=:email")
                    .setParameter("email", mail).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public List<User> loadUserList() {
        UserCriteria userCriteria = new UserCriteria(entityManager.getCriteriaBuilder());
        return entityManager.createQuery(userCriteria.getAll()).getResultList();
    }
}
