/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import database.databaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yousef
 */
public class byName implements SearchStrategy {

    private Connection connection;
    private Statement state;
    private PreparedStatement prsteate;
    private ResultSet resultSet;
    private String name_emp;
    private String email_emp;
    private String phone_emp;
    private String salary_emp;
    private String date_emp;

    @Override
    public void search(String type) {
        try {
            connection = databaseConnection.getINSTANCE();
            prsteate = connection.prepareStatement("SELECT * From employees where emp_name=? ||emp_phNumber=?");
            prsteate.setString(1, type);
            prsteate.setString(2, type);
            resultSet = prsteate.executeQuery();
            while (resultSet.next()) {
                this.name_emp = resultSet.getString("emp_name");
                this.email_emp = resultSet.getString("email");
                this.phone_emp = resultSet.getString("emp_phNumber");
                this.salary_emp = resultSet.getString("emp_salary");
                this.date_emp = resultSet.getString("date_Of_Emp_Addi");
            }

        } catch (SQLException ex) {
            Logger.getLogger(manageEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getName_emp() {
        return name_emp;
    }

    public void setName_emp(String name_emp) {
        this.name_emp = name_emp;
    }

    public String getEmail_emp() {
        return email_emp;
    }

    public void setEmail_emp(String email_emp) {
        this.email_emp = email_emp;
    }

    public String getPhone_emp() {
        return phone_emp;
    }

    public void setPhone_emp(String phone_emp) {
        this.phone_emp = phone_emp;
    }

    public String getSalary_emp() {
        return salary_emp;
    }

    public void setSalary_emp(String salary_emp) {
        this.salary_emp = salary_emp;
    }

    public String getDate_emp() {
        return date_emp;
    }

    public void setDate_emp(String date_emp) {
        this.date_emp = date_emp;
    }

}
