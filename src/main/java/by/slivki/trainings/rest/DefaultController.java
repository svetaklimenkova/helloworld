package by.slivki.trainings.rest;

import by.slivki.trainings.dao.jpa.Role;
import by.slivki.trainings.dao.jpa.RoleEnum;
import by.slivki.trainings.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home1() {
        return "/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/userAccountInfo")
    public String userAccountInfo() {
        UserDetails userDetails = getCurrentUser();

        GrantedAuthority admin = new SimpleGrantedAuthority(new Role(RoleEnum.ADMIN).getRoleName());
        GrantedAuthority trainer = new SimpleGrantedAuthority(new Role(RoleEnum.TRAINER).getRoleName());
        GrantedAuthority user = new SimpleGrantedAuthority(new Role(RoleEnum.USER).getRoleName());

        String page = "/error/403";
        if (userDetails != null && userDetails.getAuthorities().contains(admin)) {
            page = "/admin";
        } else if (userDetails != null && userDetails.getAuthorities().contains(trainer)) {
            page = "/trainer";
        } else if (userDetails != null && userDetails.getAuthorities().contains(user)) {
            page = "/user";
        }

        return page;
    }

//    @GetMapping("/admin")
//    public String admin() {
//        return "/admin";
//    }
//
//    @GetMapping("/user")
//    public String user() {
//        return "/user";
//    }
//
//    @GetMapping("/about")
//    public String about() {
//        return "/about";
//    }
//
//    @GetMapping("/login")
//    public String login() {
//        return "/login";
//    }
//
//    @GetMapping("/403")
//    public String error403() {
//        return "/error/403";
//    }

    @GetMapping("/signUp")
    public String signUp() {
        return "/signUp";
    }

    private UserDetails getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (null == auth) {
            return null;
        }

        Object obj = auth.getPrincipal();

        if (obj instanceof UserDetails) {
            return (UserDetails) obj;
        } else {
            return null;
        }
    }

}
