package com.example.proje;

import com.example.proje.Info;
import com.example.proje.Database.Database;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class KullaniciGiris {
    @FXML
    private TextField kullaniciAdi;

    @FXML
    private TextField kullaniciSifre;

    @FXML
    public void Kayit(javafx.scene.input.MouseEvent mouseEvent) throws IOException{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("KullaniciKayit.fxml"));
        primaryStage.setTitle("Kullanıcı Giriş");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    @FXML
    public void Giris(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        String ad = kullaniciAdi.getText();
        String sifre = kullaniciSifre.getText();
        if (Objects.equals(ad, "system")) {
            if (Database.getInstance().AdminGiris(ad, sifre)) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminSayfa.fxml"));
                Parent parent = loader.load();
                AdminSayfa adminSayfa = loader.getController();
                adminSayfa.aboneler();
                Node node = (Node) mouseEvent.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setTitle("Admin Sayfasi");
                stage.setScene(new Scene(parent));
            } else {
                Info.InfoBox("Admin sifresi yanlis", "Failed");
            }
        } else {
            if (Database.getInstance().Giris(ad, sifre)) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AnaSayfa.fxml"));
                Parent parent = loader.load();
                Node node = (Node) mouseEvent.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setTitle("Ana Sayfa");
                stage.setScene(new Scene(parent));

            } else {
                Info.InfoBox("Kullanici Adi veya Sifre yanlis", "Failed");
            }

        }

    }
}

