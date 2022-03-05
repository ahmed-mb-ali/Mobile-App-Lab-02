package com.example.ahmedali_comp304sec003_lab2_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CheckOut extends AppCompatActivity {
    //Declare Variables

    Intent intent;
    RadioButton cash, debit, credit;
    ArrayList<Boolean> paymentRadioButtons = new ArrayList<Boolean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);


        EditText test = findViewById(R.id.test01);
        SharedPreferences sp = getSharedPreferences(" phy_first_apt", Context.MODE_PRIVATE);

        //Retrieve apartment check box string
        String first_apt_ph = sp.getString("apt_01_phy", "");
        String first_apt_vr = sp.getString("apt_01_vir", "");
        String second_apt_ph = sp.getString("apt_02_phy", "");
        String second_apt_vr = sp.getString("apt_02_vir", "");
        String third_apt_ph = sp.getString("apt_03_phy", "");
        String third_apt_vr = sp.getString("apt_03_vir", "");

        //Retrieve condo check box string
        String first_condo_ph = sp.getString("condo_01_phy", "");
        String first_condo_vr = sp.getString("condo_01_vir", "");
        String second_condo_ph = sp.getString("condo_02_phy", "");
        String second_condo_vr = sp.getString("condo_02_vir", "");
        String third_condo_ph = sp.getString("condo_03_phy", "");
        String third_condo_vr = sp.getString("condo_03_vir", "");

        //Retrieve detached check box string
        String first_detached_ph = sp.getString("detached_01_phy", "");
        String first_detached_vr = sp.getString("detached_01_vir", "");
        String second_detached_ph = sp.getString("detached_02_phy", "");
        String second_detached_vr = sp.getString("detached_02_vir", "");
        String third_detached_ph = sp.getString("detached_03_phy", "");
        String third_detached_vr = sp.getString("detached_03_vir", "");

        //Retrieve semiDetached check box string
        String first_semiDetached_ph = sp.getString("semiDetached_01_phy", "");
        String first_semiDetached_vr = sp.getString("semiDetached_01_vir", "");
        String second_semiDetached_ph = sp.getString("semiDetached_02_phy", "");
        String second_semiDetached_vr = sp.getString("semiDetached_02_vir", "");
        String third_semiDetached_ph = sp.getString("semiDetached_03_phy", "");
        String third_semiDetached_vr = sp.getString("semiDetached_03_vir", "");


        if (first_apt_ph != null && first_apt_vr != null)
        {
            test.setText(getString(R.string.txt_apartment1));
        }
        else if (second_apt_ph != null && second_apt_vr != null)
        {
            test.setText(getString(R.string.txt_apartment2));
        }
        else if (third_apt_ph != null && third_apt_vr != null)
        {
            test.setText(getString(R.string.txt_apartment2));
        }
        else if  (first_condo_ph != null && first_condo_vr != null)
        {
            test.setText(getString(R.string.txt_condo1));
        }
        else if  (second_condo_ph != null && second_condo_vr != null)
        {
            test.setText(getString(R.string.txt_condo2));
        }
        else if  (third_condo_ph != null && third_condo_vr != null)
        {
            test.setText(getString(R.string.txt_condo3));
        }
        else if  (first_detached_ph != null && first_detached_vr != null)
        {
            test.setText(getString(R.string.txt_detached1));
        }
        else if  (second_detached_ph != null && second_detached_vr != null)
        {
            test.setText(getString(R.string.txt_detached2));
        }
        else if  (third_detached_ph != null && third_detached_vr != null)
        {
            test.setText(getString(R.string.txt_detached3));
        }
        else if  (first_semiDetached_ph != null && first_semiDetached_vr != null)
        {
            test.setText(getString(R.string.txt_SemiDetached1));
        }
        else if  (second_semiDetached_ph != null && second_semiDetached_vr != null)
        {
            test.setText(getString(R.string.txt_SemiDetached2));
        }
        else if  (third_semiDetached_ph != null && third_semiDetached_vr != null)
        {
            test.setText(getString(R.string.txt_SemiDetached3));
        }

        }

    //onClick event listener
    public void onClick(View view) {
        //Get ids' values
        cash = (RadioButton) findViewById(R.id.CashRadioBtn);
        debit = (RadioButton) findViewById(R.id.DebitRadioBtn);
        credit = (RadioButton) findViewById(R.id.CreditRadioBtn);
        int id = view.getId();

        //Clear array
        paymentRadioButtons.clear();

        //Add radio buttons selection to array
        paymentRadioButtons.add(cash.isChecked());
        paymentRadioButtons.add(debit.isChecked());
        paymentRadioButtons.add(credit.isChecked());

        if( id == R.id.CheckoutBtn){

            //Start new Payment activity
            intent = new Intent(this, Payment.class);
            intent.putExtra("isChecked", paymentRadioButtons);
            startActivity(intent);
        }
        else if (((RadioGroup) findViewById(R.id.PaymentRadioGroup)).getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(this, R.string.PaymentNotSelected, Toast.LENGTH_SHORT).show();
        }
    }
}