package com.example.eyemedicationapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;
import java.util.Calendar;

public class AddActivity extends AppCompatActivity {
    String [] medication = {"Ak Poly Bac ointment", "Acetazolamide PILL", "Acular", "Acular LS", "Acuvail", "Acyclovir PILL",
            "Alamast", "Alaway", "Alcaftadine", "Alocril", "Alomide", "Alphagan P", "Alrex(shake well)", "Apraclonidine", "Artificial Tears", "Artificial Tears Preservative Free",
            "Atropine", "Avenova Lid Scrub", "Azasite", "Azelastine", "Azithromycin", "Azopt", "Bacitracin Neom. Polym. Hydrocort. ointment", "Bacitracin Polymyxin ointment", "Bausch and Lomb Tears",
            "Bepostastine", "Bepreve", "Besifloxacin", "Besivance", "Betagan", "Betaxolol", "Betimol", "Betoptic S", "Bimatoprost", "Bimatoprost/Timolol", "Bion Tears", "Bleph 10", "Blephamide", "Blephamide ointment", "Blink Tears",
            "Brimonidine", "Brimonidine/Timolol", "Brinzolamide", "Brinzolamide/Brimonidine", "BromSite", "Bromfenac", "Carteolol", "Cenegermin-bkbj", "Cequa",
            "Cetirizine", "Chloramphenicol", "Chlorsig", "Ciloxan", "Ciprofloxacin", "Cliradex Lid Scrub", "Combigan", "Cosopt", "Crolom", "Cromolyn", "Cyclogyl", "Cyclopentolate", "Cyclosporine",
            " Dexamethasone(shake well)", "Diamox"};
    String currMed, currDate, currEye, currDays, currDose;
    String [] eyeside = {"Both", "Right", "Left"};
    Integer [] day = {1, 2,3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    Integer [] dose = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
    AutoCompleteTextView autoCompleteTextView;
    AutoCompleteTextView autoCompleteTextView2;
    AutoCompleteTextView autoCompleteTextView3;
    AutoCompleteTextView autoCompleteTextView4;
    ArrayAdapter<String> adapterItems;
    ArrayAdapter<String> adapterEyes;
    ArrayAdapter<Integer> adapterDays;
    ArrayAdapter<Integer> adapterDoses;
    private DatePickerDialog datePickerDialog;
    private Button dateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodayDate());
        currDate = getTodayDate();
        Button prescriptionButton = findViewById(R.id.addPrescription);
        Button backButton = findViewById(R.id.backButton);

        autoCompleteTextView = findViewById(R.id.auto_complete_txt);
        autoCompleteTextView2 = findViewById(R.id.eye_complete_txt);
        autoCompleteTextView3 = findViewById(R.id.days_txt);
        autoCompleteTextView4 = findViewById(R.id.dose_txt);
        prescriptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("med", currMed);
                intent.putExtra("date", currDate);
                intent.putExtra("eye", currEye);
                intent.putExtra("days", currDays);
                intent.putExtra("dose", currDose);


                setResult(RESULT_OK, intent);
                finish();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                finish();
            }
        });

        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, medication);
        adapterEyes = new ArrayAdapter<String>(this, R.layout.list_item, eyeside);
        adapterDays = new ArrayAdapter<Integer>(this, R.layout.list_item, day);
        adapterDoses = new ArrayAdapter<Integer>(this, R.layout.list_item, dose);

        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView2.setAdapter(adapterEyes);
        autoCompleteTextView3.setAdapter(adapterDays);
        autoCompleteTextView4.setAdapter(adapterDoses);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                currMed = item;
                Toast.makeText(AddActivity.this, "Item: "+ item, Toast.LENGTH_SHORT).show();
            }
        });
        autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                currEye = item;
                Toast.makeText(AddActivity.this, "eyeside: "+ item, Toast.LENGTH_SHORT).show();
            }
        });
        autoCompleteTextView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                currDays = item;
                Toast.makeText(AddActivity.this, "Days: "+ item, Toast.LENGTH_SHORT).show();
            }
        });
        autoCompleteTextView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                currDose = item;
                Toast.makeText(AddActivity.this, "Doses: "+ item, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getTodayDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateToString(day, month, year);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day){
                month = month + 1;
                String date = makeDateToString(day, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
    }
    private String makeDateToString(int day, int month, int year){
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month) {
        if(month == 1)
            return "Jan";
        if(month == 2)
            return "Feb";
        if(month == 3)
            return "Mar";
        if(month == 4)
            return "Apr";
        if(month == 5)
            return "May";
        if(month == 6)
            return "Jun";
        if(month == 7)
            return "Jul";
        if(month == 8)
            return "Aug";
        if(month == 9)
            return "Sep";
        if(month == 10)
            return "Oct";
        if(month == 11)
            return "Nov";
        if(month == 12)
            return "Dec";
        else
            return "Jan";
    }
    public void openDatePicker(View view) {
        datePickerDialog.show();
    }
}
