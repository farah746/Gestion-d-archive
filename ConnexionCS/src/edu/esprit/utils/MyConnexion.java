package edu.esprit.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Karray
 */
public class MyConnexion {

    private static MyConnexion instance;
    Connection cnx;
    
    private MyConnexion() {
        try {
            String url="jdbc:mysql://localhost:3306/esprrrit";
            String login="root";
            String pwd="";
            
            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion etablie!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
    
    public static MyConnexion getInstance(){
        if(instance == null){
            instance = new MyConnexion();
        }
        return instance;
    }
    
    public Connection getConnection(){
        return cnx;
    }
    
//    public static void main(String[] args) {
//                
//            ///////////// INSERTION ////////////
//            String requete = "INSERT INTO personne (nom,prenom) VALUES ('Ben esprit','esprit')";
//            Statement st = cnx.createStatement();
////            st.executeUpdate(requete);
////            System.out.println("Personne ajoutée");
//            
//            //////////// INSERTION 2 ////////////
//            String requete2 = "INSERT INTO personne (nom,prenom) VALUES (?,?)";
//            PreparedStatement pst = cnx.prepareStatement(requete2);
//            pst.setString(1, "Dupont");
//            pst.setString(2, "Julien");
//            //pst.executeUpdate();
//            System.out.println("Personne 2 ajoutée");
//            
//            
//            /////// MODIFICATION ////////
//            String requete3 = "UPDATE personne SET nom=?,prenom=? WHERE id=?";
//            PreparedStatement pst2 = cnx.prepareStatement(requete3);
//            pst2.setInt(3, 18);
//            pst2.setString(1, "Tounsi");
//            pst2.setString(2, "Jamel");
//            pst2.executeUpdate();
//            System.out.println("Personne modifiée");
//            
//            ///////// AFFICHAGE ////////
//            String requete4 = "SELECT * FROM personne";
//            Statement st5 = cnx.createStatement();
//            ResultSet rs = st5.executeQuery(requete4);
//            System.out.println("///////////");
//            while(rs.next()){
//                System.out.println("ID: "+rs.getInt(1));
//                System.out.println("Nom: "+rs.getString(2));
//                System.out.println("Prenom: "+rs.getString("prenom"));
//                System.out.println("****");
//            }
//            
//            /////// SUPPRESSION ///////
//            String requete7 = "DELETE FROM personne WHERE id=?";
//           PreparedStatement pst7 = cnx.prepareStatement(requete7);
//           pst7.setInt(1, 18);
//           pst7.executeUpdate();
//            System.out.println("Personne supprimée");
//            
//            
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//        
//        
//        
//        
//        
//    }
}
