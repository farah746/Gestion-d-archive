/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testproject.services;

import static edu.testproject.entities.CurrentUser.Pwd;
import static edu.testproject.entities.CurrentUser.nom;
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
    Statement ste;
    public PersonneCRUD() {
        try {
            ste = cnx.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void ajouterPersonne(Personne p){
        try {
//              String hashedpw = BCrypt.hashpw(p.getPwd(), BCrypt.gensalt(12));
            String requete = "INSERT INTO personne (Cin,nom,prenom,Adresse,Email,Genre,numeroidentifiant,poste,pwd,Role,image) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, p.getCin());
            pst.setString(2, p.getNom());
            pst.setString(3, p.getPrenom());
            pst.setString(4, p.getAdresse());
           
            pst.setString(5, p.getEmail());
            pst.setString(6, p.getGenre());
            pst.setInt(7, p.getNumeroidentifiant());
            pst.setString(8, p.getPoste());
            pst.setString(9, p.getPwd());
            pst.setString(10, p.getRole());
             pst.setString(11, p.getImage());
            pst.executeUpdate();
            System.out.println("Personne ajoutée");
          
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
     public List<Personne> displaypersonne(){
        List<Personne> myList = new ArrayList<>();
        Personne p=null;
         String requete = "SELECT Cin, nom, prenom, Adresse, Email, Genre, numeroidentifiant, poste, pwd, Role , image FROM personne";
        try {
           
          //  Statement st = c.createStatement();
            ResultSet rs = ste.executeQuery(requete);
            while(rs.next()){
                 p = new Personne();
                 p.setCin(rs.getInt("cin"));
                 p.setNom(rs.getString("nom"));
                 p.setPrenom(rs.getString("prenom"));
                 p.setAdresse(rs.getString("adresse"));
                 p.setEmail(rs.getString("email"));
                 p.setGenre(rs.getString("genre")); 
                 p.setNumeroidentifiant(rs.getInt("numeroidentifiant"));
                 p.setPoste(rs.getString("poste")); 
                 p.setPwd(rs.getString("pwd"));
                 p.setRole(rs.getString("role"));
                 p.setImage(rs.getString("image"));
                myList.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }
    
    public List<Personne> afficherPersonnes(){
         List<Personne> myList = new ArrayList<Personne>();
        try {
           
            String requete2 = "SELECT * FROM personne";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete2);
             PreparedStatement pst = cnx.prepareStatement(requete2);
            while(rs.next()){
                Personne p = new Personne();
                pst.setInt(1, p.getCin());
            pst.setString(2, p.getNom());
            pst.setString(3, p.getPrenom());
            pst.setString(4, p.getAdresse());
           
            pst.setString(5, p.getEmail());
            pst.setString(6, p.getGenre());
            pst.setInt(7, p.getNumeroidentifiant());
            pst.setString(8, p.getPoste());
            pst.setString(9, p.getPwd());
            pst.setString(10, p.getRole());
             pst.setString(11, p.getImage());
                myList.add(p);
            }
          
        } catch (SQLException ex) {
                System.err.println(ex.getMessage());
        }
        return myList;
    }
//    
    public void supprimerPersonne(Personne p){
        try {
            String requete = "DELETE FROM personne WHERE Cin=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, p.getCin());
            pst.executeUpdate();
            System.out.println("Personne supprimée");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void modifierPersonne(Personne p,int Cin){
        try {
            String requete = "UPDATE  personne SET Cin=?,nom=?,prenom=?,Adresse=?,Email=?,Genre=?,numeroidentifiant=?,poste=?,pwd=?,Role=?,image=? WHERE Cin=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
     
             pst.setInt(1,Cin);
            pst.setString(2, p.getNom());
            pst.setString(3, p.getPrenom());
            pst.setString(4, p.getAdresse());
           
            pst.setString(5, p.getEmail());
            pst.setString(6, p.getGenre());
            pst.setInt(7, p.getNumeroidentifiant());
            pst.setString(8, p.getPoste());
            pst.setString(9, p.getPwd());
            pst.setString(10, p.getRole());
             pst.setString(11, p.getImage());
            pst.executeUpdate();
            System.out.println("Personne MODIFIER");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
   
     public boolean login(String nom, String pwd) throws SQLException {
        if (!nom.isEmpty() && !pwd.isEmpty() ) {
            String req = "SELECT pwd from personne where nom = '" + nom +"'";
           
            ResultSet rs = ste.executeQuery(req);
            if (rs.next()){
            String pw = rs.getString(1);
                System.out.println(rs.getString(1));
                     return (true);}
            else return false ;
        }  
        else {
            return false;
        }

    }
    
     public Personne getUserBynom( String nom) throws SQLException { 
        String req="select * from personne where ='"+nom+"'"    ;
        PreparedStatement pst = cnx.prepareStatement(req);
    ResultSet rs = ste.executeQuery(req);
        Personne p = new Personne() ;
            if (rs.next()) {
                  p.setCin(rs.getInt("cin"));
                 p.setNom(rs.getString("nom"));
                 p.setPrenom(rs.getString("prenom"));
                 p.setAdresse(rs.getString("adresse"));
                 p.setEmail(rs.getString("email"));
                 p.setGenre(rs.getString("genre")); 
                 p.setNumeroidentifiant(rs.getInt("numeroidentifiant"));
                 p.setPoste(rs.getString("poste")); 
                 p.setPwd(rs.getString("pwd"));
                 p.setRole(rs.getString("role"));
                 p.setImage(rs.getString("image"));
               
             }   
        return p ;
        
    }

    public void ListUsers(Personne x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   public boolean existeUser (String username) throws SQLException {
        
          String req = "SELECT * from personne where nom = '" + nom +"'";
            Statement s = cnx.createStatement();
            ResultSet rs = s.executeQuery(req);
            if (rs.next()){
            
            return true ; 
            }
            
            else {
                 
                return false ;
            }
        
    } 
     public void modifierPassword(String nom , String pwd) throws SQLException {
                String hpass=BCrypt.hashpw(pwd, BCrypt.gensalt(12)) ;
        String req=" update personne set pwd='" +hpass+"'"+"where nom='"+nom+"'";
        Statement s = cnx.createStatement(); 
        s.executeUpdate(req) ; 
        
    }
}
