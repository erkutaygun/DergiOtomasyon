package com.example.proje;

import com.example.proje.Database.Database;
import com.example.proje.Model.Dergi;
import com.example.proje.Model.Gazete;
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

public class adminGazeteList {
    @FXML
    private JFXButton exit;

    @FXML
    private TableView<Gazete> tablo;

    @FXML
    void Cikis(MouseEvent event) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    void Ekle(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GazeteEkle.fxml"));
        Parent parent = loader.load();
        stage.setTitle("Gazete Ekle");
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void Guncelle(MouseEvent event) throws  IOException{
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GazeteGuncelle.fxml"));
        Parent parent = loader.load();
        stage.setTitle("Gazete Guncelle");
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void gazeteler(){
        Task<ObservableList<Gazete>> task = new gazeteler();
        tablo.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }
    @FXML
    void yenile(MouseEvent event) {
        tablo.getItems().clear();
        tablo.getItems().addAll(Database.getInstance().gazeteler());
    }
}
class gazeteler extends Task {
    @Override
    protected ObservableList<Gazete> call() throws Exception {
        return FXCollections.observableArrayList(Database.getInstance().gazeteler());
    }
}