package com.example.kmj.warmpot_2018stac;

import android.net.Network;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity {
    RadioButton b0, b1;
    RadioGroup rg;
    String gender;
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
                Toast.makeText(registerActivity.this, name.getText()+gender+birth.getText()+res_id.getText()+pass.getText(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
