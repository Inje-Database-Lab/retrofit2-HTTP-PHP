package com.seok.seok.androidloginrestfulwebservicetutorial.remote;

import com.seok.seok.androidloginrestfulwebservicetutorial.model.ResObj;
import com.seok.seok.androidloginrestfulwebservicetutorial.model.TestLogin;
import com.seok.seok.androidloginrestfulwebservicetutorial.model.TestObj;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {
    @GET("test_user.php")
    Call<List<ResObj>> login();

    @GET("test_user_email.php")
    Call<List<TestObj>>getEmail();

    @POST("test_login.php")
    Call<List<TestLogin>> testLogin(@Query("id") String id,
                                    @Query("pw") String pw);

    @POST("test_register.php")
    Call<List<TestLogin>> testRegister(@Query("id") String id,
                                    @Query("pw") String pw,
                                    @Query("email") String email);
}
