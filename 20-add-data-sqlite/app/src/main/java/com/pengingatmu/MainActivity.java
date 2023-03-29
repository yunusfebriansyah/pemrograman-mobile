package com.pengingatmu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DBConfig config;
    SQLiteDatabase db;
    Cursor cursor;

    RecyclerView rcvData;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layout;

    ArrayList idList, titleList;

    ImageView linkAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        config = new DBConfig(this);

        linkAdd = findViewById(R.id.link_add);

        linkAdd.setOnClickListener( view -> {
            startActivity(new Intent( MainActivity.this, AddNoteActivity.class ));
        });

    }

    @Override
    protected void onResume() {
        showData();
        super.onResume();
    }

    private void showData() {
        // instansiasi array list
        idList = new ArrayList<>();
        titleList = new ArrayList<>();

        // set layout
        layout = new LinearLayoutManager(this);
        // set adapter
        adapter = new DataAdapter(this, idList, titleList);
        // instansiasi recyclerview
        rcvData = findViewById(R.id.rcv_data);

        // setlayout pada recyclerview
        rcvData.setLayoutManager(layout);
        rcvData.setHasFixedSize(true);

        // setadapter pada recyclerview
        rcvData.setAdapter(adapter);

        // set database
        db = config.getReadableDatabase();

        // set cursor berdasarkan query select
        cursor = db.rawQuery("SELECT * FROM notes", null);

        // pindahin cursor ke baris awal
        cursor.moveToFirst();

        // looping untuk isi array list
        for( int count = 0; count < cursor.getCount(); count++ ) {
            cursor.moveToPosition(count);
            // isi arraylist
            idList.add(cursor.getString(0));
            titleList.add(cursor.getString(1));
        }




    }

}