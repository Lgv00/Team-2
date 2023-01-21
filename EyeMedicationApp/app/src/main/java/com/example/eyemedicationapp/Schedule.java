package com.example.eyemedicationapp;
import java.util.ArrayList;
public class Schedule {
    ArrayList<Prescription> prescriptionList;
    ArrayList<Event> eventList = new ArrayList<Event>();

    public Schedule(){
        prescriptionList = new ArrayList<Prescription>();
    }

   /* public void addPrescription(Prescription a){
        prescriptionList.add(a);
        for (int i = 0; i < a.frequency; i++){
            Event event = new Event(a,);
        }
    }*/

    public boolean isDayComplete(Event a) {
        boolean completion;
        for (int i = 0; i < prescriptionList.size(); i++){
            if(!prescriptionList.get(i).event.isCompleted()){
                return false;
            }
        }
        return true;
    }

    /*public static Schedule getDummySchedule(){
        Schedule s = new Schedule();
        s.addPrescription("Acular", "Eyedrop", "Grey", "Both", 0.0, 4, 14, 0, );
        s.addPrescription("Atropine", "Eyedrop", "Red", "Both", 0.0, 3, 7, 0, );
        s.addPrescription("Brimonidine","Eyedrop", "Purple", "Left", 0.0, 0, 3, 0, );
        s.addPrescription("Levobunolol","Eyedrop", "Yellow", "Right", 0.0, 0, 2, 0, );
        s.addPrescription("Muro 128 Ointment ", "Eyedrop", "Gray", " Both", 0.0, 0, 1, 0, );
        s.addPrescription("Nepafenac","Eyedrop", "Light Gray", "Both", 0.0, 1, 14, 0, );
        s.addPrescription("Omnipred (shake well)", "Eyedrop", "Pink", "Left", 0.0, 4, 28, 0, );
        s.addPrescription("Pred-G ointment", "Eyedrop", "Gray", "Left", 0.0, 1, 7, 0, );
        s.addPrescription("Refresh Tears", "Eyedrop", "Green", "Both", 0.0, 4, 0, 0, );
        s.addPrescription("Tafluprost", "Eyedrop", "Teal", "Right", 0.0, 1, 0, 0, );
        s.addPrescription("Zerviate", "Eyedrop", "White", "Right", 0.0, 2, 0, 0, );
        return s;
    }*/

}
