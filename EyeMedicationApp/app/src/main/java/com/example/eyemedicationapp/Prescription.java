package com.example.eyemedicationapp;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;
@Entity
public class Prescription {
    @PrimaryKey(autoGenerate = true)
    long id;
    @ColumnInfo(name = "Name")
    String name;
    @ColumnInfo(name = "Type")
    String type;
    @ColumnInfo(name = "Cap_color")
    String capColor;
    @ColumnInfo(name = "Eye")
    String eye;
    @ColumnInfo(name = "Dose")
    double dose;
    @ColumnInfo(name = "Frequency")
    int frequency;
    @ColumnInfo(name = "Duration")
    //0 will stand for ongoing
    int duration;
    @ColumnInfo(name = "Taper")
    int taper;
    //@ColumnInfo(name = "Completion") @ColumnInfo(name = "Date_Time")
    //Event event;

    //@ColumnInfo(name = "Start_time")
    LocalDateTime startDate;

    public Prescription(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapColor() {
        return capColor;
    }

    public void setCapColor(String capColor) {
        this.capColor = capColor;
    }

    public double getDose() {
        return dose;
    }

    public void setDose(double dose) {
        this.dose = dose;
    }

    public String getEye() {
        return eye;
    }

    public void setEye(String eye) {
        this.eye = eye;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getDuration() {
        return duration;
    }

//    public Event getEvent() {
//        return event;
//    }
//
//    public void setEvent(Event event) {
//        this.event = event;
//    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getTaper() {
        return taper;
    }

    public void setTaper(int taper) {
        this.taper = taper;
    }
}
