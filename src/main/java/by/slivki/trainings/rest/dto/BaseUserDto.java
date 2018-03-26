package by.slivki.trainings.rest.dto;

import lombok.Getter;

@Getter
public class BaseUserDto {
    private String username;
    private String mail;
    private String role;
    private boolean isConfirmed;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }
}
