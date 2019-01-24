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
import com.seok.seok.androidloginrestfulwebservicetutorial.model.TestObj;
import com.seok.seok.androidloginrestfulwebservicetutorial.remote.ApiUtils;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main3Activity extends AppCompatActivity {
    EditText editId;
    EditText editPw;
    Button button;
    TextView goaltext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        editId = findViewById(R.id.editid);
        button = findViewById(R.id.button);
        goaltext = findViewById(R.id.goaltext);
        editPw = findViewById(R.id.editpw);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("textt = ", editId.getText().toString());
                ApiUtils.loginUser().testLogin(editId.getText().toString(), editPw.getText().toString()).enqueue(new Callback<List<TestLogin>>() {
                    @Override
                    public void onResponse(Call<List<TestLogin>> call, Response<List<TestLogin>> response) {
                        if (response.isSuccessful()) {
                            List<TestLogin> list = response.body();
                            try {
                                goaltext.setText("로그인 성공\n" + "ID : " + list.get(0).getUserId() + "\nPW : "+ list.get(0).getUserPw() + "\nEmail : " + list.get(0).getUserEmail());
                            }catch (Exception e){
                                Toast.makeText(Main3Activity.this, "--로그인 실패--\n회원 가입창으로 넘어갑니다.", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Main3Activity.this, Main4Activity.class));
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
