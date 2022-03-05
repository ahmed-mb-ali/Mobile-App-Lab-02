package com.example.ahmedali_comp304sec003_lab2_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class DetachedHome extends AppCompatActivity {
    //Declare the views
    Intent intent;
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detached_home);

        //Set up references to GUI view
        buttonNext = (Button) findViewById(R.id.buttonDetachedNext);
    }

    public void next_detached_event(View view)
    {
        //Checkbox SharedPreferences
        CheckBox phy_first_detached_CB = findViewById(R.id.checkBoxDetachedPChbx1);
        CheckBox vir_first_detached_CB =findViewById(R.id.checkBoxDetachedVChbx1);

        CheckBox phy_second_detached_CB = findViewById(R.id.checkBoxDetachedPChbx2);
        CheckBox vir_second_detached_CB =findViewById(R.id.checkBoxDetachedVChbx2);

        CheckBox phy_third_detached_CB = findViewById(R.id.checkBoxDetachedPChbx3);
        CheckBox vir_third_detached_CB =findViewById(R.id.checkBoxDetachedVChbx3);


        SharedPreferences sp = getSharedPreferences(" phy_first_apt", Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = sp.edit();

        if (view.getId() == R.id.buttonCondoNext) {
            if(phy_first_detached_CB.isChecked()) {
                prefEditor.putString("detached_01_phy","checked");
            }
            if(vir_first_detached_CB.isChecked()) {
                prefEditor.putString("detached_01_vir","checked");
            }
            if(phy_second_detached_CB.isChecked()) {
                prefEditor.putString("detached_02_phy","checked");
            }
            if(vir_second_detached_CB.isChecked()) {
                prefEditor.putString("condo_detached_02_vir","checked");
            }
            if(phy_third_detached_CB.isChecked()) {
                prefEditor.putString("detached_03_phy","checked");
            }
            if(vir_third_detached_CB.isChecked()) {
                prefEditor.putString("detached_03_vir","checked");
            }

            intent = new Intent(DetachedHome.this, CheckOut.class);
            //starts the new activity
            startActivity(intent);
        }

    }

}