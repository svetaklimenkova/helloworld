package by.slivki.trainings.dao.impl;

import by.slivki.trainings.dao.api.BaseDao;
import by.slivki.trainings.dao.api.UserDao;
import by.slivki.trainings.dao.impl.criterias.UserCriteria;
import by.slivki.trainings.dao.jpa.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl extends BaseDao<User> implements UserDao {

    @Autowired
    private UserCriteria userCriteria;

    @Override
    public User getById(int id) {
        return super.get(userCriteria.getById(id));
    }

    @Override
    public User getByUsername(String username) {
        return super.get(userCriteria.getByUsername(username));
    }

    @Override
    public User getByMail(String mail) {
        return super.get(userCriteria.getByMail(mail));
    }

    @Override
    public List<User> getAll() {
        return super.getAll(userCriteria.get());
    }
}
