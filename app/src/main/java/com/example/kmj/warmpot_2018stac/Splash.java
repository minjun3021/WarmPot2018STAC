package com.example.kmj.warmpot_2018stac;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Splash extends AppCompatActivity {
    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SharedPreferences pref = getSharedPreferences("pref",MODE_PRIVATE);
        token=pref.getString("token","def");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(token!="def"){

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
