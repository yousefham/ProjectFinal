/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import GUISwing.SignIN;
import GUISwing.secondmain;
import database.databaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class manageUser implements FactoryPerson {

    database.databaseConnection db;
    private Connection connection;
    private Statement state;
    private PreparedStatement prsteate;
    private ResultSet resultSet;

    @Override
    public void add(User user) {
        try {
            connection = databaseConnection.getINSTANCE();
            String query = "INSERT INTO user (username,password,phonenumber) VALUES(?,?,?) ";
            prsteate = connection.prepareStatement(query);
            prsteate.setString(1, user.getName());
            prsteate.setString(2, user.getPassword());
            prsteate.setString(3, user.getPhoneNumber());
            // prsteate.setDate(4, user.getCurrentdate());
            prsteate.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(manageUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void add(Employee employee) {
        //do nothing 
    }

    @Override
    public void delete(String type) {

    }

    public List<User> getAllUsers() throws Exception {
        List<User> user = new ArrayList<>();
        String query = "SELECT * From user";
        connection = databaseConnection.getINSTANCE();
        prsteate = connection.prepareStatement(query);
        resultSet = prsteate.executeQuery();
        while (resultSet.next()) {
            int _id = resultSet.getInt("_id");
            String name = resultSet.getString("username");
            String password = resultSet.getString("password");
            String phoneNumber = resultSet.getString("phonenumber");
            User u = new User(name, password, phoneNumber);
            user.add(u);
        }

        return user;
    }

    public User getuser(String username, String Password) throws Exception {
        User user;
        String query = "SELECT * From user where username = '" + username + "' and password = '" + Password + "' limit 1";
        connection = databaseConnection.getINSTANCE();
        prsteate = connection.prepareStatement(query);
        resultSet = prsteate.executeQuery();
        while (resultSet.next()) {
            int _id = resultSet.getInt("_id");
            String name = resultSet.getString("username");
            String password = resultSet.getString("password");
            String phoneNumber = resultSet.getString("phonenumber");
            user = new User(name, password, phoneNumber);
            return user;
        }

        return null;
    }

    public void login(String username, String Password) throws Exception {
        User user = getuser(username, Password);
        if (user == null) {

            JOptionPane.showMessageDialog(null, "username or/and password is not correct", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println("Login successfully");
            SignIN sign = new SignIN();
            sign.setVisible(false);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    secondmain main = new secondmain();
                    main.setVisible(true);

                }
            }).start();

        }

    }
    @Override
    public void updateUser(User user) {

    }

    @Override
    public void updateEmployee(String name, String email, String phone, String salary, String date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Search(String emp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
