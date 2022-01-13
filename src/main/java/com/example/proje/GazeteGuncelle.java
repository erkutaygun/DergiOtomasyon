package com.example.proje;

import com.example.proje.Database.Database;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GazeteGuncelle {
    @FXML
    private JFXButton exit;

    @FXML
    private TextField gazeteAD;

    @FXML
    private TextField gazeteAra;

    @FXML
    private TextField gazeteDil;

    @FXML
    private TextField gazeteID;

    @FXML
    void Cikis(MouseEvent event) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    void Guncelle(MouseEvent event) {
        int id;
        String ad,dil,ara;
        id = Integer.parseInt(gazeteID.getText());
        ad = gazeteAD.getText();
        dil = gazeteDil.getText();
        ara = gazeteAra.getText();
        if(ad.isEmpty() || dil.isEmpty() || ara.isEmpty()){
            Info.InfoBox("Gazete Guncellenmedi","Failed");
        }else{
            Database.getInstance().gazeteGuncelle(id,ad,dil,ara);
            Info.InfoBox("Gazete Guncellendi","Success");
        }
    }

}
