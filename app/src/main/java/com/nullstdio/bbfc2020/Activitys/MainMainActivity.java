package com.nullstdio.bbfc2020.Activitys;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.nullstdio.bbfc2020.FantasyFragment.Fantasy;
import com.nullstdio.bbfc2020.FragmentAll.FixtureFragment;
import com.nullstdio.bbfc2020.FragmentAll.HistoryFragment;
import com.nullstdio.bbfc2020.FragmentAll.HomeFragment;
import com.nullstdio.bbfc2020.FragmentAll.MainFantasy;
import com.nullstdio.bbfc2020.FragmentAll.StandingFragment;
import com.nullstdio.bbfc2020.FragmentAll.TeamFragment;
import com.nullstdio.bbfc2020.R;

public class MainMainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private Fragment homeFragment;
    private Fragment fixtureFragment;
    private Fragment teamFragment;
    private Fragment historyFragment;
    private Fragment gallaryFragment;
    private Fragment fantasy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_main);

        toolbar = findViewById(R.id.toolbarC);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.start, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        navigationView.clearFocus();

        //fragment

        homeFragment = new HomeFragment();
        fixtureFragment = new FixtureFragment();
        teamFragment = new TeamFragment();
        historyFragment = new HistoryFragment();
        gallaryFragment = new StandingFragment();
        fantasy = new MainFantasy();


        if (savedInstanceState == null) {
            setFragment(homeFragment);
            navigationView.setCheckedItem(R.id.home_nav);
        }


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    private void setFragment(Fragment fragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.home_nav: {
                setFragment(homeFragment);
                drawerLayout.closeDrawers();
                break;
            }
            case R.id.fixture_nav: {
                setFragment(fixtureFragment);
                drawerLayout.closeDrawers();
                break;
            }
            case R.id.team_nav: {
                setFragment(teamFragment);
                drawerLayout.closeDrawers();
                break;
            }
            case R.id.history_nav: {
                setFragment(historyFragment);
                drawerLayout.closeDrawers();
                break;
            }
            case R.id.gallery: {
                setFragment(gallaryFragment);
                drawerLayout.closeDrawers();
                break;
            }
            case R.id.fantasy: {
                setFragment(fantasy);
                drawerLayout.closeDrawers();
                break;
            }
        }
        return true;
    }
}

