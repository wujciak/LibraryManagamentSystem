package edu.ib.technologiesieciowe.dto.UserDTOs;

public class CreateUserDTO {
    private String name;
    private String email;

    public CreateUserDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public CreateUserDTO() {
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
