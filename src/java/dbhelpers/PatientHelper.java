/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhelpers;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Patient;

/**
 *
 * @author Интернет
 */
public class PatientHelper extends DBHelper {
    private static PatientHelper dbHelper = new PatientHelper();
    private PatientHelper() {}
    public static PatientHelper getInstance() {
        return dbHelper;
    }  
    
    public void addPatient(Patient patient) {
        Statement statement = getStatement();
        if(statement == null) {
            return;
        }
        String query = "INSERT INTO RegistrationCards"
            + "(Name, Surname, DOB, Address, Diagnosis) " + "VALUES"
            + "('" + patient.getName() + "',"
            + "'" + patient.getSurname() + "',"
            + "'" + patient.getDob() + "',"
            + "'" + patient.getAddress() + "',"
            + "'" + patient.getDiagnosis() + "')";        

        try {
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Failed to add " + patient.getName() + " " + patient.getSurname());
            Logger.getLogger(PatientHelper.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }        
        String selectQuery = "SELECT Id from RegistrationCards";        
        try {
            ResultSet rs = statement.executeQuery(selectQuery);        
            int id = -1;
            while (rs.next()) {
                id = rs.getInt("Id");
            }
            if(id > 0) {
                patient.setId(id);
            }            
        } catch (SQLException ex) {
            Logger.getLogger(PatientHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    
    
    public void updatePatient(Patient patient) {
        Statement statement = getStatement();
        if(statement == null) {
            return;
        }
        String query = "UPDATE RegistrationCards SET "
            + "Name = '" + patient.getName() + "',"
            + "Surname = '" + patient.getSurname() + "',"
            + "DOB = '" + patient.getDob() + "',"
            + "Address = '" + patient.getAddress() + "',"
            + "Diagnosis = '" + patient.getDiagnosis() + "'"
            + "WHERE Id = " + patient.getId();        
        try {
            statement.execute(query);
        } catch (SQLException ex) {
            System.out.println("Failed to delete " + patient.getName() + " " + patient.getSurname());
            Logger.getLogger(PatientHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletePatient(Patient patient) {
        Statement statement = getStatement();
        if(statement == null) {
            return;
        }
        String query = "DELETE FROM RegistrationCards WHERE Id = " + patient.getId();
        try {
            statement.execute(query);
        } catch (SQLException ex) {
            System.out.println("Failed to delete " + patient.getName() + " " + patient.getSurname());
            Logger.getLogger(PatientHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Patient> selectPatients() {        
        Statement statement = getStatement();
        if(statement == null) {
            return null;
        }
        List<Patient> list = new ArrayList();
        String selectQuery = "SELECT Id, Name, Surname, DOB, Address, Diagnosis from RegistrationCards";        
        try {
            ResultSet rs = statement.executeQuery(selectQuery);        
            while (rs.next()) {
                int id = rs.getInt("Id");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String dob = rs.getString("DOB");
                String address = rs.getString("Address");
                String diagnosis = rs.getString("Diagnosis");
                Patient patient = new Patient(id, name, surname, dob, address, diagnosis);
                list.add(patient);
            }       
        } catch (SQLException ex) {
            Logger.getLogger(PatientHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
        return list;
    }
    
    
    
    
}
