package by.slivki.trainings.dao.jpa;

import by.slivki.trainings.dao.jpa.Role;
import by.slivki.trainings.dao.jpa.User;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public class User_ {
    public static volatile SingularAttribute<User, Integer> userId;
    public static volatile SingularAttribute<User, String> username;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, Role> role;
    public static volatile SingularAttribute<User, Boolean> isConfirmed;
}
