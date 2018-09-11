package com.example.kmj.warmpot_2018stac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    TextView notres;
    EditText loginid;
    EditText password;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        password = findViewById(R.id.login_pw);
        notres = findViewById(R.id.login_t6);
        notres.setText(R.string.login_text);
        btn = findViewById(R.id.login_btn);
        loginid = findViewById(R.id.login_id);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetworkHelper.getInstance().GETtoken(loginid.getText().toString(), password.getText().toString()).enqueue(new Callback<LoginModel>() {
                    @Override
                    public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                        int status=response.body().getStatus();
                        if(status==200){
                            Toast.makeText(Login.this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show();
                            Log.e("login",response.body().getData().getToken());
                        }
                        else if(status==401){
                            Toast.makeText(Login.this, "아이디 또는 비밀번호를 다시 확인 하세요.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginModel> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });
        notres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,registerSelect.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
