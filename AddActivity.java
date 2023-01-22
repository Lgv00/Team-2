package com.example.eyedoc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
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
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    private DatePickerDialog datePickerDialog;
    private Button dateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysdate());
        
        autoCompleteTextView = findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, medication);
        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(AddActivity.this, "Item: "+ item, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private String getTodaysdate() {
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
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";
        else
            return "JAN";
    }
    public void openDatePicker(View view) {
        datePickerDialog.show();
    }
}