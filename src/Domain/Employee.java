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
public class Employee {

    private String name;
    private String salary;
    private String phoneNumber;
    private String email;
    private String dateEMplyed;

    public Employee(String name, String salary, String phoneNumber, String email, String dateEMplyed) {

        this.name = name;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateEMplyed = dateEMplyed;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getdateEMplyed() {
        return dateEMplyed;
    }

    public void setdateEMplyed(String dateEMplyed) {
        this.dateEMplyed = dateEMplyed;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
