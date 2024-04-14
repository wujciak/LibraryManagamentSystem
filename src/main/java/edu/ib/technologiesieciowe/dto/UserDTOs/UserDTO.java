package edu.ib.technologiesieciowe.dto.UserDTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDTO {
    private int userId;
    private String name;
    private int age;
    @NotBlank(message = "Email is mandatory.")
    @Email
    private String email;

    public UserDTO(int userId, String name, int age, String email) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public UserDTO() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
