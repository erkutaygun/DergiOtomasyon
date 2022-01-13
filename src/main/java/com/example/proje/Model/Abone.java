package com.example.proje.Model;

public class Abone {
    private int Aboneid;
    private int kullaniciId;
    private int dergiId;
    private int gazeteId;
    private String onay;

    public int getAboneid() {
        return Aboneid;
    }

    public void setAboneid(int aboneid) {
        Aboneid = aboneid;
    }

    public int getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(int kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public int getDergiId() {
        return dergiId;
    }

    public void setDergiId(int dergiId) {
        this.dergiId = dergiId;
    }

    public int getGazeteId() {
        return gazeteId;
    }

    public void setGazeteId(int gazeteId) {
        this.gazeteId = gazeteId;
    }

    public String getOnay() {
        return onay;
    }

    public void setOnay(String onay) {
        this.onay = onay;
    }
}
