package by.slivki.trainings.rest.dto;

import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
public class UpdateUserDto {
    @NotNull
    @Size(min = 4, max = 32, message = "form.username.size")
    private String password;

    @NotNull
    @Email
    @Size(min = 4, max = 32, message = "form.username.size")
    private String email;

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
