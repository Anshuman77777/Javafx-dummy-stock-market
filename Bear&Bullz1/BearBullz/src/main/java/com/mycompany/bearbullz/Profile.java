/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bearbullz;

/**
 *
 * @author Sarthak Suryavanshi
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Profile extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        
         
        FXMLLoader loader=new FXMLLoader(getClass().getResource("profile.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        primaryStage.setTitle("Bear & Bullz");
        primaryStage.setScene(scene);
         scene.getStylesheets().add(getClass().getResource("profile.css").toExternalForm());
         
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
