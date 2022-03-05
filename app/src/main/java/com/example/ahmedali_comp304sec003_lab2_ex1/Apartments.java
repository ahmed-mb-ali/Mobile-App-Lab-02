package com.example.ahmedali_comp304sec003_lab2_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Apartments extends AppCompatActivity {

    //Declare the views
    Button buttonNext;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartments);

        //Set up references to GUI view
        buttonNext = (Button) findViewById(R.id.buttonAptNext);

        Button button = findViewById(R.id.buttonAptNext);

    }

    public void next_apartment_event(View view) {

        //Checkbox SharedPreferences
         CheckBox phy_first_Apt_CB = findViewById(R.id.checkBoxAptPChbx1);
         CheckBox vir_first_Apt_CB =findViewById(R.id.checkBoxAptVChbx1);

         CheckBox phy_second_Apt_CB = findViewById(R.id.checkBoxAptPChbx2);
         CheckBox vir_second_Apt_CB =findViewById(R.id.checkBoxAptVChbx2);

         CheckBox phy_third_Apt_CB = findViewById(R.id.checkBoxAptPChbx3 );
         CheckBox vir_third_Apt_CB =findViewById(R.id.checkBoxAptVChbx3  );


        SharedPreferences sp = getSharedPreferences(" phy_first_apt", Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = sp.edit();

        if (view.getId() == R.id.buttonAptNext) {
            if(phy_first_Apt_CB.isChecked()) {
                prefEditor.putString("apt_01_phy","checked");
            }
            if(vir_first_Apt_CB.isChecked()) {
                prefEditor.putString("apt_01_vir","checked");
            }
            if(phy_second_Apt_CB.isChecked()) {
                prefEditor.putString("apt_02_phy","checked");
            }
            if(vir_second_Apt_CB.isChecked()) {
                prefEditor.putString("apt_02_vir","checked");
            }
            if(phy_third_Apt_CB.isChecked()) {
                prefEditor.putString("apt_03_phy","checked");
            }
            if(vir_third_Apt_CB.isChecked()) {
                prefEditor.putString("apt_03_vir","checked");
            }


            intent = new Intent(Apartments.this, CheckOut.class);
            //starts the new activity
            startActivity(intent);
        }

    }

}

