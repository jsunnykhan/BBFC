package com.nullstdio.bbfc2020;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView bbfcIv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bbfcIv = (ImageView) findViewById(R.id.splashIv);

        Animation myanim = AnimationUtils.loadAnimation(this , R.anim.prontpageanim);
        bbfcIv.setAnimation(myanim);

       final Intent intent = new Intent(this , ForConfirmation.class);

        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(4200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    startActivity(intent);
                    finish();
                }

            }
        };
        timer.start();
    }
}
