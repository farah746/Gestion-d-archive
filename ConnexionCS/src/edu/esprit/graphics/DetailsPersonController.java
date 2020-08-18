/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.graphics;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class DetailsPersonController implements Initializable {

    @FXML
    private TextField labelNom;
    @FXML
    private TextField labelPrenom;
    @FXML
    private TextField tgadresse;
    @FXML
    private TextField tgcin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public TextField getLabelNom() {
        return labelNom;
    }

    public void setLabelNom(String labelNom) {
        this.labelNom.setText(labelNom);
    }

    public TextField getLabelPrenom() {
        return labelPrenom;
    }

    public void setLabelPrenom(String labelPrenom) {
        this.labelPrenom.setText(labelPrenom);
    }

    public TextField getTgadresse() {
        return tgadresse;
    }

    public void setTgadresse(String tgadresse) {
        this.tgadresse.setText(tgadresse);
    }

    public TextField getTgcin() {
        return tgcin;
    }

    public void setTgcin(String tgcin) {
        this.tgcin.setText(tgcin);
    }
    
}
