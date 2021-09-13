package com.codes.tugas9wildanromiza.Model;

public class Makanan {
    String nama,harga,gambar,url;

    public Makanan(String nama, String harga, String gambar,String url) {
        this.nama = nama;
        this.harga = harga;
        this.gambar = gambar;
        this.url = url;

    }

    public String getUrl() {
        return url;
    }

    public String getNama() {
        return nama;
    }

    public String getHarga() {
        return harga;
    }

    public String getGambar() {
        return gambar;
    }
}
