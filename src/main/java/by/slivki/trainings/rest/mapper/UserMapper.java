package by.slivki.trainings.rest.mapper;

import by.slivki.trainings.dao.jpa.User;
import by.slivki.trainings.rest.dto.BaseUserDto;
import by.slivki.trainings.rest.dto.SignUpUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    @Autowired
    private BCryptPasswordEncoder encoder;

    public List<BaseUserDto> toBaseUserDtos(List<User> users) {
        List<BaseUserDto> baseUserDtos = new ArrayList<>();
        if (users != null) {
            for (User user : users) {
                baseUserDtos.add(toUserListItemDto(user));
            }
        }
        return baseUserDtos;
    }

    private BaseUserDto toUserListItemDto(User user) {
        BaseUserDto baseUserDto = new BaseUserDto();
        baseUserDto.setUsername(user.getUsername());
        baseUserDto.setMail(user.getEmail());
        baseUserDto.setRole(user.getRole().getRoleName());
        return baseUserDto;
    }

    public User from(SignUpUserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(encoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());
        user.setConfirmed(userDto.isConfirmed());
        return user;
    }
}
