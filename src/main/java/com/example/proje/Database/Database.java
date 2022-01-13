package com.example.proje.Database;

import com.example.proje.Model.Abone;
import com.example.proje.Model.Dergi;
import com.example.proje.Model.Gazete;
import com.example.proje.Model.Kullanici;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private Connection connection;
    private int k_id;
    private int b_id;

    private Database() {
    }

    private static Database instance = new Database();

    public static Database getInstance() {
        return instance;
    }


    public boolean baglan() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "123");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void kapat() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean Giris(String isim, String sifre) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sorgu = "SELECT * FROM Kullanici WHERE firstName = ? AND userPass = ?";
        try {
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setString(1, isim);
            preparedStatement.setString(2, sifre);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                k_id = resultSet.getInt(1);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean AdminGiris(String isim, String sifre) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sorgu = "SELECT * FROM SystemAdmin WHERE sysadmin_name = ? AND sysadmin_pass = ?";
        try {
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setString(1, isim);
            preparedStatement.setString(2, sifre);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean KullaniciEkle(String isim, String soyad, String pass) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sorgu = "INSERT INTO kullanici (firstName,lastName,userPass) VALUES(?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setString(1, isim);
            preparedStatement.setString(2, soyad);
            preparedStatement.setString(3, pass);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean AdresEkle(String Adres) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sorgu = "UPDATE kullanici set userAdress=? where userID=?";
        try {
            Kullanici kullanici = new Kullanici();
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setString(1, Adres);
            preparedStatement.setInt(2, k_id);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Dergi> dergiler(){
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM dergi ORDER BY dergiAdi ASC");
            ArrayList<Dergi> dergiler = new ArrayList<>();
            while (resultSet.next()){
                Dergi dergi = new Dergi();
                dergi.setDergiID(resultSet.getInt("dergiID"));
                dergi.setDergiAdi(resultSet.getString("dergiAdi"));
                dergi.setDergiYayin(resultSet.getString("dergiYayin"));
                dergi.setDergiISSN(resultSet.getString("dergiISSN"));
                dergi.setDergiYayinAra(resultSet.getString("dergiYayinAra"));
                dergiler.add(dergi);
            }
            return dergiler;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean AboneDergiOl(int dergiId){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String a_onay = "onaylanmadi";
        String sorgu = "INSERT INTO Abonelik (kullaniciID,dergiID,onay) VALUES (?,?,?)";
        try{
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setInt(1, k_id);
            preparedStatement.setInt(2, dergiId);
            preparedStatement.setString(3,a_onay);
            preparedStatement.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public ArrayList<Gazete> gazeteler(){
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM gazete ORDER BY gazeteAd ASC");
            ArrayList<Gazete> gazeteler = new ArrayList<>();
            while (resultSet.next()){
                Gazete gazete = new Gazete();
                gazete.setGazeteID(resultSet.getInt("gazeteID"));
                gazete.setGazeteAdi(resultSet.getString("gazeteAd"));
                gazete.setGazeteDil(resultSet.getString("gazeteDil"));
                gazete.setGazeteYayinAra(resultSet.getString("gazeteYayinAra"));
                gazeteler.add(gazete);
            }
             return  gazeteler;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean AboneGazeteOl(int gazeteId){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String a_onay = "onaylanmadi";
        String sorgu = "INSERT INTO Abonelik (kullaniciID,gazeteID,onay) VALUES(?,?,?)";
        try{
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setInt(1,k_id);
            preparedStatement.setInt(2,gazeteId);
            preparedStatement.setString(3,a_onay);
            preparedStatement.executeUpdate();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public ArrayList<Abone> aboneler(){
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Abonelik ORDER BY onay ASC");
            ArrayList<Abone> aboneler = new ArrayList<>();
            while (resultSet.next()){
                Abone abone = new Abone();
                abone.setAboneid(resultSet.getInt("aboneNO"));
                abone.setKullaniciId(resultSet.getInt("kullaniciID"));
                abone.setDergiId(resultSet.getInt("dergiID"));
                abone.setGazeteId(resultSet.getInt("gazeteID"));
                abone.setOnay(resultSet.getString("onay"));
                aboneler.add(abone);
            }
            return aboneler;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean aboneGuncelle(String a_onay,int aboneNO){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sorgu = "UPDATE Abonelik SET onay=? WHERE aboneNO=?";
        try{
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setString(1,a_onay);
            preparedStatement.setInt(2,aboneNO);
            preparedStatement.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean dergiEkle(String dergiAd,String dergiYayin,String dergiISSN,String dergiYayinAra){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sorgu = "INSERT INTO dergi (dergiAdi,dergiYayin,dergiISSN,dergiYayinAra) VALUES(?,?,?,?)";
        try{
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setString(1,dergiAd);
            preparedStatement.setString(2,dergiYayin);
            preparedStatement.setString(3,dergiISSN);
            preparedStatement.setString(4,dergiYayinAra);
            preparedStatement.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean dergiGuncelle(int id,String ad,String yayin,String ISSN,String ara){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sorgu = "UPDATE dergi set dergiAdi=?,dergiYayin=?,dergiISSN=?,dergiYayinAra=? where dergiID=?";
        try {
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2,yayin);
            preparedStatement.setString(3,ISSN);
            preparedStatement.setString(4,ara);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean gazeteEkle(String ad, String dil, String ara){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sorgu = "INSERT INTO gazete (gazeteAd,gazeteDil,gazeteYayinAra) VALUES (?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setString(1,ad);
            preparedStatement.setString(2,dil);
            preparedStatement.setString(3,ara);
            preparedStatement.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean gazeteGuncelle(int id,String ad,String dil,String ara){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sorgu = "UPDATE gazete set gazeteAd=?,gazeteDil=?,gazeteYayinAra=? WHERE gazeteID=?";
        try{
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setString(1,ad);
            preparedStatement.setString(2,dil);
            preparedStatement.setString(3,ara);
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean aboneSil(int id){
        String sorgu = "DELETE FROM Abonelik WHERE aboneNO=?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sorgu)){
            preparedStatement.setInt(1,id);
            id = preparedStatement.executeUpdate();
            return id == 1;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

}
