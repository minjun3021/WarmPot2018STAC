package com.example.kmj.warmpot_2018stac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class registerSelect extends AppCompatActivity {
    Button resbutton;
    Button reskakao;
    TextView already;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_select);
        resbutton=findViewById(R.id.rs_btn);
        reskakao=findViewById(R.id.rs_kakaobtn);
        already=findViewById(R.id.rs_already);
        already.setText(R.string.register_select_text);
        resbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(registerSelect.this,registerActivity.class);
                startActivity(intent);
            }
        });
        reskakao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(registerSelect.this,Login.class);
                startActivity(intent);
            }
        });
    }
}
