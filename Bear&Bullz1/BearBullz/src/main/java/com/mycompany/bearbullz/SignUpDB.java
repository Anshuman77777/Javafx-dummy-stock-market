/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bearbullz;
import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
/**
 *
 * @author mayur
 */
import java.util.HashMap;
import java.util.Map;

public class SignUpDB {
   
    
    public static void UserDetail(String gmail, String name,String prn,String age, String bio ) {

        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb+srv://sanshuman4422:umangbsdk@cluster0.pi8si.mongodb.net/";

         // Create a MongoClient instance
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            // Connect to the database
            MongoDatabase database = mongoClient.getDatabase("BEARBULLZ"); // Replace with your database name

            // Access the collection
            MongoCollection<Document> collection = database.getCollection("USERS"); // Replace with your collection name

            // Check for a document
            Document query = new Document("GMAIL",gmail);
            Document existingDocument = collection.find(query).first();
            
            Map<String, Object> dataMap = new HashMap<>();
             dataMap.put("name", name);
             dataMap.put("prn", prn);
            dataMap.put("age", age);
             dataMap.put("bio", bio);
             Document document = new Document(dataMap);
             collection.insertOne(document);

            if (existingDocument != null) {
                System.out.println("Document found: " + existingDocument.toJson());
                 


                // Update the document
                //Document update = new Document("$set", new Document("age", 31));
                //collection.updateOne(query, update);
                System.out.println("Document updated successfully!");
            } else {
                System.out.println("Document not found. Adding new document...");
                Document newDocument = null;

                // Insert a new document
                //Document newDocument = new Document("GMAIL", gmail)
                //.append("PASSWORD", password);
                //collection.insertOne(newDocument);
                //<<< HE
                //<<<<=======
            //    Document newDocument = new Document("GMAIL", gmail)
            //            .append("PASSWORD", password);
                collection.insertOne(newDocument);
//>>>>>>> ced7ddf7dd8bd0363771ecbc4dbf442088d66696
                System.out.println("New document inserted successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
