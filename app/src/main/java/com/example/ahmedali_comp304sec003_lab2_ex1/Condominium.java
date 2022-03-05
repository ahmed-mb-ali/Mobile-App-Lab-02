package com.example.ahmedali_comp304sec003_lab2_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Condominium extends AppCompatActivity {
    //Declare the views
    Intent intent;
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condominium);

        //Set up references to GUI view
        buttonNext = (Button) findViewById(R.id.buttonCondoNext);
    }

    public void next_condo_event(View view)
    {
        //Checkbox SharedPreferences
        CheckBox phy_first_Condo_CB = findViewById(R.id.checkBoxCondoPChbx1);
        CheckBox vir_first_Condo_CB =findViewById(R.id.checkBoxCondoVChbx1);

        CheckBox phy_second_Condo_CB = findViewById(R.id.checkBoxCondoPChbx2);
        CheckBox vir_second_Condo_CB =findViewById(R.id.checkBoxCondoVChbx2);

        CheckBox phy_third_Condo_CB = findViewById(R.id.checkBoxCondoPChbx3);
        CheckBox vir_third_Condo_CB =findViewById(R.id.checkBoxCondoVChbx3);


        SharedPreferences sp = getSharedPreferences(" phy_first_apt", Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = sp.edit();

        if (view.getId() == R.id.buttonCondoNext) {
            if(phy_first_Condo_CB.isChecked()) {
                prefEditor.putString("condo_01_phy","checked");
            }
            if(vir_first_Condo_CB.isChecked()) {
                prefEditor.putString("condo__01_vir","checked");
            }
            if(phy_second_Condo_CB.isChecked()) {
                prefEditor.putString("condo__02_phy","checked");
            }
            if(vir_second_Condo_CB.isChecked()) {
                prefEditor.putString("condo__02_vir","checked");
            }
            if(phy_third_Condo_CB.isChecked()) {
                prefEditor.putString("condo__03_phy","checked");
            }
            if(vir_third_Condo_CB.isChecked()) {
                prefEditor.putString("condo__03_vir","checked");
            }


            intent = new Intent(Condominium.this, CheckOut.class);
            //starts the new activity
            startActivity(intent);
        }

    }

}

