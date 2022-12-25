package com.belajarpemrogramanmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Deklarasi Komponen
    Intent intent;
    Button btnIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hard_code_layout);

        // inisialisasi komponen
        btnIntent = findViewById(R.id.btn_intent);

        // event click btnIntent
        btnIntent.setOnClickListener( v ->{
            // explisit intent
            intent = new Intent(MainActivity.this, IntentActivity.class);
            intent.putExtra("message", "Silahkan belajar intent!!");
            startActivity(intent);
        });

    }
}