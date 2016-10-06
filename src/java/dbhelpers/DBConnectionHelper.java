/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Интернет
 */
public class DBConnectionHelper {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String dbName = "jdbc:mysql://127.0.0.1:3306/hospital6";
    private static String username = "root";
    private static String password = "";
    public static Connection getDBConnection() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver was not found!");
            return null;
        }   
        Connection conn;
        try {
            conn = DriverManager.getConnection(dbName, username, password);
        } catch (SQLException ex) {
            System.out.println("DB was not found!");
            return null;
        }
        return conn;
    }
}
