package com.example.proje;

import com.example.proje.Database.Database;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GazeteEkle {
    @FXML
    private JFXButton exit;

    @FXML
    private TextField gazeteAd;

    @FXML
    private TextField gazeteAra;

    @FXML
    private TextField gazeteDil;

    @FXML
    void Cikis(MouseEvent event) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    void Ekle(MouseEvent event) {
        String ad = gazeteAd.getText();
        String dil = gazeteDil.getText();
        String ara = gazeteAra.getText();
        if(ad.isEmpty() || dil.isEmpty() || ara.isEmpty()){
            Info.InfoBox("Gazete Eklenemedi","Failed");
        }else{
            Database.getInstance().gazeteEkle(ad,dil,ara);
            Info.InfoBox("Gazete eklendi","Success");
        }
    }
}
