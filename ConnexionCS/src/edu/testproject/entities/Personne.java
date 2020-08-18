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
    int id;
    String nom;
    String prenom;
    String Cin;
    String Adresse;
     String Image;
    public Personne() {
    }

    public Personne(int id, String nom, String prenom, String Cin, String Adresse, String Image) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.Cin = Cin;
        this.Adresse = Adresse;
        this.Image = Image;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

  

    public String getCin() {
        return Cin;
    }

    public void setCin(String Cin) {
        this.Cin = Cin;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Personne{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", Cin=" + Cin + ", Adresse=" + Adresse + ", Image=" + Image + '}';
    }

   
    
    
    
}
