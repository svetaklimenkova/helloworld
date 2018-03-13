package by.slivki.trainings.rest.dto;

import by.slivki.trainings.dao.jpa.Role;
import by.slivki.trainings.dao.jpa.RoleEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class SignUpUserDto {
    @NotNull
    @Size(min = 4, max = 32, message = "form.username.size")
    private String username;

    @NotNull
    @Size(min = 4, max = 32, message = "form.username.size")
    private String password;

    @NotNull
    @Email
    @Size(min = 4, max = 32, message = "form.username.size")
    private String email;

    private Role role = new Role(RoleEnum.USER);

    private boolean isConfirmed = true;
}
