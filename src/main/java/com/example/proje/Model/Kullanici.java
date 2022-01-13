package com.example.proje.Model;

public class Kullanici {
    private int kullaniciID;
    private String kullaniciAdi;
    private String kullaniciSoyad;
    private String kullaniciSifre;
    private String kullaniciAdres;

    public int getKullaniciID() {
        return kullaniciID;
    }

    public void setKullaniciID(int kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getKullaniciSoyad(){
        return kullaniciSoyad;
    }
    public void setKullaniciSoyad(String kullaniciSoyad){
        this.kullaniciSoyad = kullaniciSoyad;
    }

    public String getKullaniciSifre() {
        return kullaniciSifre;
    }

    public void setKullaniciSifre(String kullaniciSifre) {
        this.kullaniciSifre = kullaniciSifre;
    }
    public String getKullaniciAdres(){
        return kullaniciAdres;
    }
    public void setKullaniciAdres(String kullaniciAdres){
        this.kullaniciAdres = kullaniciAdres;
    }
}
