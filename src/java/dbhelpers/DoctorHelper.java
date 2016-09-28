/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhelpers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Doctor;
import logic.Patient;

/**
 *
 * @author Интернет
 */
public class DoctorHelper extends DBHelper {
    private static DoctorHelper dbHelper = new DoctorHelper();
    private DoctorHelper() {}
    public static DoctorHelper getInstance() {
        return dbHelper;
    }
    
    public void addDoctor(Doctor doctor) {
        Statement statement = getStatement();
        if(statement == null) {
            return;
        }
        String query = "INSERT INTO Doctors"
            + "(Name, Surname, Specialization) " + "VALUES"
            + "('" + doctor.getName() + "',"
            + "'" + doctor.getSurname() + "',"
            + "'" + doctor.getSpecialization() + "')";
        try {
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Failed to add " + doctor.getName() + " " + doctor.getSurname());
            Logger.getLogger(PatientHelper.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }        
        String selectQuery = "SELECT Id from Doctors";        
        try {
            ResultSet rs = statement.executeQuery(selectQuery);        
            int id = -1;
            while (rs.next()) {
                id = rs.getInt("Id");
            }
            if(id > 0) {
                doctor.setId(id);
            }            
        } catch (SQLException ex) {
            Logger.getLogger(PatientHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateDoctor(Doctor doctor) {
        Statement statement = getStatement();
        if(statement == null) {
            return;
        }
        String query = "UPDATE Doctors SET "
            + "Name = '" + doctor.getName() + "',"
            + "Surname = '" + doctor.getSurname() + "',"
            + "Specialization = '" + doctor.getSpecialization() + "'"
            + "WHERE Id = " + doctor.getId();        
        try {
            statement.execute(query);
        } catch (SQLException ex) {
            System.out.println("Failed to delete " + doctor.getName() + " " + doctor.getSurname());
            Logger.getLogger(PatientHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteDoctor(Doctor doctor) {
        Statement statement = getStatement();
        if(statement == null) {
            return;
        }
        String query = "DELETE FROM Doctors WHERE Id = " + doctor.getId();
        try {
            statement.execute(query);
        } catch (SQLException ex) {
            System.out.println("Failed to delete " + doctor.getName() + " " + doctor.getSurname());
            Logger.getLogger(PatientHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Doctor> selectDoctors() {        
        Statement statement = getStatement();
        if(statement == null) {
            return null;
        }
        List<Doctor> list = new ArrayList();
        String selectQuery = "SELECT Id, Name, Surname, Specialization from Doctors";        
        try {
            ResultSet rs = statement.executeQuery(selectQuery);        
            while (rs.next()) {
                int id = rs.getInt("Id");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String spec = rs.getString("Specialization");
                Doctor doctor = new Doctor(id, name, surname, spec);
                list.add(doctor);
            }       
        } catch (SQLException ex) {
            Logger.getLogger(PatientHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
        return list;
    }
    
    
    
    
    
}
