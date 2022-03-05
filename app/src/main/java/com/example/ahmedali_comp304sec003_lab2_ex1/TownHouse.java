package com.example.ahmedali_comp304sec003_lab2_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class TownHouse extends AppCompatActivity {
    //Declare the views
    Intent intent;
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_town_house);

        //Set up references to GUI view
        buttonNext = (Button) findViewById(R.id.buttonTownHouseNext);
    }

    public void next_TownHouse_event(View view)
    {
        //Checkbox SharedPreferences
        CheckBox phy_first_townHouse_CB = findViewById(R.id.checkBoxTownHousePChbx1);
        CheckBox vir_first_townHouse_CB =findViewById(R.id.checkBoxTownHouseVChbx1);

        CheckBox phy_second_townHouse_CB = findViewById(R.id.checkBoxTownHousePChbx2);
        CheckBox vir_second_townHouse_CB =findViewById(R.id.checkBoxTownHouseVChbx2);

        CheckBox phy_third_townHouse_CB = findViewById(R.id.checkBoxTownHousePChbx3);
        CheckBox vir_third_townHouse_CB =findViewById(R.id.checkBoxTownHouseVChbx3);


        SharedPreferences sp = getSharedPreferences(" phy_first_apt", Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = sp.edit();

        if (view.getId() == R.id.buttonCondoNext) {
            if(phy_first_townHouse_CB.isChecked()) {
                prefEditor.putString("townHouse_01_phy","checked");
            }
            if(vir_first_townHouse_CB.isChecked()) {
                prefEditor.putString("townHouse_01_vir","checked");
            }
            if(phy_second_townHouse_CB.isChecked()) {
                prefEditor.putString("townHouse_02_phy","checked");
            }
            if(vir_second_townHouse_CB.isChecked()) {
                prefEditor.putString("townHouse_02_vir","checked");
            }
            if(phy_third_townHouse_CB.isChecked()) {
                prefEditor.putString("townHouse_03_phy","checked");
            }
            if(vir_third_townHouse_CB.isChecked()) {
                prefEditor.putString("townHouse_03_vir","checked");
            }

            intent = new Intent(TownHouse.this, CheckOut.class);
            //starts the new activity
            startActivity(intent);
        }

    }

}