package by.slivki.trainings.service.api;

import by.slivki.trainings.dao.jpa.User;

public interface UserService {
    /**
     * Creates new user.
     *
     * @param user user
     * */
    void createUser(User user);

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
     * Loads user by username. If user with this username does not exist
     * it returns null.
     *
     * @param username username
     *
     * @return user
     * */
    User loadUserByUsername(String username);
}
