package com.example.gofood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.gofood.customerFoodPanel.CustomerCartFragment;
import com.example.gofood.customerFoodPanel.CustomerHomeFragment;
import com.example.gofood.customerFoodPanel.CustomerOrderFragment;
import com.example.gofood.customerFoodPanel.CustomerProfileFragment;
import com.example.gofood.customerFoodPanel.CustomerTrackFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CustomerFoodPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_food_panel_bottom_navigation);
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
        String name = getIntent().getStringExtra("PAGE");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(name != null) {
            if (name.equalsIgnoreCase("Homepage")) {
                loadfragment(new CustomerHomeFragment());
            } else if (name.equalsIgnoreCase("Preparing Page")) {
                loadfragment(new CustomerTrackFragment());
            } else if (name.equalsIgnoreCase("Delivery")) {
                loadfragment(new CustomerTrackFragment());
            } else if (name.equalsIgnoreCase("Thankyou")) {
                loadfragment(new CustomerHomeFragment());
            }
        }else {
            loadfragment(new CustomerHomeFragment());
        }
    }

    private void loadfragment(CustomerHomeFragment customerHomeFragment) {
    }

    private void loadfragment(CustomerTrackFragment customerHomeFragment) {
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.cust_Home:
                fragment = new CustomerHomeFragment();
                break;
        }
        switch (item.getItemId()) {
            case R.id.cart:
                fragment = new CustomerCartFragment();
                break;
        }
        switch (item.getItemId()) {
            case R.id.cust_profile:
                fragment = new CustomerProfileFragment();
                break;
        }
        switch (item.getItemId()) {
            case R.id.Cust_order:
                fragment = new CustomerOrderFragment();
                break;
        }
        switch (item.getItemId()) {
            case R.id.cart:
                fragment = new CustomerCartFragment();
                break;
        }
        return loadcheffragment(fragment);
    }

    private boolean loadcheffragment(Fragment fragment) {
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            return true;
        }
        return false;
    }
}