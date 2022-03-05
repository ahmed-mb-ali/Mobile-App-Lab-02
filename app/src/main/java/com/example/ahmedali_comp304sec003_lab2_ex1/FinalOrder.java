package com.example.ahmedali_comp304sec003_lab2_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class FinalOrder extends AppCompatActivity {
    //Declare variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_order);

        //retrieving from shared preferences
        SharedPreferences myPref = getSharedPreferences("MyGoodMemory", MODE_PRIVATE);
        String myString = myPref.getString("OurString","");
        TextView tView = (TextView)findViewById(R.id.textViewFinalOrder);
        //tView.setText("Thank you + myString for your purchase! We would love to see you again!);
        tView.setText(getString(R.string.SetThankYou1)+  myString  +getString(R.string.SetThankYou2));

    }
}