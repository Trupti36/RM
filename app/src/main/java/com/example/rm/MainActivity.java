package com.example.rm;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static  int nextscreen=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){
                Intent intent= new Intent(MainActivity.this, com.example.rm.Login.class);
                startActivity(intent);
                finish();
            }

        },nextscreen);
    }
}