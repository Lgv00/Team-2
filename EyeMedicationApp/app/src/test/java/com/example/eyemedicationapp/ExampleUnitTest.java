package com.example.eyemedicationapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        Schedule schedule = Schedule.getDummySchedule();
        boolean done = schedule.isDayComplete();
        schedule.eventList.get(0).completion = true;
        schedule.eventList.get(1).completion = true;
        boolean done2 = schedule.isDayComplete();
    }
}