package com.belajarpemrogramanmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.belajarpemrogramanmobile.fragments.OneFragment;
import com.belajarpemrogramanmobile.fragments.TwoFragment;

public class FragmentActivity extends AppCompatActivity {

    // Deklarasi Komponen
    Button btnFg1, btnFg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        // Inisialisasi Komponen
        btnFg1 = findViewById(R.id.btn_fg1);
        btnFg2 = findViewById(R.id.btn_fg2);

        // Cara ngasih tampilan fragment kedalam frameLayout
        getSupportFragmentManager().beginTransaction().replace(R.id.frl_result, new OneFragment()).commit();

        btnFg1.setOnClickListener( view -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.frl_result, new OneFragment()).commit();
        });

        btnFg2.setOnClickListener( view -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.frl_result, new TwoFragment()).commit();
        });

    }
}