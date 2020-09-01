/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testproject.entities;

/**
 *
 * @author Karray
 */
public class Personne {
    
    String nom;
    String prenom;
    int Cin;
    String Adresse;
    String Image;
    String Genre;
    String Email;
    String Pwd;
    String Role;
    String Poste;
    int Numeroidentifiant;
     
    public Personne() {
    }

    public Personne(String nom, String prenom, int Cin, String Adresse, String Image, String Genre, String Email, String Pwd, String Role, String Poste, int Numeroidentifiant) {
        this.nom = nom;
        this.prenom = prenom;
        this.Cin = Cin;
        this.Adresse = Adresse;
        this.Image = Image;
        this.Genre = Genre;
        this.Email = Email;
        this.Pwd = Pwd;
        this.Role = Role;
        this.Poste = Poste;
        this.Numeroidentifiant = Numeroidentifiant;
    }

    

   

    

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

  

   

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public int getCin() {
        return Cin;
    }

    public void setCin(int Cin) {
        this.Cin = Cin;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPwd() {
        return Pwd;
    }

    public void setPwd(String Pwd) {
        this.Pwd = Pwd;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getPoste() {
        return Poste;
    }

    public void setPoste(String Poste) {
        this.Poste = Poste;
    }

    public int getNumeroidentifiant() {
        return Numeroidentifiant;
    }

    public void setNumeroidentifiant(int Numeroidentifiant) {
        this.Numeroidentifiant = Numeroidentifiant;
    }

    

   

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Personne{" + "nom=" + nom + ", prenom=" + prenom + ", Cin=" + Cin + ", Adresse=" + Adresse + ", Image=" + Image + ", Genre=" + Genre + ", Email=" + Email + ", Pwd=" + Pwd + ", Role=" + Role + ", Poste=" + Poste + ", Numeroidentifiant=" + Numeroidentifiant + '}';
    }

   
    

   
    
    
    
}
