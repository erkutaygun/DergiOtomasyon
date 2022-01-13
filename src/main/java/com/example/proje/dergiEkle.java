package com.example.proje;

import com.example.proje.Database.Database;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class dergiEkle {
    @FXML
    private TextField dergiAd;

    @FXML
    private TextField dergiAra;

    @FXML
    private TextField dergiISSN;

    @FXML
    private TextField dergiYayin;

    @FXML
    private JFXButton exit;

    @FXML
    void Cikis(MouseEvent event) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    void dergiEkle(MouseEvent event) {
        String ad = dergiAd.getText();
        String yayin = dergiYayin.getText();
        String ISSN = dergiISSN.getText();
        String yayinAra = dergiAra.getText();

        if(ad.isEmpty() || yayin.isEmpty() || ISSN.isEmpty() || yayinAra.isEmpty()){
            Info.InfoBox("Dergi eklenemedi","Failed");
        }else{
            Database.getInstance().dergiEkle(ad,yayin,ISSN,yayinAra);
            Info.InfoBox("Dergi Eklendi", "Success");
        }
    }
}
