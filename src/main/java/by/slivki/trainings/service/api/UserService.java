package by.slivki.trainings.service.api;

import by.slivki.trainings.dao.jpa.User;

import java.util.List;

public interface UserService {
    /**
     * Creates new user.
     *
     * @param user user
     * */
    User createUser(User user);

    /**
     * Checks username. If user with this username exists
     * it returns false else true.
     *
     * @param username username
     *
     * @return true (if username is free) or false (username isn't free)
     * */
    boolean checkUsername(String username);

    /**
     * Checks mail. If user with this mail exists
     * it returns false else true.
     *
     * @param mail mail
     *
     * @return true (if mail is free) or false (mail isn't free)
     * */
    boolean checkMail(String mail);

    /**
     * Loads user by username. If user with this username does not exist
     * it returns null.
     *
     * @param username username
     *
     * @return user
     * */
    User loadUserByUsername(String username);

    /**
     * Loads user by mail. If user with this mail does not exist
     * it returns null.
     *
     * @param mail mail
     *
     * @return user
     * */
    User loadUserByMail(String mail);

    /**
     * Updates user.
     *
     * @param user user
     *
     * @return user
     * */
    User updateUser(User user);

    /**
     * Deletes user.
     *
     * @param id user id
     * */
    void deleteUser(int id);

    /**
     * Loads list of users.
     *
     * @return list of users
     * */
    List<User> loadAll();
}
