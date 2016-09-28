/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.sql.Date;


/**
 *
 * @author Интернет
 */
public class Patient {
    private int id;
    private String name;
    private String surname;
    private String dob;
    private String address;
    private String diagnosis;

    public Patient(int id, String name, String surname, String dob, String address, String diagnosis) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.address = address;
        this.diagnosis = diagnosis;
    }
    
    public Patient(String name, String surname, String dob, String address, String diagnosis) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.address = address;
        this.diagnosis = diagnosis;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return name + surname;
    }

    
    
    
    
    
}
