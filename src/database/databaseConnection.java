/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author hp
 */
public class databaseConnection {

    private static Connection INSTANCE;
    private static Connection connection;
    private Statement state;
    private PreparedStatement prsteate;
    private ResultSet resultSet;

    public static Connection getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = getcon();
        }
        return INSTANCE; 
        
    }

    private static Connection getcon() {
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/sdaproject?"
                            + "user=root&password=");
        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }
        return connection;
    }

}
