package by.slivki.trainings.rest.dto;

public class BaseUserDto {
    private String username;
    private String mail;
    private String role;
    private boolean isConfirmed;

    public String getUsername() {
        return username;
    }

    public String getMail() {
        return mail;
    }

    public String getRole() {
        return role;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

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
