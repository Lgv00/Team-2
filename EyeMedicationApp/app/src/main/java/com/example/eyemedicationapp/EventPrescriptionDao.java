package com.example.eyemedicationapp;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EventPrescriptionDao {
    @Query("SELECT event.id as eventId, event.dateTime as dateTime, prescription.Name as prescriptionName, prescription.Eye as targetEye "+
            "FROM event, prescription " +
            "WHERE event.prescriptionID = prescription.id " +
            "ORDER BY dateTime ASC")
    public List<EventPrescription> loadEventsAndPrescriptions();
}
