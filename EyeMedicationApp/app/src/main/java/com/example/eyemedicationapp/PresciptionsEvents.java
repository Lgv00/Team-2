package com.example.eyemedicationapp;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class PresciptionsEvents {
    @Embedded
    public Prescription prescription;
    @Relation(
            parentColumn = "Id",
            entityColumn = "prescriptionID"
    )
    public List<Event> event;

}
