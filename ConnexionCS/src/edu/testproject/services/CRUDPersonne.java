/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testproject.services;


import edu.esprit.utils.MyConnexion;
import edu.testproject.entities.Personne;
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
public class CRUDPersonne {
    
    public void ajouterPersonne(){
        try {
            String requete = "INSERT INTO personne (nom,prenom) VALUES ('Ben esprit','esprit')";
           // Statement st = cnx.createStatement();
            Statement st = MyConnexion.getInstance().getConnection().createStatement();
            st.executeUpdate(requete);
            System.out.println("Personne ajoutée");
        } catch (SQLException ex) {
            Logger.getLogger(CRUDPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ajouterPersonne2(){
        try {
            String requete2 = "INSERT INTO personne (nom,prenom) VALUES (?,?)";
            PreparedStatement pst = MyConnexion.getInstance()
                                    .getConnection()
                                    .prepareStatement(requete2);
            pst.setString(1, "Dupont");
            pst.setString(2, "Julien");
            //pst.executeUpdate();
            System.out.println("Personne 2 ajoutée");
        } catch (SQLException ex) {
            Logger.getLogger(CRUDPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void supprimerPersonne(Personne p){
        try {
            String requete ="DELETE FROM personne WHERE id=?";
            PreparedStatement pst = MyConnexion.getInstance().getConnection()
                    .prepareStatement(requete);
            pst.setInt(1,p.getId());
            pst.executeUpdate();
            System.out.println("Personne supprimé");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void updatePersonne(Personne p,int id){
        try {
            String requete3 = "UPDATE personne SET nom=?,prenom=? WHERE id=?";
            PreparedStatement pst2 = MyConnexion.getInstance().getConnection()
                    .prepareStatement(requete3);
            pst2.setString(1, p.getNom());
            pst2.setString(2, p.getPrenom());
            pst2.setInt(3, id);
            pst2.executeUpdate();
            System.out.println("Personne modifiée");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
    public List<Personne> listerPersonnes(){
        List<Personne> myList = new ArrayList<Personne>();
        try {
            
            String requete5 = "SELECT * FROM personne";
            Statement st = MyConnexion.getInstance()
                    .getConnection().createStatement();
            
            ResultSet rs = st.executeQuery(requete5);
            while(rs.next()){
                Personne p = new Personne();
                System.out.println("\n ****");
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrenom(rs.getString("prenom"));
                myList.add(p);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
        
        
        
    }
}
