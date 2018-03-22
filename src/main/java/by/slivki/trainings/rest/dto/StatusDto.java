package by.slivki.trainings.rest.dto;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Setter
public class StatusDto {
    @NotNull
    @Pattern(regexp = "IN_PROGRESS|ACCEPTED|REJECTED",
            message =("{make message}"))
    private String status;

    public String getStatus() {
        return status;
    }
}
