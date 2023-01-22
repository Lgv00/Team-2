package com.example.eyemedicationapp;

import androidx.room.Entity;

import java.util.List;

@Entity
public class User {

    List<Prescription> Meds;

    public void addPrescription(Prescription prescriptions) {
        Meds.add(prescriptions);
    }

    public void delPrescription(Prescription prescriptions){
        Meds.remove(prescriptions);
    }
}
