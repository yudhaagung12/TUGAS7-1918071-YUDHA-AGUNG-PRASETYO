package com.example.tugas7_yudha;

public class Anime {
    private String _id, _judul, _genre, _tahun;
    public Anime (String id, String judul, String genre, String tahun) {
        this._id = id;
        this._judul = judul;
        this._genre = genre;
        this._tahun = tahun;
    }
    public Anime() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) { this._id = _id; }
    public String get_judul() {
        return _judul;
    }
    public void set_judul(String _judul) {
        this._judul = _judul;
    }
    public String get_genre() {
        return _genre;
    }
    public void set_genre(String _genre) {
        this._genre = _genre;
    }
    public String get_tahun() {
        return _tahun;
    }
    public void set_tahun(String _tahun) {
        this._tahun = _tahun;
    }
}
