package edu.ib.technologiesieciowe.dto.UserDTOs;

import edu.ib.technologiesieciowe.enumType.UserRole;

public class RegisterDTO {
    private String username;
    private String password;
    private UserRole role;
    private String email;

    public RegisterDTO(String username, String password, UserRole role, String email) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
