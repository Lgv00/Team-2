package com.example.eyemedicationapp;

import androidx.room.Dao;
//import androidx.room.Embedded;
import androidx.room.Query;
//import androidx.room.Relation;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface PrescriptionsEventsDAO {
    /*@Embedded public Prescription prescription;
    @Relation(
            parentColumn = "Id",
            entityColumn = "prescriptionID"
    )
    public List<Event> event;*/

    @Transaction
    @Query("SELECT * FROM Prescription")
    public List<Event> get();
}