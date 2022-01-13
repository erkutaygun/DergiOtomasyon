package com.example.proje;

import com.example.proje.Database.Database;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AdresBilgi {

    @FXML
    private TextField adres;
    @FXML
    private JFXButton exit;



    @FXML
    public void Ekle(MouseEvent event) {
        String kullaniciAdres = adres.getText();
        if(kullaniciAdres.isEmpty()){
            Info.InfoBox("Adres Eklenmedi","Failed");
        }else{
                Database.getInstance().AdresEkle(kullaniciAdres);
                Info.InfoBox("Adres Eklendi","Success");
            }
        }
    @FXML
    void Exit(MouseEvent event) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }
}

