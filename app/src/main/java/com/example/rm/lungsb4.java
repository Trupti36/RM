package com.example.rm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class lungsb4 extends AppCompatActivity {
Button next;
    RadioGroup gallery;
    RadioButton radioButton;
    RadioButton yes,no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lungsb4);

        next=findViewById(R.id.click2);
        gallery = (RadioGroup) findViewById(R.id.radio_btn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = gallery.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                String radio = radioButton.getText().toString();
                Intent intent =new Intent(lungsb4.this, com.example.rm.lungs1.class);
                intent.putExtra("type", radio);
                startActivity(intent);
            }
        });
    }
}