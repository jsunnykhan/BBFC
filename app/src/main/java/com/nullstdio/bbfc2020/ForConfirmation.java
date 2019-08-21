package com.nullstdio.bbfc2020;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

public class ForConfirmation extends AppCompatActivity {

    private CarouselPicker picker ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_confirmation);



    }

    public void homePage(View view) {

        Intent intent = new Intent(this , MainMainActivity.class);
        startActivity(intent);
        finish();
    }
}
