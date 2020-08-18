/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.graphics;

import edu.testproject.entities.Personne;
import edu.testproject.services.CRUDPersonne;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

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

    /**
     * Initializes the controller class.
     */
    @Override   
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addPerson(ActionEvent event) throws IOException {
        PersonneCRUD cp = new PersonneCRUD();
        Personne p = new Personne();
        p.setNom(tfNom.getText());
        p.setPrenom(tfPrenom.getText());
          p.setCin(tfcin.getText());
            p.setAdresse(tfadresse.getText());
             p.setImage(file_image);
        pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
        
        pathto = FileSystems.getDefault().getPath("C:\\Users\\MSI\\Documents\\4 go\\4 2ESEMESTRE\\java\\ConnexionCS\\ConnexionCS\\src\\View\\image" + Current_file.getName());
        Path targetDir = FileSystems.getDefault().getPath("C:\\Users\\MSI\\Documents\\4 go\\4 2ESEMESTRE\\java\\ConnexionCS\\ConnexionCS\\src\\View\\image");

        Files.copy(pathfrom, pathto, StandardCopyOption.REPLACE_EXISTING);
        
        cp.ajouterPersonne(p);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsPerson.fxml"));
        try {
            Parent root = loader.load();
            DetailsPersonController dpc = loader.getController();
            dpc.setLabelNom(tfNom.getText());
            dpc.setLabelPrenom(tfPrenom.getText());
            dpc.setTgcin(tfcin.getText());
            dpc.setTgadresse(tfadresse.getText());
            
            
            
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
