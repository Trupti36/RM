package com.example.rm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class lungs_ui_ux extends AppCompatActivity {
Button next;
    RadioGroup gallery;
    RadioButton radioButton;
    RadioButton yes,no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lungs_ui_ux);
        next=findViewById(R.id.click);
        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);
        gallery = (RadioGroup) findViewById(R.id.radio_btn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call();
            }
        });
    }

    private void call() {
        int selectedId = gallery.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        String radio = radioButton.getText().toString();
        if(radio.equals(null)){
            Toast.makeText(this, "Please select a value", Toast.LENGTH_SHORT).show();
        }
        else if(radio.equals("Yes")){
            Intent intent =new Intent(lungs_ui_ux.this, com.example.rm.Pneumonaactibity.class);
            startActivity(intent);
        }
        else{
            Intent intent =new Intent(lungs_ui_ux.this,lungsb4.class);
            startActivity(intent);
        }
    }
}