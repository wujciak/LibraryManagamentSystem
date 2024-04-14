package edu.ib.technologiesieciowe.dto.UserDTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CreateUserDTO {
    private String name;
    private int age;

    @NotBlank(message = "Email is mandatory.")
    @Email
    private String email;

    public CreateUserDTO(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public CreateUserDTO() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
