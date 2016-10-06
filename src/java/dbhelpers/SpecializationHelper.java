/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhelpers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Doctor;

/**
 *
 * @author 1310119
 */
public class SpecializationHelper extends DBHelper {
    private static SpecializationHelper dbHelper = new SpecializationHelper();
    private SpecializationHelper() {}
    public static SpecializationHelper getInstance() {
        return dbHelper;
    }
    
    public List<String> selectSpecs() {        
        Statement statement = getStatement();
        if(statement == null) {
            return null;
        }
        List<String> list = new ArrayList();
        String selectQuery = "SELECT Name from Specialization";  
        list.add("");
        try {
            ResultSet rs = statement.executeQuery(selectQuery);        
            while (rs.next()) {                
                String name = rs.getString("Name");
                list.add(name);
            }       
        } catch (SQLException ex) {
            Logger.getLogger(PatientHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
        return list;
    }
    
}
