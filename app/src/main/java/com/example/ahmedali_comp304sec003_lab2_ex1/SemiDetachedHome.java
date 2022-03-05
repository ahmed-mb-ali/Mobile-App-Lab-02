package com.example.ahmedali_comp304sec003_lab2_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class SemiDetachedHome extends AppCompatActivity {
    //Declare the views
    Intent intent;
    Button buttonNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semi_detached_home);

        //Set up references to GUI view
        buttonNext = (Button) findViewById(R.id.buttonSemiDetachedNext);
    }

    public void next_SemiDetached_event(View view)
    {
        //Checkbox SharedPreferences
        CheckBox phy_first_semiDetached_CB = findViewById(R.id.checkBoxSemiDetachedPChbx1);
        CheckBox vir_first_semiDetached_CB =findViewById(R.id.checkBoxSemiDetachedVChbx1);

        CheckBox phy_second_semiDetached_CB = findViewById(R.id.checkBoxSemiDetachedPChbx2);
        CheckBox vir_second_semiDetached_CB =findViewById(R.id.checkBoxSemiDetachedVChbx2);

        CheckBox phy_third_semiDetached_CB = findViewById(R.id.checkBoxSemiDetachedPChbx3);
        CheckBox vir_third_semiDetached_CB =findViewById(R.id.checkBoxSemiDetachedVChbx3);


        SharedPreferences sp = getSharedPreferences(" phy_first_apt", Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = sp.edit();

        if (view.getId() == R.id.buttonCondoNext) {
            if(phy_first_semiDetached_CB.isChecked()) {
                prefEditor.putString("semiDetached01_phy","checked");
            }
            if(vir_first_semiDetached_CB.isChecked()) {
                prefEditor.putString("semiDetached_01_vir","checked");
            }
            if(phy_second_semiDetached_CB.isChecked()) {
                prefEditor.putString("semiDetached_02_phy","checked");
            }
            if(vir_second_semiDetached_CB.isChecked()) {
                prefEditor.putString("semiDetached_02_vir","checked");
            }
            if(phy_third_semiDetached_CB.isChecked()) {
                prefEditor.putString("semiDetached_03_phy","checked");
            }
            if(vir_third_semiDetached_CB.isChecked()) {
                prefEditor.putString("semiDetached_03_vir","checked");
            }

            intent = new Intent(SemiDetachedHome.this, CheckOut.class);
            //starts the new activity
            startActivity(intent);
        }

    }

}