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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class manageEmployee implements FactoryPerson {

    database.databaseConnection db;
    private Connection connection;
    private Statement state;
    private PreparedStatement prsteate;
    private ResultSet resultSet;
    private ResultSetMetaData meta;

    private String name_emp;
    private String email_emp;
    private String phone_emp;
    private String salary_emp;
    private String date_emp;

    @Override
    public void add(User user) {

        //do nothing 
    }

    @Override
    public void add(Employee employee) {

        try {
            connection = databaseConnection.getINSTANCE();
            String query = "INSERT INTO employees (emp_name,email,emp_phNumber,emp_salary,date_Of_Emp_Addi) "
                    + "VALUES(?,?,?,?,?)";
            prsteate = connection.prepareStatement(query);
            prsteate.setString(1, employee.getName());
            prsteate.setString(2, employee.getEmail());
            prsteate.setString(3, employee.getPhoneNumber());
            prsteate.setString(4, employee.getSalary());
            prsteate.setString(5, employee.getdateEMplyed());
            prsteate.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("SQLException::" + ex);
        }

    }

    public List<Employee> getAllEmployee() throws Exception {
        List<Employee> employees = new ArrayList<>();
        connection = databaseConnection.getINSTANCE();
        String query = "SELECT * From employees";
        prsteate = connection.prepareStatement(query);
        resultSet = prsteate.executeQuery();
        while (resultSet.next()) {
            int _id = resultSet.getInt("_id");
            String EmpName = resultSet.getString("emp_name");
            String EmpEmail = resultSet.getString("email");
            String EmpPhoneNumber = resultSet.getString("emp_phNumber");
            String EmpSalary = resultSet.getString("emp_salary");
            String EmpDate = resultSet.getString("date_Of_Emp_Addi");
            Employee emp = new Employee(EmpName, EmpSalary, EmpPhoneNumber, EmpEmail, EmpDate);
            employees.add(emp);
        }
        return employees;
    }

    public JTable fillTheTebleModel(JTable table) throws Exception {

        connection = databaseConnection.getINSTANCE();

        String query = "SELECT * From employees";
        prsteate = connection.prepareStatement(query);
        resultSet = prsteate.executeQuery();
        String data[][] = new String[60][5];
        DefaultTableModel model = (DefaultTableModel) table.getModel(); //new DefaultTableModel();
        int i = 0;
        while (resultSet.next()) {
            data[i][0] = resultSet.getString("emp_name");
            data[i][1] = resultSet.getString("email");
            data[i][2] = resultSet.getString("emp_phNumber");
            data[i][3] = resultSet.getString("emp_salary");
            data[i][4] = resultSet.getString("date_Of_Emp_Addi");
            i++;
        }
        String[] columnNames = {"ID",
            "Name",
            "Email",
            "Phone Number",
            "Salary",
            "date_Of_Emp_Addi"};

        model.addRow(data);
        table.setModel(model);

//        while (resultSet.next()) {
//            System.out.println("IN");
//            int _id = resultSet.getInt("_id");
//            String EmpName = resultSet.getString("emp_name");
//            String EmpEmail = resultSet.getString("email");
//            String EmpPhoneNumber = resultSet.getString("emp_phNumber");
//            String EmpSalary = resultSet.getString("emp_salary");
//            String EmpDate = resultSet.getString("date_Of_Emp_Addi");
//            // model.addRow(new Object[]{_id, EmpName, EmpEmail, EmpPhoneNumber, EmpSalary, EmpDate});
//
//            model.insertRow(table.getRowCount(), new Object[]{_id, EmpName, EmpEmail, EmpPhoneNumber, EmpSalary, EmpDate});
//        }
//        System.out.println(model.getDataVector());
        return table;
    }

    @Override
    public void updateEmployee(String name, String email, String phone, String salary, String date) {
        try {
            connection = databaseConnection.getINSTANCE();
            String q = "UPDATE employees SET  email=?,"
                    + "emp_phNumber =?,"
                    + "emp_salary =?,"
                    + "date_Of_Emp_Addi =?"
                    + "Where emp_name = ? ;";

            prsteate = connection.prepareStatement(q);

            prsteate.setString(1, email);
            prsteate.setString(2, phone);
            prsteate.setString(3, salary);
            prsteate.setString(4, date);
            prsteate.setString(5, name);
            prsteate.execute();

        } catch (SQLException e) {
            System.out.println("Exception" + e);
        }
    }

    @Override
    public void delete(String type) {
        try {
            int Replay = JOptionPane.showConfirmDialog(null, "Are you shour!");
            if (Replay == JOptionPane.YES_OPTION) {
                connection = databaseConnection.getINSTANCE();
                String query = "DELETE FROM employees where emp_name=?" ;
                prsteate = connection.prepareStatement(query);
                prsteate.setString(1, type);
                prsteate.executeUpdate();
                System.out.println(type);
            } else if (Replay == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, " إنت حر !");
            }

        } catch (SQLException ex) {
            Logger.getLogger(manageEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Search(String type) {

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

    public String getEmail_emp() {
        return email_emp;
    }

    public String getPhone_emp() {
        return phone_emp;
    }

    public String getSalary_emp() {
        return salary_emp;
    }

    public String getDate_emp() {
        return date_emp;
    }

    public void getSalary(){
        
    }
}
