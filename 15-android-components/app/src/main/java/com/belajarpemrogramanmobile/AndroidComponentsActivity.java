package com.belajarpemrogramanmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

public class AndroidComponentsActivity extends AppCompatActivity {

    // deklarasi komponen
    String resultText;
    EditText edtName;
    Button btnSubmit;
    TextView txtResult;
    CheckBox cbMancing, cbNgoding, cbRebahan;
    ToggleButton tgMakan;
    Switch swIsJomblo;
    RadioGroup rgKetoprak;
    RadioButton rbKetoprak;
    Spinner spJalan;
    TimePicker tpTidur;
    DatePicker dpTimeFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_components);

        // inisialisasi komponen
        edtName = findViewById(R.id.edt_name);
        btnSubmit = findViewById(R.id.btn_submit);
        txtResult = findViewById(R.id.txt_result);
        cbMancing = findViewById(R.id.cb_mancing);
        cbNgoding = findViewById(R.id.cb_ngoding);
        cbRebahan = findViewById(R.id.cb_rebahan);
        tgMakan = findViewById(R.id.tg_makan);
        swIsJomblo = findViewById(R.id.sw_is_jomblo);
        rgKetoprak = findViewById(R.id.rg_ketoprak);
        spJalan = findViewById(R.id.sp_jalan);
        tpTidur = findViewById(R.id.tp_tidur);
        dpTimeFavorite = findViewById(R.id.dp_time_favorite);

        // set time picker to 24 hours
        // tpTidur.setIs24HourView(true);

        // siapin pilihan
        String[] pilihanJalan = new String[]{"Suka banget", "Lumayan", "Gak punya duit"};
        // set pilihan
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, pilihanJalan);
        // set layout
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // set adapter ke spinner
        spJalan.setAdapter(spinnerAdapter);

        // event click button submit
        btnSubmit.setOnClickListener(view -> {
            this.getResult();
        });


    }

    private void getResult()
    {
        resultText = "";
        txtResult.setText(resultText);

        // get value dari edtName
        resultText += "Nama : " + edtName.getText().toString();

        // check isChecked dari checkbox jika checkbox nya aktif / dipilih
        resultText += "\nHobi : ";
        if( cbMancing.isChecked() ) { resultText += "Mancing, "; };
        if( cbNgoding.isChecked() ) { resultText += "Ngoding, "; };
        if( cbRebahan.isChecked() ) { resultText += "Rebahan"; };

        // get text dari toggle button
        resultText += "\nStatus makan : " + tgMakan.getText();

        // get isChecked dari switch
        resultText += "\nStatus Jomblo : ";
        if(swIsJomblo.isChecked()){ resultText += "Iya"; } else { resultText += "Tidak dong"; }

        // get radiobutton yang diseleksi dari radio group
        int checkedIdRadioGroup = rgKetoprak.getCheckedRadioButtonId();
        rbKetoprak = findViewById(checkedIdRadioGroup);
        resultText += "\nSuka Ketoprak : " + rbKetoprak.getText();

        // get text dari pilihan spinner
        resultText += "\nSuka Jalan jalan? : " + spJalan.getSelectedItem().toString();

        // get jam dan menit dari timepicker
        int jam = tpTidur.getCurrentHour();
        int menit = tpTidur.getCurrentMinute();
        resultText += "\nJam Tidur : " + jam + ":" + menit;

        // get date picker value
        int day = dpTimeFavorite.getDayOfMonth();
        int month = dpTimeFavorite.getMonth() + 1;
        int year = dpTimeFavorite.getYear();
        resultText += "\nTanggal Favorit : " + day + "-" + month + "-" + year;

        // tampilkan result nya
        txtResult.setText(resultText);
    }

}