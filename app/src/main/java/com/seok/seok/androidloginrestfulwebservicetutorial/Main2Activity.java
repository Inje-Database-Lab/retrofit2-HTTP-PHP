package com.seok.seok.androidloginrestfulwebservicetutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.seok.seok.androidloginrestfulwebservicetutorial.model.TestObj;
import com.seok.seok.androidloginrestfulwebservicetutorial.remote.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {

    TextView txtUsername;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtUsername = findViewById(R.id.txtUsername);
        button = findViewById(R.id.button2);

        ApiUtils.getUserEmail().getEmail().enqueue(new Callback<List<TestObj>>() {
            @Override
            public void onResponse(Call<List<TestObj>> call, Response<List<TestObj>> response) {
                if(response.isSuccessful()){
                    Log.d("test1 E : " , "성공");
                    List<TestObj> list = response.body();
                    txtUsername.setText("User Eamil : " + list.get(0).getEmail());
                }
            }

            @Override
            public void onFailure(Call<List<TestObj>> call, Throwable t) {
                Log.d("test1 E : " , t.getMessage());
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, Main3Activity.class));
                finish();
            }
        });
    }
}
