package com.example.proje;

import com.example.proje.Database.Database;
import com.example.proje.Model.Dergi;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DergiList {
    @FXML
    private JFXButton exit;

    @FXML
    private TableView<Dergi> tablo;
    @FXML
    private TextField search;

    @FXML
    public void dergiBilgi(){
        FilteredList<Dergi> filteredList = new FilteredList<>(FXCollections.observableArrayList(Database.getInstance().dergiler()),p-> true);
        search.textProperty().addListener((observable,oldValue,newValue)->{
            filteredList.setPredicate(dergi -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if(dergi.getDergiAdi().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }else if(dergi.getDergiISSN().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }else if(dergi.getDergiYayin().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }else if(dergi.getDergiYayinAra().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                return false;
            });
        });
        SortedList<Dergi> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(tablo.comparatorProperty());
        tablo.setItems(sortedList);
    }
    @FXML
    void Cikis(MouseEvent event) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    void aboneOl(MouseEvent event) {
        Dergi secilenDergi = (Dergi) tablo.getSelectionModel().getSelectedItem();
        if(secilenDergi == null){
            Info.InfoBox("Dergi Secilmedi", "Failed");
        }else{
            Database.getInstance().AboneDergiOl(secilenDergi.getDergiID());
            Info.InfoBox("Abone Olundu","Success");
        }
    }
}
