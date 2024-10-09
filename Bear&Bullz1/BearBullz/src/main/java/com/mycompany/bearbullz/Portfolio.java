/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bearbullz;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
/**
 *
 * @author mayur
 */

public class Portfolio  extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("portfolio.fxml"));
         Parent root =loader.load();
         
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("portfolio.css").toExternalForm());

        primaryStage.setTitle("Portfolio Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
