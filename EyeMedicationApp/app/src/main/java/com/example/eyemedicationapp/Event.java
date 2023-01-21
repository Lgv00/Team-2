package com.example.eyemedicationapp;
import androidx.annotation.NonNull;

import java.sql.Array;
import java.time.LocalDateTime;

public class Event {
    boolean completion;
    LocalDateTime dateTime;
    Prescription prescription;


    public Event(Prescription p) {
        this.prescription = p;
        this.completion = false;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public static int[] defaultAlarm(int interval) {
        int startTime = 0;
        //0 assumes midnight;
        switch (interval) {
            case 1:
                return new int[]{1200};

            case 2:
                return new int[]{480, 1200};
            case 3:
                return new int[]{480, 840, 1200};
            case 4:
                return new int[]{480, 750, 1020, 1290};
            case 5:
                return new int[]{480, 660, 840, 1020, 1200};
            case 6:
                return new int[]{480, 630, 780, 870, 1080, 1230};
            case 7:
                return new int[]{480, 600, 720, 840, 960, 1080, 1200};
            case 8:
                return new int[]{480, 600, 720, 840, 960, 1080, 1200, 1320};
            case 9:
                return new int[]{480, 570, 660, 750, 840, 930, 1020, 1110, 1200};
            case 10:
                return new int[]{480, 570, 660, 750, 840, 930, 1020, 1110, 1200, 1290};
            case 11:
                return new int[]{480, 540, 600, 660, 720, 780, 840, 900, 960, 1020, 1080};
            case 12:
                return new int[]{480, 540, 600, 660, 720, 780, 840, 900, 960, 1020,
                        1080, 1140};
            case 13:
                return new int[]{480, 540, 600, 660, 720, 780, 840, 900, 960, 1020,
                        1080, 1140, 1200};
            case 14:
                return new int[]{480, 540, 600, 660, 720, 780, 840, 900, 960, 1020,
                        1080, 1140, 1200, 1260};
            case 15:
                return new int[]{480, 540, 600, 660, 720, 780, 840, 900, 960, 1020,
                        1080, 1140, 1200, 1260, 1320};
            case 16:
                return new int[]{480, 540, 600, 660, 720, 780, 840, 900, 960, 1020,
                        1080, 1140, 1200, 1260, 1320, 1380};
            case 17:
                return new int[]{420, 480, 540, 600, 660, 720, 780, 840, 900, 960,
                        1020, 1080, 1140, 1200, 1260, 1320, 1380};
            case 18:
                return new int[]{360, 420, 480, 540, 600, 660, 720, 780, 840, 900,
                        960, 1020, 1080, 1140, 1200, 1260, 1320, 1380};
            case 19:
                return new int[]{0, 360, 420, 480, 540, 600, 660, 720, 780, 840, 900,
                        960, 1020, 1080, 1140, 1200, 1260, 1320, 1380};
            case 20:
                return new int[]{0, 60, 360, 420, 480, 540, 600, 660, 720, 780, 840,
                        900, 960, 1020, 1080, 1140, 1200, 1260, 1320, 1380};
            case 21:
                return new int[]{0, 60, 300, 360, 420, 480, 540, 600, 660, 720, 780,
                        840, 900, 960, 1020, 1080, 1140, 1200, 1260, 1320, 1380};
            case 22:
                return new int[]{0, 60, 120, 300, 360, 420, 480, 540, 600, 660, 720,
                        780, 840, 900, 960, 1020, 1080, 1140, 1200, 1260, 1320, 1380};
            case 23:
                return new int[]{0, 60, 120, 180, 300, 360, 420, 480, 540, 600, 660,
                        720, 780, 840, 900, 960, 1020, 1080, 1140, 1200, 1260,
                        1320, 1380};
            case 24:
                return new int[]{0, 60, 120, 180, 240, 300, 360, 420, 480, 540, 600,
                        660, 720, 780, 840, 900, 960, 1020, 1080, 1140, 1200,
                        1260, 1320, 1380};
        }
        return new int []{0};
    }
    @NonNull
    public String toString(){
        return this.prescription.name + " " + this.dateTime.toString();
    }

}