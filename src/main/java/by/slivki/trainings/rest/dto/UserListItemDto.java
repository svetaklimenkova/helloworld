package by.slivki.trainings.rest.dto;

import lombok.Getter;

@Getter
public class UserListItemDto {
    private String username;
    private String mail;
    private String role;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
