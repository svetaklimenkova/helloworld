package by.slivki.trainings.rest.dto;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Setter
public class TrainerApplicationDto {
    @NotNull
    @Size(min = 4, max = 32, message = "form.username.size")
    private String username;

    @NotNull
    @Email
    @Size(min = 4, max = 32, message = "form.mail.size")
    private String email;

    @NotNull
    @Size(min = 10, max = 1000, message = "form.message.size")
    private String message;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }
}
