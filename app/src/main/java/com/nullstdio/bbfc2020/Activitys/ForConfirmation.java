package com.nullstdio.bbfc2020.Activitys;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.nullstdio.bbfc2020.R;

public class ForConfirmation extends AppCompatActivity {

    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_confirmation);

        viewPager = findViewById(R.id.viewPager);


    }

    public void homePage(View view) {

        Intent intent = new Intent(this , MainMainActivity.class);
        startActivity(intent);
        finish();
    }
}
