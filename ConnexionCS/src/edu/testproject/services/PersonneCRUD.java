/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testproject.services;

import edu.testproject.entities.Personne;
import edu.testproject.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karray
 */
public class PersonneCRUD {
    
    Connection cnx = DataSource.getInstance().getConnection();
    
    public void ajouterPersonne(Personne p){
        try {
            String requete = "INSERT INTO personne (nom,prenom,cin,adresse,image) VALUES (?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
             pst.setString(3, p.getCin());
              pst.setString(4, p.getAdresse());
                pst.setString(5, p.getImage());
            pst.executeUpdate();
            System.out.println("Personne ajoutée");
          
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
//    public List<Personne> afficherPersonnes(){
//         List<Personne> myList = new ArrayList<Personne>();
//        try {
//           
//            String requete2 = "SELECT * FROM personne";
//            Statement st = cnx.createStatement();
//            ResultSet rs = st.executeQuery(requete2);
//            
//            while(rs.next()){
//                Personne p = new Personne();
//                p.setId(rs.getInt(1));
//                p.setNom(rs.getString(2));
//                p.setPrenom(rs.getString(3));
//                myList.add(p);
//            }
//            
//        } catch (SQLException ex) {
//                System.err.println(ex.getMessage());
//        }
//        return myList;
//    }
//    
//    public void supprimerPersonne(Personne p){
//        try {
//            String requete = "DELETE FROM personne WHERE id=?";
//            PreparedStatement pst = cnx.prepareStatement(requete);
//            pst.setInt(1, p.getId());
//            pst.executeUpdate();
//            System.out.println("Personne supprimée");
//            
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//    }
//    
//    public void modifierPersonne(Personne p,int id){
//        try {
//            String requete = "UPDATE  personne SET nom=?,prenom=? WHERE id=?";
//            PreparedStatement pst = cnx.prepareStatement(requete);
//            pst.setInt(3,id);
//            pst.setString(1, p.getNom());
//            pst.setString(2, p.getPrenom());
//            pst.executeUpdate();
//            System.out.println("Personne supprimée");
//            
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//    }
    
}
