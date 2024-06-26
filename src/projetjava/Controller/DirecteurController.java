/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package projetjava.Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hajri
 */
public class DirecteurController  {

    /**
     * Initializes the controller class.
     */
    private int dirID;
    
    public void setDirID(int DirID){
        this.dirID = DirID;
    }
    
      @FXML
    private void handleButtonClick(ActionEvent event) {
        
        try {
            
            // Charger le fichier FXML de l'interface interf1directeur
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/projetjava/Views/INTERF1Directeur.fxml"));
            Parent root = loader.load();
            INTERF1DirecteurController directeurController = loader.getController();
            directeurController.setDirID(dirID);
            // Créer une nouvelle scène
            Scene scene = new Scene(root);

            // Obtenir la fenêtre principale
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setTitle("Gestion des Chefs ");

            // Définir la nouvelle scène sur la fenêtre principale
            primaryStage.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("erreur en affichage interface directeur ");
        }
    }
     @FXML
    private void handleGererOperateursButtonClick(ActionEvent event) {
        try {
            // Load the FXML file of the interface for managing operators
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/projetjava/Views/Interf2DirecteurGop.fxml"));
            Parent root = loader.load();
            Interf2DirecteurGopController directeurController = loader.getController();
            directeurController.setDirID(dirID);
            // Create a new scene
            Scene scene = new Scene(root);

            // Get the primary stage
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setTitle("Gestion des Operateurs ");


            // Set the new scene on the primary stage
            primaryStage.setScene(scene);
        } catch (IOException e) {
            // Handle the exception appropriately
            System.out.println("Error displaying the Manage Operators interface: " + e.getMessage());
        }
    }

    
}
