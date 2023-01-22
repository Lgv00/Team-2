package com.example.eyemedicationapp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Schedule{
    ArrayList<Prescription> prescriptionList;
    ArrayList<Event> eventList = new ArrayList<>();
    HashSet <LocalDateTime> usedTimes = new HashSet<>();
    int dropBuffer = 5;
    public Schedule(){
        prescriptionList = new ArrayList<>();
    }

   public void addPrescription(Prescription a){
        prescriptionList.add(a);
        for(int j = 0; j < a.duration; j++) {
            LocalDateTime current = a.startDate.plusDays(j);
            int [] hourOffsets = Event.defaultAlarm(a.frequency);
            for (int hourOffset : hourOffsets) {
                Event event = new Event(a);
                LocalDateTime currentEventTime = current.plusMinutes(hourOffset);
                while(usedTimes.contains(currentEventTime)){
                    currentEventTime = currentEventTime.plusMinutes(dropBuffer);
                }
                usedTimes.add(currentEventTime);
                event.setDateTime(currentEventTime);
                eventList.add(event);
            }
        }
        eventList.sort(new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return o1.dateTime.compareTo(o2.dateTime);
            }
        });
    }

    public boolean isDayComplete() {
        LocalDateTime today = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS);
        boolean dayIsComplete = true;
        for (int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i).getDateTime().truncatedTo(ChronoUnit.DAYS).equals(today)){
                dayIsComplete = dayIsComplete && eventList.get(i).completion;
                if(!dayIsComplete){
                    break;
                }
            }
        }
        return dayIsComplete;
    }
    public void updateBuffer(int newNum) {
        dropBuffer = newNum;
    }

    public static Schedule getDummySchedule(){
        Schedule s = new Schedule();
        s.addPrescription(new Prescription( "Acular", "Eyedrop", "Grey", "Both", 0.0, 2, 3, 0,LocalDateTime.now().truncatedTo(ChronoUnit.DAYS)));
        s.addPrescription(new Prescription("Atropine", "Eyedrop", "Red", "Both", 0.0, 3, 2, 0,LocalDateTime.now().plusDays(1).truncatedTo(ChronoUnit.DAYS)));
        return s;
    }

}
