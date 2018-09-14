package com.example.kmj.warmpot_2018stac.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.kmj.warmpot_2018stac.retrofit.NetworkHelper;
import com.example.kmj.warmpot_2018stac.R;
import com.example.kmj.warmpot_2018stac.data.RegisterModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class registerActivity extends AppCompatActivity {
    RadioButton b0, b1;
    RadioGroup rg;
    String gender, token;
    Button res;
    EditText name, birth, res_id, pass, passcheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        b0 = findViewById(R.id.radio0);
        rg = findViewById(R.id.radiogroup);
        b1 = findViewById(R.id.radio1);
        res = findViewById(R.id.register);
        name = findViewById(R.id.rg_input_name);
        birth = findViewById(R.id.rg_input_birth);
        res_id = findViewById(R.id.rg_input_id);
        pass = findViewById(R.id.rg_input_pw);
        passcheck = findViewById(R.id.rg_input_pwcheck);
        gender = "남자";
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                if (i == R.id.radio0) {
                    gender = "남자";
                } else if (i == R.id.radio1) {
                    gender = "여자";
                }
            }
        });
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetworkHelper.getInstance().Register(res_id.getText().toString(), pass.getText().toString(), name.getText().toString(), gender, "ward").enqueue(new Callback<RegisterModel>() {
                    @Override
                    public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
                        int status = response.body().getStatus();
                        if (status == 200) {
                            Toast.makeText(getApplicationContext(), "회원가입이 정상적으로 완료되었습니다.", Toast.LENGTH_SHORT).show();
                            Log.e("qwer", response.body().getData().getToken());
                            token = response.body().getData().getToken();
                            savePreferences();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent intent = new Intent(registerActivity.this, Login.class);
                                    startActivity(intent);
                                    finish();

                                }
                            }, 700);

                        } else if (status == 401) {
                            Toast.makeText(getApplicationContext(), "이미존재하는 아이디입니다.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterModel> call, Throwable t) {

                    }
                });
            }
        });


    }

    private void savePreferences() {
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("id", res_id.getText().toString());
        editor.putString("password", pass.getText().toString());
        editor.putString("name", name.getText().toString());
        editor.putString("gender", gender);
        editor.putInt("login",0);
        editor.putString("token", token);
        editor.commit();
    }
}
