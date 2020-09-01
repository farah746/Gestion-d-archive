


import edu.testproject.entities.Personne;
import edu.testproject.services.PersonneCRUD;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Karray
 */
public class MyMain {
    
    public static void main(String[] args) {
     
//        System.out.println(ms1.hashCode() + " - " +ms2.hashCode());;
    
     Personne p= new Personne();
   PersonneCRUD  pcrud  =new PersonneCRUD();
   int a=1111;
       pcrud.displaypersonne();
       pcrud.supprimerPersonne( p);
    }
}
