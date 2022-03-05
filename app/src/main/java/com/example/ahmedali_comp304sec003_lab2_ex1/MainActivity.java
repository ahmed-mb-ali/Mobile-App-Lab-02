package com.example.ahmedali_comp304sec003_lab2_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //Declare variables
    Intent intent;
    Button buttonSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up references to GUI view
        buttonSend = (Button) findViewById(R.id.home_button);

        //onClick event listener
        buttonSend.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                switch(view.getId()) {

                }
                    int id = view.getId();

                //if Enter button is clicked, start HomeTypes activity
                if ( id == R.id.home_button){
                    intent = new Intent(MainActivity.this, HomeTypes.class);
                    //starts the new activity
                    startActivity(intent);
                }
            }//end method

        });
    }//end method
}//end class
