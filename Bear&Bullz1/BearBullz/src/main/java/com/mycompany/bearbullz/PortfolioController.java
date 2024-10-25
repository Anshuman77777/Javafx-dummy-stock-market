/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bearbullz;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListCell;
import javafx.util.Callback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author mayur
 */


public class PortfolioController {
    
    String Gmail;
    Stage stage;
    public BorderPane Canvas;
    @FXML
    private VBox portfolioContainer;
    public void setGmail(String Gmail,Stage stage,BorderPane Canvas)
    {this.Canvas=Canvas;
        this.stage=stage;
        this.Gmail=Gmail;
    initialize();
    }
    @FXML
    private ListView<HashMap<String, Object>> portfolioListView;

    

    

    @FXML
    public void initialize() {
        
        ArrayList<HashMap<String, Object>> stocks = UsersDB.getSortedStocksByInvestment(Gmail);
        for(HashMap stock : stocks){
            HBox userCard = createUserCard(stock.get("STOCK_NAME").toString(),
                                           Integer.parseInt(stock.get("QUANTITY").toString()),
                                           Integer.parseInt(stock.get("INVESTMENT").toString()));
                   portfolioContainer.getChildren().add(userCard);
/*
                            String stockName = (String) stock.get("STOCK_NAME");
                            int stockNumber = (int) stock.get("QUANTITY");
                            double totalValue = (double) stock.get("INVESTMENT");
                            setText(stockName + ": " + stockNumber + " stocks, Total Value: $" + totalValue);
                            setStyle("-fx-padding: 10;");
                            getStyleClass().add("list-cell");
*/                            
                        }

        // Set custom cell factory to format how each stock is displayed
       
    }
    private HBox createUserCard(String name, int quantity, int investment) {
        HBox card = new HBox();
        card.getStyleClass().add("user-card");
        card.setPrefWidth(600);
        // Add the index number before the username
        Label indexLabel = new Label(name);
        indexLabel.getStyleClass().add("name");

        Label usernameLabel = new Label(String.valueOf(quantity));
        usernameLabel.getStyleClass().add("quantity");

        Label balanceLabel = new Label(String.valueOf(investment));
        balanceLabel.getStyleClass().add("investment");

        // The order now places index before the username
        card.getChildren().addAll(indexLabel, usernameLabel, balanceLabel);
        card.setOnMouseClicked(event -> { FXMLLoader loader = new FXMLLoader(getClass().getResource("StockPage.fxml"));
        Parent root;
            try {
                root = loader.load();
                StockPageController mpc=loader.getController();
                mpc.loadSampleStockData(name);
                mpc.email=Gmail;
                mpc.setStage(stage);
        Canvas.setCenter(root);
        Canvas.getStylesheets().add(getClass().getResource("stockpage.css").toExternalForm());
            } catch (IOException ex) {
                Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    });
        return card;
    }


    @FXML
    private void handleStockClick(MouseEvent event) {
        if (event.getClickCount() == 2) {
            HashMap<String, Object> selectedStock = portfolioListView.getSelectionModel().getSelectedItem();
            if (selectedStock != null) {
                String stockName = (String) selectedStock.get("name");
                openStockPage(stockName);
            }
        }
    }

    private void openStockPage(String stockName) {
        // Navigate to stock details page (replace with actual navigation logic)
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Stock Details");
        alert.setHeaderText(null);
        alert.setContentText("Opening details for: " + stockName);
        alert.showAndWait();
    }
}
/*package com.mycompany.bearbullz;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListCell;
import javafx.util.Callback;
import java.util.ArrayList;
import java.util.HashMap;

public class PortfolioController {

    @FXML
    private ListView<HashMap<String, Object>> portfolioListView;

    private ArrayList<HashMap<String, Object>> stocks = new ArrayList<>();

    @FXML
    public void initialize() {
        // Example stock data
        addStock("AAPL", 50, 7500.0);
        addStock("TSLA", 20, 17000.0);
        addStock("GOOGL", 15, 18000.0);

        // Set custom cell factory to format how each stock is displayed
        portfolioListView.setCellFactory(new Callback<>() {
            @Override
            public ListCell<HashMap<String, Object>> call(ListView<HashMap<String, Object>> listView) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(HashMap<String, Object> stock, boolean empty) {
                        super.updateItem(stock, empty);
                        if (empty || stock == null) {
                            setText(null);
                        } else {
                            String stockName = (String) stock.get("name");
                            int stockNumber = (int) stock.get("number");
                            double totalValue = (double) stock.get("value");
                            setText(stockName + ": " + stockNumber + " stocks, Total Value: $" + totalValue);
                            setStyle("-fx-padding: 10;");
                            getStyleClass().add("list-cell");
                        }
                    }
                };
            }
        });

        // Populate the ListView with stock data
        portfolioListView.getItems().addAll(stocks);
    }

    private void addStock(String name, int number, double value) {
        HashMap<String, Object> stock = new HashMap<>();
        stock.put("name", name);
        stock.put("number", number);
        stock.put("value", value);
        stocks.add(stock);
    }

    @FXML
    private void handleStockClick(MouseEvent event) {
        if (event.getClickCount() == 2) {
            HashMap<String, Object> selectedStock = portfolioListView.getSelectionModel().getSelectedItem();
            if (selectedStock != null) {
                String stockName = (String) selectedStock.get("name");
                openStockPage(stockName);
            }
        }
    }

    private void openStockPage(String stockName) {
        // Navigate to stock details page (replace with actual navigation logic)
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Stock Details");
        alert.setHeaderText(null);
        alert.setContentText("Opening details for: " + stockName);
        alert.showAndWait();
    }
}
*/