package by.slivki.trainings.rest;

import by.slivki.trainings.dao.jpa.Role;
import by.slivki.trainings.dao.jpa.RoleEnum;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String home1() {
        return getHomePage();
    }

    @GetMapping("/home")
    public String getHomePage() {
        UserDetails userDetails = getCurrentUser();

        GrantedAuthority admin = new SimpleGrantedAuthority(new Role(RoleEnum.ADMIN).getRoleName());
        GrantedAuthority trainer = new SimpleGrantedAuthority(new Role(RoleEnum.TRAINER).getRoleName());
        GrantedAuthority user = new SimpleGrantedAuthority(new Role(RoleEnum.USER).getRoleName());

        String page = "/home";
        if (userDetails != null && userDetails.getAuthorities().contains(admin)) {
            page = "/admin/home";
        } else if (userDetails != null && userDetails.getAuthorities().contains(trainer)) {
            page = "/trainer/home";
        } else if (userDetails != null && userDetails.getAuthorities().contains(user)) {
            page = "/user/home";
        }

        return page;
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "/signUp";
    }

    @GetMapping("/application/password")
    public String applicationPassword() {
        return "/applications/password";
    }

    @GetMapping("/application/trainer")
    public String applicationTrainer() {
        return "/applications/trainer";
    }

    private UserDetails getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        UserDetails userDetails = null;
        if (null != auth) {
            Object obj = auth.getPrincipal();

            if (obj instanceof UserDetails) {
                userDetails = (UserDetails) obj;
            }
        }
        return userDetails;
    }
}
