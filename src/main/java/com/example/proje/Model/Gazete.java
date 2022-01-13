package com.example.proje.Model;

public class Gazete {
    private int gazeteID;
    private String gazeteAdi;
    private String gazeteDil;
    private String gazeteYayinAra;

    public int getGazeteID(){
        return gazeteID;
    }
    public void setGazeteID(int gazeteID){
        this.gazeteID = gazeteID;
    }
    public String getGazeteAdi(){
        return gazeteAdi;
    }
    public void setGazeteAdi(String gazeteAdi){
        this.gazeteAdi = gazeteAdi;
    }
    public String getGazeteDil(){
        return gazeteDil;
    }
    public void setGazeteDil(String gazeteDil){
        this.gazeteDil = gazeteDil;
    }
    public String getGazeteYayinAra(){
        return gazeteYayinAra;
    }
    public void setGazeteYayinAra(String gazeteYayinAra){
        this.gazeteYayinAra = gazeteYayinAra;
    }
}
