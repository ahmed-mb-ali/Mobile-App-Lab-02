package com.example.ahmedali_comp304sec003_lab2_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeTypes extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_types);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optional_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.apartment:
                //setContentView(R.layout.activity_apartments);
                Intent intentApartments = new Intent(HomeTypes.this, Apartments.class);
                startActivity(intentApartments);
                // do your code
                return true;
            case R.id.detached_home:
                //setContentView(R.layout.activity_detached_home);
                Intent intentDetached_Home = new Intent(HomeTypes.this, DetachedHome.class);
                startActivity(intentDetached_Home);
                // do your code
                return true;
            case R.id.semi_detached_home:
                //setContentView(R.layout.activity_semi_detached_home);
                Intent intentSemi_Detached_Home = new Intent(HomeTypes.this, SemiDetachedHome.class);
                startActivity(intentSemi_Detached_Home);
                // do your code
                return true;
            case R.id.condominium:
                //setContentView(R.layout.activity_condominium);
                Intent intentCondominium = new Intent(HomeTypes.this, Condominium.class);
                startActivity(intentCondominium);

                // do your code
                return true;
            case R.id.town_house:
                //setContentView(R.layout.activity_town_house);
                Intent intentTownHouse = new Intent(HomeTypes.this, TownHouse.class);
                startActivity(intentTownHouse);
                // do your code
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}