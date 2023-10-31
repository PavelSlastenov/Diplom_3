package models;

import lombok.Data;

@Data
public class LoginUser {
    private final String email;
    private final String password;
    private final String name;
}
