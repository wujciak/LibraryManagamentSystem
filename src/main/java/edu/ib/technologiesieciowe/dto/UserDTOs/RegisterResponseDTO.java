package edu.ib.technologiesieciowe.dto.UserDTOs;

import edu.ib.technologiesieciowe.enumType.UserRole;

public class RegisterResponseDTO {
    private int userId;
    private String username;
    private UserRole role;

    public RegisterResponseDTO(int userId, String username, UserRole role) {
        this.userId = userId;
        this.username = username;
        this.role = role;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
