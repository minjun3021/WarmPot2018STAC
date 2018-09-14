package com.example.kmj.warmpot_2018stac.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.kmj.warmpot_2018stac.R;

public class Splash extends AppCompatActivity {
    String token;
    int login;
    int kakao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SharedPreferences pref = getSharedPreferences("pref",MODE_PRIVATE);
        token=pref.getString("token","def");
        login=pref.getInt("login",0);
        kakao=pref.getInt("kakao",0);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(token!="def" && login==1){
                    Toast.makeText(Splash.this, "자동로그인 되었습니다.git ", Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(Splash.this,connect.class);
                    startActivity(intent);
                    finish();
                }
                else if(kakao==1){
                    Toast.makeText(Splash.this, "카카오톡 자동로그인 되었습니다.", Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(Splash.this,connect.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Intent intent = new Intent(Splash.this, registerSelect.class);

                    startActivity(intent);
                    finish();
                }


            }
        }, 1000);
    }
}
