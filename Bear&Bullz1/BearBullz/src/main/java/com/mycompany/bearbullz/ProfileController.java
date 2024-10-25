/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bearbullz;

/**
 *
 * @author Suryavanshi Sarthak
 */

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.HashMap;

public class ProfileController {
    @FXML
    private Label nameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label prnLabel;
    @FXML
    private Label ageLabel;
    @FXML
    private Label bioLabel;
    @FXML
    private Label coinsLabel;
    String Gmail;
    public void setGmail(String Gmail)
    {this.Gmail=Gmail;
             HashMap<String, Object> profileData = UsersDB.getUserDataByEmail(Gmail);    
             nameLabel.setText("Name: " + profileData.get("NAME").toString());
        emailLabel.setText("Email: " + profileData.get("GMAIL").toString());
        prnLabel.setText("PRN: " + profileData.get("PRN").toString());
        ageLabel.setText("Age: " + profileData.get("AGE").toString());
        bioLabel.setText("Bio: " + profileData.get("BIO").toString());
        coinsLabel.setText("Coins: " + profileData.get("BALANCE").toString());

    }
   


    // Predefined HashMap

    public ProfileController() {
        
        // Sample profile data
       /* profileData.put("name", "John Doe");
        profileData.put("email", "john.doe@example.com");
        profileData.put("prn", "123456");
        profileData.put("age", "30");
        profileData.put("bio", "Software Developer and Java Enthusiast.");
        profileData.put("coins", "150");*/
    }

    @FXML
    public void initialize() {
        // Populate the labels with data from HashMap

    }
}

