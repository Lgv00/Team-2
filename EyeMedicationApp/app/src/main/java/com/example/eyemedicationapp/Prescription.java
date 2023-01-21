package com.example.eyemedicationapp;
import java.time.LocalDateTime;
public class Prescription {
    String name;
    String type;
    String capColor;
    String eye;
    double dose;
    int frequency;
    //0 will stand for ongoing
    int duration;
    int taper;
    Event event;
    LocalDateTime startDate;
    public Prescription(String newName, String newType, String newColor,  String newEye,
                        double newDose, int newFreq, int newDuration, int newTaper,
                        LocalDateTime newDateTime){
        this.name = newName;
        this.type = newType;
        this.capColor = newColor;
        this.eye = newEye;
        this.dose = newDose;
        this.frequency = newFreq; //how often
        this.duration = newDuration; //number of days
        this.taper = newTaper;
        this.startDate = newDateTime;
    }

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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

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
