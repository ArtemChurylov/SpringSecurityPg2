package com.example.SpringSecurityDataBase.auth;

import com.example.SpringSecurityDataBase.validation.ConfirmPassword;
import com.example.SpringSecurityDataBase.validation.UniqueUserName;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@UniqueUserName
@ConfirmPassword
public class CrmUser {

    @Size(min = 3, max = 15)
    @NotEmpty(message = "Can`t be empty")
    private String username;

    @Size(min = 6)
    @NotEmpty(message = "Can`t be empty")
    private String password;

    @NotEmpty(message = "Can`t be empty")
    @Size(min = 6)
    private String confirmPassword;

    public CrmUser() {
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
