package com.swifties.bahceden;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.swifties.bahceden.fragments.CustomerCartFragment;
import com.swifties.bahceden.fragments.CustomerFavoritesFragment;
import com.swifties.bahceden.fragments.CustomerHomeFragment;
import com.swifties.bahceden.fragments.CustomerProfileFragment;
import com.swifties.bahceden.fragments.CustomerSearchFragment;

public class CustomerMainActivity extends AppCompatActivity {

    BottomNavigationView customerBottomNav;

    CustomerHomeFragment customerHomeFragment;
    CustomerSearchFragment customerSearchFragment;
    CustomerFavoritesFragment customerFavoritesFragment;
    CustomerProfileFragment customerProfileFragment;
    CustomerCartFragment customerCartFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_main);

        customerBottomNav = findViewById(R.id.customerBottomNavBar);

        customerHomeFragment = new CustomerHomeFragment();
        customerSearchFragment = new CustomerSearchFragment();
        customerFavoritesFragment = new CustomerFavoritesFragment();
        customerProfileFragment = new CustomerProfileFragment();
        customerCartFragment = new CustomerCartFragment();

//        Set HomeFragment as main fragment
        replaceFragment(customerHomeFragment);

//        Set listener for navBar
        customerBottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.customerHome:
                        replaceFragment(customerHomeFragment);
                        return true;

                    case R.id.customerSearch:
                        replaceFragment(customerSearchFragment);
                        return true;

                    case R.id.customerCart:
                        replaceFragment(customerCartFragment);
                        return true;

                    case R.id.customerFavorites:
                        replaceFragment(customerFavoritesFragment);
                        return true;

                    case R.id.customerProfile:
                        replaceFragment(customerProfileFragment);
                        return true;
                }

                return false;
            }
        });
    }

//    Helper method to replace fragments
    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.customerMainFragmentContainer, fragment).commit();
    }
}