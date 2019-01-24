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

import com.seok.seok.androidloginrestfulwebservicetutorial.model.TestLogin;
import com.seok.seok.androidloginrestfulwebservicetutorial.remote.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main4Activity extends AppCompatActivity {

    TextView textId, textPw, textEmail;
    EditText editTextId, editTextPw, editTextEmail;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        textId = findViewById(R.id.textView);
        textPw = findViewById(R.id.textView2);
        textEmail = findViewById(R.id.textView3);
        editTextId = findViewById(R.id.editText);
        editTextPw = findViewById(R.id.editText2);
        editTextEmail = findViewById(R.id.editText3);
        button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiUtils.loginUser().testRegister(editTextId.getText().toString(), editTextPw.getText().toString(), editTextEmail.getText().toString()).enqueue(new Callback<List<TestLogin>>() {
                    @Override
                    public void onResponse(Call<List<TestLogin>> call, Response<List<TestLogin>> response) {
                        if (response.isSuccessful()) {
                            List<TestLogin> list = response.body();
                            try {
                                Log.d("test4 E : ", list.get(0).getUserConfirm()+"");
                                if(list.get(0).getUserConfirm())
                                    Toast.makeText(Main4Activity.this, "회원가입 성공\n" + "ID : " + list.get(0).getUserId() + "\nPW : " + list.get(0).getUserPw() + "\nEmail : " + list.get(0).getUserEmail(), Toast.LENGTH_SHORT).show();
                                else
                                    Toast.makeText(Main4Activity.this, "DB에 값이 존재함\n 다시 구현해야함\nDB확인 요망", Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                Toast.makeText(Main4Activity.this, "--아이디 존재--\n다른 아이디 입력 요망", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<TestLogin>> call, Throwable t) {
                        Log.d("test2 E : ", t.getMessage());
                    }
                });
            }
        });
    }
}
