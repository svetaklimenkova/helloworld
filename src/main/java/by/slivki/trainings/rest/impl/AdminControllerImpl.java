package by.slivki.trainings.rest.impl;

import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.rest.dto.SignUpUserDto;
import by.slivki.trainings.rest.dto.UserListItemDto;
import by.slivki.trainings.rest.mapper.UserMapper;
import by.slivki.trainings.service.api.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class AdminControllerImpl {
    @Autowired
    private UserService userService;

    /**
     * Processes GET request to '/users'.
     * Returns list of users.
     *
     * @return list of users
     * */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<?> getUsers() {
        List<User> users = userService.loadUserList();
        List<UserListItemDto> userListItemDtos = new UserMapper().toUserListItemDtos(users);
        return ResponseEntity.ok(userListItemDtos);
    }
}