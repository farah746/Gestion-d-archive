/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.graphics;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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
    @FXML
    private ImageView IMAG;
    @FXML
    private JFXTextField labelemail;
    @FXML
    private JFXTextField labelgenre;
    @FXML
    private JFXTextField labelidentifiant;
    @FXML
    private JFXTextField labelposte;
    @FXML
    private JFXTextField labelpwd;
    @FXML
    private JFXTextField labelrole;

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

    public ImageView getIMAG() {
        return IMAG;
    }

    public void setIMAG(ImageView IMAG) {
        this.IMAG = IMAG;
    }

    public JFXTextField getLabelemail() {
        return labelemail;
    }

    public void setLabelemail(JFXTextField labelemail) {
        this.labelemail = labelemail;
    }

    public JFXTextField getLabelgenre() {
        return labelgenre;
    }

    public void setLabelgenre(JFXTextField labelgenre) {
        this.labelgenre = labelgenre;
    }

    public JFXTextField getLabelidentifiant() {
        return labelidentifiant;
    }

    public void setLabelidentifiant(JFXTextField labelidentifiant) {
        this.labelidentifiant = labelidentifiant;
    }

    public JFXTextField getLabelposte() {
        return labelposte;
    }

    public void setLabelposte(JFXTextField labelposte) {
        this.labelposte = labelposte;
    }

    public JFXTextField getLabelpwd() {
        return labelpwd;
    }

    public void setLabelpwd(JFXTextField labelpwd) {
        this.labelpwd = labelpwd;
    }

    public JFXTextField getLabelrole() {
        return labelrole;
    }

    public void setLabelrole(JFXTextField labelrole) {
        this.labelrole = labelrole;
    }

    
    
}
