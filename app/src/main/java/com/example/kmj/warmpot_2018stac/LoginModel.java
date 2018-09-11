package com.example.kmj.warmpot_2018stac;

public class LoginModel {
    private int status;
    private LoginData data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LoginData getData() {
        return data;
    }

    public void setData(LoginData data) {
        this.data = data;
    }

    public LoginModel(int status, LoginData data) {
        this.status = status;

        this.data = data;
    }
}
