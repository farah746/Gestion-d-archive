/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Karray
 */
public class DetailsPersonController implements Initializable {
    @FXML
    private TextField dnom;
    @FXML
    private TextField dprenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public TextField getDnom() {
        return dnom;
    }

    public void setDnom(String dnom) {
        this.dnom.setText(dnom);
    }

    public TextField getDprenom() {
        return dprenom;
    }

    public void setDprenom(String dprenom) {
        this.dprenom.setText(dprenom);
    }
    
    
}
