package com.rt.retech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.graphics.drawable.AnimationDrawable;

public class HomeStartActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_start);

        Button seller = findViewById(R.id.buttonSeller);
        Button buyer = findViewById(R.id.buttonBuyer);

        seller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move = new Intent(HomeStartActivity.this, LoginSellerActivity.class);
                startActivity(move);
            }
        });

        buyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move = new Intent(HomeStartActivity.this, LoginBuyerActivity.class);
                startActivity(move);
            }
        });
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