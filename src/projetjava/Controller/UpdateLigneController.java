/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package projetjava.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import projetjava.Model.Production.LigneDeProduction;
import java.sql.Connection;
import javafx.scene.control.ChoiceBox;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author hajri
 */
public class UpdateLigneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ChoiceBox disponible;

    @FXML
    private TextField id;

    @FXML
    private TextField nom;
    
    private LigneDeProduction ligne;
    
    private GestionLignesController ligneController;
    
    public Consumer<LigneDeProduction> updateCallback;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setLigne(LigneDeProduction ligne) {
        this.ligne = ligne;

        
        nom.setText(ligne.getNom());
        id.setText(String.valueOf(ligne.getId()));
        disponible.getItems().addAll("true", "false");
        disponible.setValue(String.valueOf(ligne.getDisponible()));
    }

    public void setLigneController(GestionLignesController ligneController) {
        this.ligneController = ligneController;
    }
    
    
    private boolean isInputValid() {

        String errorMessage = "";
        if (id.getText() == null || id.getText().length() == 0) {
            errorMessage += "Id non valide\n"; } else {
            try { Integer.parseInt(id.getText()); }
            catch (NumberFormatException e) { errorMessage += "Id doit etre un entier\n"; } 
        }
        if (nom.getText() == null || nom.getText().length() == 0) {
            errorMessage += "Nom non valide\n"; }
        if (disponible == null){
            errorMessage += "Disponibilite non valide\n";
        }
        if (errorMessage.length() == 0) { return true; } else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("champs invalides");
        alert.setHeaderText("svp corrigez les champs invalides");
        alert.setContentText(errorMessage);
        alert.showAndWait();
        return false; } }
    
    
    @FXML
    public void handleUpdateButton() {
        // Get the updated values from the TextFields
        if(isInputValid()){
            int updatedId = Integer.parseInt(id.getText());
            String updatedNom = nom.getText();
            boolean updatedDisponible = Boolean.parseBoolean((String) disponible.getValue());
            LigneDeProduction ligne = new LigneDeProduction(updatedId, updatedNom, updatedDisponible);
            try {
                // Assuming you have a Connection object named "connection"
                // You should replace this with your actual way of obtaining a database connection
                // Connection connection = ...;
                // Assuming your table name is "Chefs" and you have fields like "Nom", "Prenom", etc.
                    int rowsUpdated = LigneDAO.updateLigneDeProduction(ligne);

                    if (rowsUpdated > 0) {
                        System.out.println("Chef updated successfully.");
                        ligneController.refreshTableData();
                    } else {
                        System.out.println("Failed to update Chef.");
                    }
                     // Notify the main controller of the update
                if (updateCallback != null) {
                    updateCallback.accept(ligne);
                }
            } catch (SQLException e) {
                System.out.println("erreur handleUpdateButton");    }

            // Close the update scene
            nom.getScene().getWindow().hide();
        }

    }
    public void setUpdateCallback(Consumer<LigneDeProduction> updateCallback) {
        this.updateCallback = updateCallback;
    }
}
