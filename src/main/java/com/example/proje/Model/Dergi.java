package com.example.proje.Model;

public class Dergi {
    private int dergiID;
    private String dergiAdi;
    private String dergiYayin;
    private String dergiDil;
    private String dergiISSN;
    private String dergiYayinAra;

    public int getDergiID(){
        return dergiID;
    }
    public void setDergiID(int dergiID){
        this.dergiID = dergiID;
    }
    public String getDergiAdi(){
        return  dergiAdi;
    }
    public void setDergiAdi(String dergiAdi) {
        this.dergiAdi = dergiAdi;
    }
    public String getDergiYayin(){
        return dergiYayin;
    }
    public void setDergiYayin(String dergiYayin){
        this.dergiYayin = dergiYayin;
    }
    public String getDergiDil(String dergiDil){
        return dergiDil;
    }
    public void setDergiDil(String dergiDil){
        this.dergiDil = dergiDil;
    }
    public String getDergiISSN(){
        return dergiISSN;
    }
    public void setDergiISSN(String dergiISSN){
        this.dergiISSN = dergiISSN;
    }
    public String getDergiYayinAra(){
        return dergiYayinAra;
    }
    public void setDergiYayinAra(String dergiYayinAra){
        this.dergiYayinAra = dergiYayinAra;
    }
}
