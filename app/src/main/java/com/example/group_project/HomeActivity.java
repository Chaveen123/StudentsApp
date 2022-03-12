package com.example.group_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = findViewById(R.id.navigation_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Student Essentials");
        drawer = findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView = findViewById(R.id.navigation);
        View view = navigationView.inflateHeaderView(R.layout.navigation_header);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                UserMenuSelector (item);
                return false;
            }
        });
    }

    private void UserMenuSelector(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.home:
                Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.timetable:
                Toast.makeText(getApplicationContext(), "Timetable", Toast.LENGTH_SHORT).show();
                break;
            case R.id.notes:
                Toast.makeText(getApplicationContext(), "Notes", Toast.LENGTH_SHORT).show();
                break;
            case R.id.track:
                Toast.makeText(getApplicationContext(), "Find My Item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                Toast.makeText(getApplicationContext(), "Log out", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}