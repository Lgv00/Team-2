package com.example.eyemedicationapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PrescriptionDAO {
    @Query("SELECT * FROM prescription")
    List<Prescription> getAll();

    @Query("SELECT * FROM prescription WHERE name = :name")
    Prescription getByName(String name);
    @Insert
    void insertAll(Prescription... prescription);

    @Insert
    long insert(Prescription prescription);
    @Delete
    void delete(Prescription prescription);

}
