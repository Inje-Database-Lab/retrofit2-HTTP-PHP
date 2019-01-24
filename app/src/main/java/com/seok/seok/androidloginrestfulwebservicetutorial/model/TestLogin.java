package com.seok.seok.androidloginrestfulwebservicetutorial.model;

import com.google.gson.annotations.SerializedName;

public class TestLogin {

    @SerializedName("email")
    private String userEmail;

    @SerializedName("id")
    private String userId;

    @SerializedName("pw")
    private String userPw;

    @SerializedName("confirm")
    private boolean userConfirm;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public TestLogin(String userEmail) {
        this.userEmail = userEmail;
    }

    public boolean getUserConfirm() {
        return userConfirm;
    }

    public void setUserConfirm(boolean userConfirm) {
        this.userConfirm = userConfirm;
    }
}
