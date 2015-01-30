package com.example.john.daiiry;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by john on 13/1/15.
 */




public class View_tickets extends Activity {

    private TextView tvDisplayDate;
    private DatePicker dpResult;
    private Button btnChangeDate;

    private int year;
    private int month;
    private int day;

    static final int DATE_DIALOG_ID = 999;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_tickets);


        Spinnertest();
        setCurrentDateOnView();
        addListenerOnButton();


    }






        public void setCurrentDateOnView() {

            tvDisplayDate = (TextView) findViewById(R.id.tvDate);
            dpResult = (DatePicker) findViewById(R.id.dpResult);

            final Calendar c = Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);

            // set current date into textview
            tvDisplayDate.setText(new StringBuilder()
                    // Month is 0 based, just add 1
                    .append(month + 1).append("-").append(day).append("-")
                    .append(year).append(" "));

            // set current date into datepicker
            dpResult.init(year, month, day, null);

        }

        public void addListenerOnButton() {

            btnChangeDate = (Button) findViewById(R.id.btnChangeDate);

            btnChangeDate.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    showDialog(DATE_DIALOG_ID);

                }

            });

        }

        @Override
        protected Dialog onCreateDialog(int id) {
            switch (id) {
                case DATE_DIALOG_ID:
                    // set date picker as current date
                    return new DatePickerDialog(this, datePickerListener,
                            year, month,day);
            }
            return null;
        }

        private DatePickerDialog.OnDateSetListener datePickerListener
                = new DatePickerDialog.OnDateSetListener() {

            // when dialog box is closed, below method will be called.
            public void onDateSet(DatePicker view, int selectedYear,
                                  int selectedMonth, int selectedDay) {
                year = selectedYear;
                month = selectedMonth;
                day = selectedDay;

                // set selected date into textview
                tvDisplayDate.setText(new StringBuilder().append(month + 1)
                        .append("-").append(day).append("-").append(year)
                        .append(" "));

                // set selected date into datepicker also
                dpResult.init(year, month, day, null);

            }
        };

    public void Spinnertest(){

         Spinner spinner = (Spinner) findViewById(R.id.status_combo);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.select_status, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }


}




