package com.example.eyemedicationapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Prescription.class, Event.class}, version = 1)
@TypeConverters({Converters.class})
public  abstract class AppDatabase extends RoomDatabase {
    public abstract PrescriptionDAO prescriptionDAO();
    public abstract EventDAO eventDAO();
    public abstract EventPrescriptionDao eventPrescriptionDao();
}
