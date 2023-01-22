package com.example.eyemedicationapp;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.time.LocalDateTime;
import java.util.List;

@Dao
public interface EventDAO {
    @Query("SELECT * FROM event")
    List<Event> getAll();

    @Insert
    void insertAll(Event... event);

    @Delete
    void delete(Event event);

    @Query("Select * FROM event WHERE dateTime = :dateTime")
    Event getEventByDate(LocalDateTime dateTime);

    @Query("SELECT * From event ORDER By dateTime ASC")
    List<Event> getAllEventsInOrder();
}
