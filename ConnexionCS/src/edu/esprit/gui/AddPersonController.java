/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.testproject.entities.Personne;
import edu.testproject.services.CRUDPersonne;
import edu.testproject.services.PersonneCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Karray
 */
public class AddPersonController implements Initializable {
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private Button btAjout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterPersonne(ActionEvent event) {
        try {
            PersonneCRUD myTool = new PersonneCRUD();
            Personne p = new Personne();
            p.setNom(tfNom.getText());
            p.setPrenom(tfPrenom.getText());
            myTool.ajouterPersonne(p);
            JOptionPane.showMessageDialog(null, "Personne ajouté");
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsPerson.fxml"));
            Parent root = loader.load();
            DetailsPersonController dpc = loader.getController();
            dpc.setDnom(tfNom.getText());
            dpc.setDprenom(tfPrenom.getText());
            tfNom.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
        
    }
    
}
