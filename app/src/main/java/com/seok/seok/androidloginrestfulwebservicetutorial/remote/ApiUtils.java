package com.seok.seok.androidloginrestfulwebservicetutorial.remote;

public class ApiUtils {
    public static final String BASE_URL = "http://203.241.228.121/";
    public static UserService getUserService(){
        return RetrofitClientC.getClient(BASE_URL).create(UserService.class);
    }
    public static UserService getUserEmail(){
        return RetrofitClientC.getClient(BASE_URL).create(UserService.class);
    }
    public static UserService loginUser(){
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }
}
