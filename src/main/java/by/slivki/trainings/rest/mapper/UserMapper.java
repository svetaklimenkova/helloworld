package by.slivki.trainings.rest.mapper;

import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.rest.dto.TrainerCreationApplicationDto;
import by.slivki.trainings.rest.dto.UserListItemDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public List<UserListItemDto> toUserListItemDtos(List<User> users) {
        List<UserListItemDto> userListItemDtos = new ArrayList<>();
        for (User user : users) {
            userListItemDtos.add(toUserListItemDto(user));
        }
        return userListItemDtos;
    }

    private UserListItemDto toUserListItemDto(User user) {
        UserListItemDto userListItemDto = new UserListItemDto();
        userListItemDto.setUsername(user.getUsername());
        userListItemDto.setMail(user.getEmail());
        userListItemDto.setRole(user.getRole().getRoleName());
        return userListItemDto;
    }

    public User from(TrainerCreationApplicationDto application) {
        User user = new User();
        user.setUsername(application.getUsername());
        user.setEmail(application.getEmail());
        return user;
    }
}
