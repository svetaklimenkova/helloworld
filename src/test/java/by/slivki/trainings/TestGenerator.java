package by.slivki.trainings;

import by.slivki.trainings.dao.jpa.Application;
import by.slivki.trainings.dao.jpa.ApplicationType;
import by.slivki.trainings.dao.jpa.ApplicationTypeEnum;
import by.slivki.trainings.dao.jpa.Role;
import by.slivki.trainings.dao.jpa.RoleEnum;
import by.slivki.trainings.dao.jpa.Status;
import by.slivki.trainings.dao.jpa.StatusEnum;
import by.slivki.trainings.dao.jpa.User;

public class TestGenerator {
    public static User createUser() {
        User user = new User();
        user.setUserId(1);
        user.setUsername("test user");
        user.setRole(new Role(RoleEnum.ROLE_USER));
        user.setEmail("test@mail.ru");
        user.setConfirmed(true);
        return user;
    }

    public static Application createApplication() {
        return createApplication(1);
    }

    public static Application createApplication(int id) {
        Application application = new Application();
        application.setApplicationId(id);
        application.setDescription("test application");
        application.setStatus(new Status(StatusEnum.IN_PROGRESS));
        application.setUser(createUser());
        application.setApplicationType(new ApplicationType(ApplicationTypeEnum.PASSWORD));
        return application;
    }
}
