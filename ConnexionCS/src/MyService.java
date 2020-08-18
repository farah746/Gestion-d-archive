/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Karray
 */
public class MyService {

    public static MyService instance;
    private MyService() {
    }
    
    public static MyService getInstance(){
        if(instance == null){
            instance = new MyService();
        }
        return instance;
    }
    
    public void lire(){
        System.out.println("Lire bouquin");
    }
    
    public void manger(){
        System.out.println("Manger petit dej");
    }
    
}
