package com.example.proje;

import com.example.proje.Database.Database;
import com.example.proje.Model.Abone;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Abonelik {
    @FXML
    private JFXButton exit;

    @FXML
    private TableView<Abone> tablo;

    @FXML
    void Cikis(MouseEvent event) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void aboneler(){
        Task<ObservableList<Abone>> task = new aboneler();
        tablo.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }
}
class aboneler extends Task{
    @Override
    protected ObservableList<Abone> call() throws Exception{
        return FXCollections.observableArrayList(Database.getInstance().aboneler());
    }
}
