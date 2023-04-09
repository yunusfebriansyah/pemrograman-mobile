package com.pengingatmu;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    Button btnSubmit;
    EditText edtTitle, edtDescription;

    DBConfig config;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        config = new DBConfig(this);

        edtTitle = findViewById(R.id.edt_title);
        edtDescription = findViewById(R.id.edt_description);
        btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener( view -> addNote());

    }

    private void addNote()
    {
        // tarik judul sama deskripsinya
        String title = edtTitle.getText().toString();
        String description = edtDescription.getText().toString();

        // validasi data harus diisi semua
        if( title.isEmpty() || description.isEmpty() ){
            Toast.makeText(this, "Semua data harus diisi!", Toast.LENGTH_SHORT).show();
        }else{
            // menambahkan data ke tb_note SQLite
            db = config.getReadableDatabase();
            db.execSQL("INSERT INTO notes (title, description) VALUES ('" + title + "', '" + description + "')");
            Toast.makeText(this, "Catatan berhasil dibuat.", Toast.LENGTH_SHORT).show();
            finish();
        }


    }

}