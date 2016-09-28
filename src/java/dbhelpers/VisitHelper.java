/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhelpers;

import dbhelpers.DBHelper;
import dbhelpers.PatientHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Doctor;
import logic.Visit;

/**
 *
 * @author Интернет
 */
public class VisitHelper extends DBHelper{
    private static VisitHelper visitHelper = new VisitHelper();
    private VisitHelper() {}
    public static VisitHelper getInstance() {
        return visitHelper;
    }
    
    public void addVisit(Visit visit) {
        Statement statement = getStatement();
        if(statement == null) {
            return;
        }
        String query = "INSERT INTO VisitsJournal"
            + "(IdPatient, IdDoctor, Date) " + "VALUES"
            + "('" + visit.getPatient().getId() + "',"
            + "'" + visit.getDoctor().getId() + "',"
            + "'" + visit.getDate() + "')";
        try {
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Failed to add " + visit.getDate());
            Logger.getLogger(PatientHelper.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }        
        String selectQuery = "SELECT Id from VisitsJournal";        
        try {
            ResultSet rs = statement.executeQuery(selectQuery);        
            int id = -1;
            while (rs.next()) {
                id = rs.getInt("Id");
            }
            if(id > 0) {
                visit.setId(id);
            }            
        } catch (SQLException ex) {
            Logger.getLogger(PatientHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateVisit(Visit visit) {
        Statement statement = getStatement();
        if(statement == null) {
            return;
        }
        String query = "UPDATE VisitsJournal SET "
            + "IdPatient = '" + visit.getPatient().getId() + "',"
            + "IdDoctor = '" + visit.getDoctor().getId() + "',"
            + "Date = '" + visit.getDate() + "'"
            + "WHERE Id = " + visit.getId();        
        try {
            statement.execute(query);
        } catch (SQLException ex) {
            System.out.println("Failed to delete " + visit.getDate());
            Logger.getLogger(PatientHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteVisit(Visit visit) {
        Statement statement = getStatement();
        if(statement == null) {
            return;
        }
        String query = "DELETE FROM VisitsJournal WHERE Id = " + visit.getId();
        try {
            statement.execute(query);
        } catch (SQLException ex) {
            System.out.println("Failed to delete " + visit.getDate());
            Logger.getLogger(PatientHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Visit> selectVisits() {
        Statement statement = getStatement();
        if(statement == null) {
            return null;
        }
        List<Visit> list = new ArrayList();
        String selectQuery = "SELECT Id, IdPatient, IdDoctor, Date from VisitsJournal";        
        try {
            ResultSet rs = statement.executeQuery(selectQuery);        
            while (rs.next()) {
                int id = rs.getInt("Id");
                int idPatient = rs.getInt("IdPatient");
                int idDoctor = rs.getInt("IdDoctor");
                String date = rs.getString("Date");
//                Doctor doctor = new Doctor(id, name, surname, spec);
//                list.add(doctor);
            }       
        } catch (SQLException ex) {
            Logger.getLogger(PatientHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
        return list;
    }
}
