package com.rt.retech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.graphics.drawable.AnimationDrawable;

public class HomeStartActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_start);

        animationDrawable = (AnimationDrawable) relativeLayout.getBackground();

        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (animationDrawable != null && animationDrawable.isRunning()){
            animationDrawable.stop();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (animationDrawable != null && !animationDrawable.isRunning()){
            animationDrawable.start();
        }
    }


    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_start);


            NAMA VARIABLE TIAP ACTIVITY DI XML DI INISIASI
            PAKAI findViewById(R.id.NAMADIXMLNYA);

         buttonBuyer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void OnClick(View view){
                Intent move = new Intent(HomeStartActivity.this, LoginBuyerActivity.class);
                startActivity(move);
            }
         });

         buttonSeller.setOnClickListener(new View.OnClickListener(){
            @Override
            public void OnClick(View view){
                Intent move = new Intent(HomeStartActivity.this, LoginSellerActivity.class);
                startActivity(move);
            }
         });

    }*/
}