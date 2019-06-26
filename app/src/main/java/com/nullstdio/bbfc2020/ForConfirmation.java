package com.nullstdio.bbfc2020;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ForConfirmation extends AppCompatActivity {

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
