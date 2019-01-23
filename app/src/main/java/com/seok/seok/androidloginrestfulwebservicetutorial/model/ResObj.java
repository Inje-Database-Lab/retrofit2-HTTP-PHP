package com.seok.seok.androidloginrestfulwebservicetutorial.model;

import com.google.gson.annotations.SerializedName;

public class ResObj {
    @SerializedName("id")
    private String id;

    @SerializedName("pw")
    private String pw;

    @SerializedName("email")
    private String email;

    public ResObj(String id, String pw, String email) {
        this.id = id;
        this.pw = pw;
        this.email = email;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getpw() {
        return pw;
    }

    public void setpw(String pw) {
        this.pw = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
