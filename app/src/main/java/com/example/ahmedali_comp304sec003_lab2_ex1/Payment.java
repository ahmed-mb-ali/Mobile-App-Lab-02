package com.example.ahmedali_comp304sec003_lab2_ex1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.ArrayList;

public class Payment extends AppCompatActivity {

    //Declare variables
    EditText editText;
    DatePickerDialog picker;
    EditText datePicker;
    ArrayList<Boolean> radioBtnsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        //Initialize radioBtnsArray
        radioBtnsArray = new ArrayList<Boolean>();

        //Retrieve data from Checkout activity
        radioBtnsArray = (ArrayList<Boolean>) getIntent().getSerializableExtra("isChecked");

        //Inspect the retrieved data and perform actions accordingly
        if(radioBtnsArray.get(0) == true){
            setContentView(R.layout.cash_payment);
        }else if(radioBtnsArray.get(1) == true){
            setContentView(R.layout.debit_payment);
        }else if(radioBtnsArray.get(2) == true){
            setContentView(R.layout.credit_payment);
        }


        //if xml file in not layout, initialize datepicker variable
        if(radioBtnsArray.get(0) != true) {
            datePicker = (EditText) findViewById(R.id.editTextInsertDate);
            datePicker.setInputType(InputType.TYPE_NULL);
            datePicker.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onClick(View v) {
                    final Calendar cldr = Calendar.getInstance();
                    int day = cldr.get(Calendar.DAY_OF_MONTH);
                    int month = cldr.get(Calendar.MONTH);
                    int year = cldr.get(Calendar.YEAR);
                    // date picker dialog
                    picker = new DatePickerDialog(Payment.this,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                    datePicker.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                                }
                            }, year, month, day);
                    picker.show();
                }
            });
        }
    }

   public void onClickPay(View view){

       editText = (EditText)findViewById(R.id.editTextTxtCardName);

        //Get ids' values
        SharedPreferences myPreference =
                getSharedPreferences("MyGoodMemory", 0);
        //prepare it for edit by creating and Edit object
        SharedPreferences.Editor prefEditor = myPreference.edit();
        //store a string in memory
        prefEditor.putString("OurString", editText.getText().toString());
        //commit the transaction
        prefEditor.commit();

        Intent intent = new Intent(this, FinalOrder.class);
        startActivity(intent);
   }
}