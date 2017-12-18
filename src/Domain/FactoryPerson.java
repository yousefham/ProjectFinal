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
public interface FactoryPerson {

    public void add(User user);

    public void add(Employee employee);

    public void delete(String type);

    public void updateEmployee(String name ,String email , String phone , String salary , String date);
    public void updateUser(User user);
    
    public void Search(String emp);

}
