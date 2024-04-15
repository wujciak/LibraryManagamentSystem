package edu.ib.technologiesieciowe.dto.UserDTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class LoginDTO {
    @NotBlank(message = "Username is mandatory.")
    @Schema(name = "username", example = "UserNewWorlds")
    private String username;

    @NotBlank(message = "Username is mandatory.")
    @Schema(name = "password", example = "pass123.321")
    private String password;

    public LoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
