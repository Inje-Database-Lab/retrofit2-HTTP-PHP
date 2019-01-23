package com.seok.seok.androidloginrestfulwebservicetutorial.model;

import com.google.gson.annotations.SerializedName;

public class TestObj {

    @SerializedName("email")
    private String email;

    public TestObj(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
