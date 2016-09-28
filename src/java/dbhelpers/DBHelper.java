/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhelpers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Интернет
 */
public class DBHelper {
    protected Statement getStatement() {
        Connection conn = DBConnectionHelper.getDBConnection();
        if(conn == null) {
            System.out.println("Failed to connect to DB!");
            return null;
        }
        Statement statement;
        try {
            statement = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("Failed to create insert statement!");
            return null;
        }
        return statement;
    }
}
