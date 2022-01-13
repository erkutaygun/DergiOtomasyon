package com.example.proje;

import com.example.proje.Info;
import com.example.proje.Database.Database;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class KullaniciKayit {
    @FXML
    private JFXButton buttonCikis;
    @FXML
    private TextField kullaniciAdi;

    @FXML
    private TextField kullaniciSifre;

    @FXML
    private TextField kullaniciSoyad;

    @FXML
    public void Kayit(MouseEvent event) {
        String ad    = kullaniciAdi.getText();
        String soyad = kullaniciSoyad.getText();
        String sifre = kullaniciSifre.getText();

        if(ad.isEmpty() || soyad.isEmpty() || sifre.isEmpty()){
            Info.InfoBox("Kullanici Eklenmedi","Failed");
        }else{
            if(ad.equals("system")){
                Info.InfoBox("Kullancici eklenemedi","Failed");
            }else {
                Database.getInstance().KullaniciEkle(ad, soyad, sifre);
                Info.InfoBox("Kullanici Eklendi", "Success");
            }
        }
    }

    @FXML
    public void Cikis(MouseEvent event) {
        Stage stage = (Stage) buttonCikis.getScene().getWindow();
        stage.close();
    }
}
