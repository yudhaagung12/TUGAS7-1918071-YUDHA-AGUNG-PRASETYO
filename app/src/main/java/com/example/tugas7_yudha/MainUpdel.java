package com.example.tugas7_yudha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Sjudul, Sgenre, Stahun;
    private EditText Ejudul, Egenre, Etahun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Sjudul = i.getStringExtra("Ijudul");
        Sgenre = i.getStringExtra("Igenre");
        Stahun = i.getStringExtra("Itahun");
        Ejudul = (EditText) findViewById(R.id.updel_judul);
        Egenre = (EditText) findViewById(R.id.updel_genre);
        Etahun = (EditText) findViewById(R.id.updel_tahun);
        Ejudul.setText(Sjudul);
        Egenre.setText(Sgenre);
        Etahun.setText(Stahun);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjudul = String.valueOf(Ejudul.getText());
                Sgenre = String.valueOf(Egenre.getText());
                Stahun = String.valueOf(Etahun.getText());
                if (Sjudul.equals("")){
                    Ejudul.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi judul", Toast.LENGTH_SHORT).show();
                } else if (Sgenre.equals("")){
                    Egenre.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi genre", Toast.LENGTH_SHORT).show();
                } else if (Stahun.equals("")){
                    Etahun.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi tahun", Toast.LENGTH_SHORT).show();
                } else {db.UpdateAnime(new Anime(Sid, Sjudul, Sgenre, Stahun));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteAnime (new Anime(Sid, Sjudul, Sgenre, Stahun));
                Toast.makeText(MainUpdel.this, "Data telah dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

