package edu.ib.technologiesieciowe.dto.UserDTOs;

import edu.ib.technologiesieciowe.enumType.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RegisterDTO {
    @NotBlank(message = "Username is mandatory.")
    @Schema(name = "username", example = "UserNewWorlds")
    private String username;

    @NotBlank(message = "Password is mandatory.")
    @Schema(name = "password", example = "pass123.321")
    private String password;

    @NotNull
    @Schema(name = "role", example = "ROLE_READER")
    private UserRole role;

    @NotBlank(message = "Email is mandatory.")
    @Email
    @Schema(name = "email", example = "newEmail@domain.com")
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
