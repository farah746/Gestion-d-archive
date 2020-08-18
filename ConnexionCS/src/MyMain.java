

import edu.testproject.services.CRUDPersonne;
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
//        MyService ms1 = MyService.getInstance();
//        MyService ms2 = MyService.getInstance();
//        
//        System.out.println(ms1.hashCode() + " - " +ms2.hashCode());;
    
        CRUDPersonne myTool = new CRUDPersonne();
        System.out.println(myTool.listerPersonnes());
    }
}
