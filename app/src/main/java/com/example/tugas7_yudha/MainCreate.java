package com.example.tugas7_yudha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Ejudul, Egenre, Etahun;
    private String Sjudul, Sgenre, Stahun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Ejudul = (EditText) findViewById(R.id.create_judul);
        Egenre = (EditText) findViewById(R.id.create_genre);
        Etahun = (EditText) findViewById(R.id.create_tahun);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjudul = String.valueOf(Ejudul.getText());
                Sgenre = String.valueOf(Egenre.getText());
                Stahun = String.valueOf(Etahun.getText());
                if (Sjudul.equals("")){
                    Ejudul.requestFocus();
                    Toast.makeText(MainCreate.this, "Masukkan judul anime",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Sgenre.equals("")) {
                    Egenre.requestFocus();
                    Toast.makeText(MainCreate.this, "Masukkan genre anime",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Stahun.equals("")) {
                    Etahun.requestFocus();
                    Toast.makeText(MainCreate.this, "Masukkan tahun anime",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Ejudul.setText("");
                    Egenre.setText("");
                    Etahun.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateAnime(new Anime(null,Sjudul,Sgenre,Stahun));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
