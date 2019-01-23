package com.seok.seok.androidloginrestfulwebservicetutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.seok.seok.androidloginrestfulwebservicetutorial.model.ResObj;
import com.seok.seok.androidloginrestfulwebservicetutorial.remote.ApiUtils;
import com.seok.seok.androidloginrestfulwebservicetutorial.remote.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView userId;
    TextView userPw;
    Button btnLogin;

    UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        userId = findViewById(R.id.user_id);
        userPw = findViewById(R.id.user_pw);
        userService = ApiUtils.getUserService();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                finish();
            }
        });
        ApiUtils.getUserService().login().enqueue(new Callback<List<ResObj>>() {
            @Override
            public void onResponse(Call<List<ResObj>> call, Response<List<ResObj>> response) {
                Log.d("test E : " , "성공");
                if(response.isSuccessful()){
                    List<ResObj> list = response.body();
                    userId.setText("User id : " + list.get(0).getid() + " User pw : " +  list.get(0).getpw() + " User email : " + list.get(0).getEmail());
                    userPw.setText("User id : " + list.get(1).getid() + " User pw : " +  list.get(1).getpw() + " User email : " + list.get(1).getEmail());
                }
            }

            @Override
            public void onFailure(Call<List<ResObj>> call, Throwable t) {
                Log.d("test E : " , t.getMessage());
            }
        });
    }
}
