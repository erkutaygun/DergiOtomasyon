package com.example.proje;

import com.example.proje.Database.Database;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class dergiGuncelle {
    @FXML
    private TextField dergISSN;

    @FXML
    private TextField dergiAd;

    @FXML
    private TextField dergiAra;

    @FXML
    private TextField dergiID;

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
    void Guncelle(MouseEvent event) {
        int id = Integer.parseInt(dergiID.getText());
        String ad = dergiAd.getText();
        String yayin = dergiYayin.getText();
        String ISSN = dergISSN.getText();
        String ara = dergiAra.getText();
        if(ad.isEmpty() || yayin.isEmpty() || ISSN.isEmpty() || ara.isEmpty()){
            Info.InfoBox("Dergi Guncellenemedi","Failed");
        }else{
            Database.getInstance().dergiGuncelle(id,ad,yayin,ISSN,ara);
            Info.InfoBox("Dergi Guncellendi", "Success");
        }
    }
}
