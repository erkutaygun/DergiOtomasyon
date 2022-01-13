package com.example.proje;

import com.example.proje.Database.Database;
import com.example.proje.Model.Abone;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminSayfa {

    @FXML
    private JFXButton exit;

    @FXML
    private RadioButton onayli;

    @FXML
    private RadioButton onaysiz;
    @FXML
    private TableView<Abone> tablo;

    @FXML
    void Cikis(MouseEvent event) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void Guncelle(MouseEvent event) {
        Abone secilenAbone = (Abone) tablo.getSelectionModel().getSelectedItem();
        if(secilenAbone == null){
            Info.InfoBox("Abonelik Secilmedi","Failed");
        }else{
            if(onayli.isSelected()){
                Database.getInstance().aboneGuncelle(onayli.getText(),secilenAbone.getAboneid());
                Info.InfoBox("Basarili","Success");
            }else if(onaysiz.isSelected()){
                Database.getInstance().aboneGuncelle(onaysiz.getText(),secilenAbone.getAboneid());
                Info.InfoBox("Basarili","Success");
            }else{
                Info.InfoBox("Onay durumu secilmedi","Failed");
            }
        }
    }

    @FXML
    void adminDergi(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("adminDergiList.fxml"));
        Parent parent = loader.load();
        adminDergiList adminDergiList = loader.getController();
        adminDergiList.dergiler();
        stage.setTitle("Admin Dergi");
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void adminGazete(MouseEvent event) throws IOException{
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("adminGazeteList.fxml"));
        Parent parent = loader.load();
        adminGazeteList adminGazeteList = loader.getController();
        adminGazeteList.gazeteler();
        stage.setTitle("Admin Gazete");
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void yenile(MouseEvent event) {
        tablo.getItems().clear();
        tablo.getItems().addAll(Database.getInstance().aboneler());
    }
    @FXML
    void Sil(MouseEvent event) {
        Abone secilenabone = (Abone) tablo.getSelectionModel().getSelectedItem();
        if(secilenabone == null){
            Info.InfoBox("Abone Silinemedi","Failed");
        }else{
            Database.getInstance().aboneSil(secilenabone.getAboneid());
            Info.InfoBox("Abone Silindi","Success");
        }
    }
    @FXML
    public void aboneler(){
        Task<ObservableList<Abone>> task = new aboneler();
        tablo.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }
}
