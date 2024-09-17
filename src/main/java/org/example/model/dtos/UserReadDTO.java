package org.example.model.dtos;

public class UserReadDTO {

    private String name;
    private String email;

    public UserReadDTO(){}

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
