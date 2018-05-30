package by.slivki.trainings.rest.dto;

import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
public class UpdateUserDto {

    @Size(min = 4, max = 20, message = "form.username.size")
    private String password;

    @Size(min = 6, max = 256, message = "form.email.size")
    private String email;

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
