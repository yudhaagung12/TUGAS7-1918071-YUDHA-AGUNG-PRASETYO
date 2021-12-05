package com.example.tugas7_yudha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Anime> ListAnime = new ArrayList<Anime>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListAnime);
        mListView = (ListView) findViewById(R.id.list_anime);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListAnime.clear();
        List<Anime> contacts = db.ReadAnime();
        for (Anime cn : contacts) {
            Anime judulModel = new Anime();
            judulModel.set_id(cn.get_id());
            judulModel.set_judul(cn.get_judul());
            judulModel.set_genre(cn.get_genre());
            judulModel.set_tahun(cn.get_tahun());
            ListAnime.add(judulModel);
            if ((ListAnime.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Anime obj_itemDetails = (Anime) o;
        String Sid = obj_itemDetails.get_id();
        String Sjudul = obj_itemDetails.get_judul();
        String Sgenre = obj_itemDetails.get_genre();
        String Stahun = obj_itemDetails.get_tahun();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Ijudul", Sjudul);
        goUpdel.putExtra("Igenre", Sgenre);
        goUpdel.putExtra("Itahun", Stahun);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListAnime.clear();
        mListView.setAdapter(adapter_off);
        List<Anime> contacts = db.ReadAnime();
        for (Anime cn : contacts) {
            Anime judulModel = new Anime();
            judulModel.set_id(cn.get_id());
            judulModel.set_judul(cn.get_judul());
            judulModel.set_genre(cn.get_genre());
            judulModel.set_tahun(cn.get_tahun());
            ListAnime.add(judulModel);
            if ((ListAnime.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}

