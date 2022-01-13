package com.example.proje;

import com.example.proje.Database.Database;
import com.example.proje.Model.Kullanici;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AnaSayfa {
    @FXML
    public Button exit;
    @FXML
    public void Adres(MouseEvent event) throws IOException{
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdresBilgi.fxml"));
        Parent parent = loader.load();
        stage.setTitle("Adres Bilgi");
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void Abone(MouseEvent event) throws IOException{
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Abonelik.fxml"));
        Parent parent = loader.load();
        Abonelik abonelik = loader.getController();
        abonelik.aboneler();
        stage.setTitle("Abonelik");
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void Dergi(MouseEvent event) throws IOException{
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Dergi.fxml"));
        Parent parent = loader.load();
        DergiList dergiList = loader.getController();
        dergiList.dergiBilgi();
        stage.setTitle("Dergi");
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void Gazete(MouseEvent event) throws IOException{
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Gazete.fxml"));
        Parent parent = loader.load();
        GazeteList gazeteList = loader.getController();
        gazeteList.GazeteBilgi();
        stage.setTitle("Gazete");
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void Cikis(MouseEvent event) throws IOException{
        Platform.exit();
    }
}
