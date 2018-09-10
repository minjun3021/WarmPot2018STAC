package com.example.kmj.warmpot_2018stac;

public class LoginModel {
    private String token;
    private String auth_type;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAuth_type() {
        return auth_type;
    }

    public void setAuth_type(String auth_type) {
        this.auth_type = auth_type;
    }

    public LoginModel(String token, String auth_type) {

        this.token = token;
        this.auth_type = auth_type;
    }
}
