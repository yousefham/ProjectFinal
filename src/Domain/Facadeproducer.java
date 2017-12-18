/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author hp
 */
public class Facadeproducer {
    
    private FactoryPerson manageEmployee;
    private FactoryPerson manageUser;
    
    public Facadeproducer() {
        this.manageEmployee = new manageEmployee();
        this.manageUser = new manageUser();
    }
    
    public void Usermanagment(User user) {
        manageUser.add(user);
    } 
    
   
}
