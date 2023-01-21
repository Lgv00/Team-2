package com.example.eyemedicationapp;

public class Event {
    boolean completion;
    long dateTime;


    public Event(long dt) {
        this.completion = false;
        this.dateTime = dt;
    }

    public void toggleCompletion() {
        completion = !completion;
    }

    public boolean isCompleted() {
        return completion;
    }

    public void setCompletion(boolean completion) {
        this.completion = completion;
    }

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }
}