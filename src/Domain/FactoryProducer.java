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
public class FactoryProducer {

    public  FactoryPerson getFactory(String type) {
        if (type == null) {
            return null;
        } else if (type.equalsIgnoreCase("user")) {
            return new manageUser();
        } else if (type.equalsIgnoreCase("employee")) {
            return new manageEmployee();
        }
        return null;
    }
}
