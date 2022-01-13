package com.example.proje;

import com.example.proje.Database.Database;
import com.example.proje.Model.Gazete;
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


public class GazeteList {
    @FXML
    private JFXButton exit;

    @FXML
    private TableView<Gazete> tablo;
    @FXML
    private TextField search;

    @FXML
    public void GazeteBilgi(){
        FilteredList<Gazete> filteredList = new FilteredList<>(FXCollections.observableArrayList(Database.getInstance().gazeteler()),p -> true);
        search.textProperty().addListener((observable,oldValue,newValue) -> {
            filteredList.setPredicate(gazete -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lowerCaseFilter = newValue.toLowerCase();
                        if (gazete.getGazeteAdi().toLowerCase().contains(lowerCaseFilter)) {
                            return true;
                        } else if (gazete.getGazeteDil().toLowerCase().contains(lowerCaseFilter)) {
                            return true;
                        } else if (gazete.getGazeteYayinAra().toLowerCase().contains(lowerCaseFilter)) {
                            return true;
                        }
                        return false;
                    }
            );
        });
        SortedList<Gazete> sortedList = new SortedList<>(filteredList);
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
        Gazete secilenGazete = (Gazete) tablo.getSelectionModel().getSelectedItem();
        if(secilenGazete == null){
            Info.InfoBox("Gazete Secilmedi","Failed");
        }else{
            Database.getInstance().AboneGazeteOl(secilenGazete.getGazeteID());
            Info.InfoBox("Abonelik Onaylandi","Success");
        }
     }
}

