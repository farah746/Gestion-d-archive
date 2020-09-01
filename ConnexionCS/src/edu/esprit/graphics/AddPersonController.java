/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.graphics;

import edu.testproject.entities.Personne;

import edu.testproject.services.PersonneCRUD;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Karray
 */
public class AddPersonController implements Initializable {
    final FileChooser fileChooser = new FileChooser();
    private String file_image;
    private Desktop desktop = Desktop.getDesktop();
    private Path pathfrom;
    private Path pathto;
    private File Current_file;
    private FileInputStream fis;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private Button btnValider;
    @FXML
    private TextField tfcin;
    @FXML
    private TextField tfadresse;
    @FXML
    private Button uploadImage;
    @FXML
    private ImageView image;
    @FXML
    private ImageView imageView;
    @FXML
    private TextField tmail;
    @FXML
    private TextField tposte;
    @FXML
    private TextField tidentifiant;
    @FXML
    private TextField tpwd;
    @FXML
    private ComboBox<String> trole;
    @FXML
    private ComboBox<String> tgenre;

    /**
     * Initializes the controller class.
     */
    @Override   
    public void initialize(URL url, ResourceBundle rb) {
        trole.getItems().addAll("Admin","simple utilisateur","super admin");
        tgenre.getItems().addAll("homme","femme");
        // TODO
    }    

    @FXML
    private void addPerson(ActionEvent event) throws IOException {
        PersonneCRUD cp = new PersonneCRUD();
        Personne p = new Personne();
//      Integer.parseInt(tel.getText())
//        int a=(int)   
        p.setCin(Integer.parseInt(tfcin.getText()));
        p.setNom(tfNom.getText());
        p.setPrenom(tfPrenom.getText());
        p.setAdresse(tfadresse.getText());
        p.setImage(file_image);
        p.setEmail(tmail.getText());
        p.setGenre(tgenre.getSelectionModel().getSelectedItem());
        p.setNumeroidentifiant(Integer.parseInt(tidentifiant.getText()));
        p.setPoste(tposte.getText());
        p.setPwd(tpwd.getText());
        p.setRole(trole.getSelectionModel().getSelectedItem());
        
        pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
        pathto = FileSystems.getDefault().getPath("C:\\Users\\MSI\\Documents\\4 go\\4 2ESEMESTRE\\java\\ConnexionCS\\ConnexionCS\\src\\View\\image" + Current_file.getName());
        Path targetDir = FileSystems.getDefault().getPath("C:\\Users\\MSI\\Documents\\4 go\\4 2ESEMESTRE\\java\\ConnexionCS\\ConnexionCS\\src\\View\\image");
        Files.copy(pathfrom, pathto, StandardCopyOption.REPLACE_EXISTING);
        cp.ajouterPersonne(p);
        
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterLicence.fxml"));
        try {
            Parent root = loader.load();
            DetailsPersonController dpc = loader.getController();
//            dpc.setTgcin(tfcin.getText());
//            dpc.setLabelNom(tfNom.getText());
//            dpc.setLabelPrenom(tfPrenom.getText());
//          
//            dpc.setTgadresse(tfadresse.getText());
//           
//               dpc.setLabelemail(tmail.getText());
//              dpc.setLabelgenre(tgenre.getText());
            
            tfNom.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AddPersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void uploadImage(ActionEvent event) {
           FileChooser fc = new FileChooser();
        Current_file = fc.showOpenDialog(null);
        if (Current_file != null) {
            Image images = new Image(Current_file.toURI().toString(), 100, 100, true, true);
            image.setImage(images);
            try {
                fis = new FileInputStream(Current_file);
                file_image = Current_file.getName();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AddPersonController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
