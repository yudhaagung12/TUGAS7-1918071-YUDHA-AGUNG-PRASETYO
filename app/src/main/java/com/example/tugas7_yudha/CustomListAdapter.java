package com.example.tugas7_yudha;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Anime> Anime;
    public CustomListAdapter(Activity activity, List<Anime>
            Anime) {
        this.activity = activity;
        this.Anime = Anime;
    }
    @Override
    public int getCount() {
        return Anime.size();
    }
    @Override
    public Object getItem(int location) {
        return Anime.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView judul = (TextView)
                convertView.findViewById(R.id.text_judul);
        TextView genre = (TextView)
                convertView.findViewById(R.id.text_genre);
        TextView tahun = (TextView)
                convertView.findViewById(R.id.text_tahun);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Anime m = Anime.get(position);
        judul.setText("Judul : "+ m.get_judul());
        genre.setText("Genre : "+ m.get_genre());
        tahun.setText("Tahun : "+ m.get_tahun());
        return convertView;
    }
}

