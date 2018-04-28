package by.slivki.trainings.util;

import by.slivki.trainings.dao.jpa.Role;
import by.slivki.trainings.dao.jpa.RoleEnum;
import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.rest.dto.TrainerApplicationDto;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserHelper {

    private static final int PASSWORD_LENGTH = 8;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public UserDetails getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        UserDetails user = null;
        if (auth != null) {
            Object obj = auth.getPrincipal();

            if (obj instanceof UserDetails) {
                user = (UserDetails) obj;
            }
        }
        return user;
    }

    public User generateTrainer(TrainerApplicationDto application) {
        User user = new User();
        user.setUsername(application.getUsername());
        user.setEmail(application.getEmail());
        user.setConfirmed(false);
        user.setRole(new Role(RoleEnum.ROLE_TRAINER));

        String password = generatePassword();
        user.setPassword(encoder.encode(password));

        // change for release
        System.out.println("TRAINER: " + user.getUsername() + "; PASSWORD : " + password);

        return user;
    }

    public String generatePassword() {
        return RandomStringUtils.randomAlphabetic(PASSWORD_LENGTH);
    }

    public boolean isRoleAuthority(UserDetails userDetails, RoleEnum role) {
        return userDetails != null &&
                userDetails.getAuthorities().contains(new SimpleGrantedAuthority(role.name()));
    }
}
