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
    Button btnIntent, btnLinearLayout, btnRelativeLayout, btnConstraintLayout, btnScrollView, btnFragment, btnAndroidComponents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inisialisasi komponen
        btnIntent = findViewById(R.id.btn_intent);
        btnLinearLayout = findViewById(R.id.btn_linear_layout);
        btnRelativeLayout = findViewById(R.id.btn_relative_layout);
        btnConstraintLayout = findViewById(R.id.btn_constraint_layout);
        btnScrollView = findViewById(R.id.btn_scroll_view);
        btnFragment = findViewById(R.id.btn_fragment);
        btnAndroidComponents = findViewById(R.id.btn_android_components);

        // event click btnIntent
        btnIntent.setOnClickListener( v ->{
            // explisit intent
            intent = new Intent(MainActivity.this, IntentActivity.class);
            intent.putExtra("message", "Silahkan belajar intent!!");
            startActivity(intent);
        });

        // event click btnLinearLayout
        btnLinearLayout.setOnClickListener( view -> {
            intent = new Intent(MainActivity.this, LinearLayoutActivity.class);
            startActivity(intent);
        });

        // event click btnRelativeLayout
        btnRelativeLayout.setOnClickListener( view -> {
            intent = new Intent(MainActivity.this, RelativeLayoutActivity.class);
            startActivity(intent);
        });

        // event click btnConstraingLayout
        btnConstraintLayout.setOnClickListener( view -> {
            intent = new Intent(MainActivity.this, ConstraintLayoutActivity.class);
            startActivity(intent);
        });

        // event click btnScrollView
        btnScrollView.setOnClickListener( view -> {
           intent = new Intent(MainActivity.this, ScrollViewActivity.class);
           startActivity(intent);
        });

        btnFragment.setOnClickListener( view -> {
           intent = new Intent(MainActivity.this, FragmentActivity.class);
           startActivity(intent);
        });

        btnAndroidComponents.setOnClickListener( view -> {
           intent = new Intent(MainActivity.this, AndroidComponentsActivity.class);
           startActivity(intent);
        });

    }
}