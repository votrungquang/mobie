package com.example.demolapo1; 

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AlphabetIndexer;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtten, edtmssv, edttuoi;
    Button btnluu ;

    RadioGroup idgroud;

    CheckBox chkdabong, chkchoigame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ánh xạ id
        edtten = findViewById(R.id.edtten);
        edtmssv = findViewById(R.id.edtmssv);
        edttuoi = findViewById(R.id.edttuoi);
        btnluu = findViewById(R.id.btnluu);
        idgroud = findViewById(R.id.idgroud);
        chkdabong = findViewById(R.id.chkdabong);
        chkchoigame = findViewById(R.id.chkchoigame);
        // xử lý click vào button
        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten =edtten.getText().toString();
                String mssv = edtmssv.getText().toString();
                String tuoi = edttuoi.getText().toString();
                int idselect = idgroud.getCheckedRadioButtonId();
                RadioButton radselect = findViewById(idselect);
                String gioitinh = radselect.getText().toString();
                // lấy thông tin sở thích
                String Sothich = "";
                if (chkdabong.isChecked())
                    Sothich += chkdabong.getText().toString()+"-";
                if (chkchoigame.isChecked())
                    Sothich += chkchoigame.getText().toString();
                String luu = ("Tôi tên là" + ten+ "\n" + "MSSV"+ mssv+ "\n" +"Tuổi" +tuoi+ "\n"+ "Giới Tính" +gioitinh+ "\n"+ "S" +Sothich+ "\n");

                AlertDialog.Builder mydialog = new AlertDialog.Builder(MainActivity.this);
                mydialog.setTitle("Thông tin sau khi lưu");
                mydialog.setMessage(luu);
                mydialog.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                mydialog.create().show();

            }
        });




    }
}




