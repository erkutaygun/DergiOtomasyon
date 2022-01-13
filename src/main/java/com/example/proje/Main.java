package com.example.proje;

import com.example.proje.Database.Database;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("KullaniciGiris.fxml"));
        primaryStage.setTitle("Kullanıcı Giriş");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        if(!Database.getInstance().baglan()){
            Platform.exit();
        }
    }
    @Override
    public void stop() throws Exception{
        super.stop();
        Database.getInstance().kapat();
    }

    public static void main(String[] args) {
        launch(args);
    }
}