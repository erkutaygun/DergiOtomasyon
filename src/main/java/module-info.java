module com.example.proje {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.jfoenix;
    requires javafx.base;
    requires com.oracle.database.jdbc;

    opens com.example.proje;
    opens com.example.proje.Model;
}