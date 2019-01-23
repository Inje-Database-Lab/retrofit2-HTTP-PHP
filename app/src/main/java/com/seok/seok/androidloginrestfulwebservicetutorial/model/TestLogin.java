package com.seok.seok.androidloginrestfulwebservicetutorial.model;

import com.google.gson.annotations.SerializedName;

public class TestLogin {

    @SerializedName("email")
    private String userEmail;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public TestLogin(String userEmail) {
        this.userEmail = userEmail;
    }


}
