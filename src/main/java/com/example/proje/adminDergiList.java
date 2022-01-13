package com.example.proje;

import com.example.proje.Database.Database;
import com.example.proje.Model.Dergi;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class adminDergiList {
    @FXML
    private JFXButton exit;

    @FXML
    private TableView<Dergi> tablo;

    @FXML
    void Cikis(MouseEvent event) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    void Yenile(MouseEvent event) {
        tablo.getItems().clear();
        tablo.getItems().addAll(Database.getInstance().dergiler());
    }

    @FXML
    void dergiEkle(MouseEvent event) throws Exception {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dergiEkle.fxml"));
        Parent parent = loader.load();
        stage.setTitle("Admin Dergi Ekle");
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void dergiGuncelle(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dergiGuncelle.fxml"));
        Parent parent = loader.load();
        stage.setTitle("Admin Dergi Guncelle");
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void dergiler(){
        Task<ObservableList<Dergi>> task = new dergiler();
        tablo.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }

}
class dergiler extends Task {
    @Override
    protected ObservableList<Dergi> call() throws Exception {
        return FXCollections.observableArrayList(Database.getInstance().dergiler());
    }
}
