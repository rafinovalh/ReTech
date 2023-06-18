package com.rt.retech;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rt.retech.request.BaseApiService;
import com.rt.retech.request.UtilsApi;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Callback;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginBuyerActivity extends AppCompatActivity {
    Context mContext;
    BaseApiService mApiService;

    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_buyer);

        mContext = this;
        mApiService = UtilsApi.getApiService();


        Button buttonLogin = findViewById(R.id.buttonLogin);
        TextView buttonRegister = findViewById(R.id.buttonRegister);
        username = findViewById(R.id.username_input);
        password = findViewById(R.id.password_input);

         buttonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                requestLoginBuyer();
            }
         });

         buttonRegister.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View view) {
                 Intent move = new Intent(LoginBuyerActivity.this, RegisterBuyerActivity.class);
                 startActivity(move);
             }
         });


    }

    protected void requestLoginBuyer(){
        mApiService.loginRequestBuyer(username.getText().toString(), password.getText().toString()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    try{
                        JSONObject theJson = new JSONObject(response.body().string());
                        if(theJson.getString("Message").equals("Success")){
                            //masih ga tau pas dan bener apa ga
                            Intent move = new Intent(LoginBuyerActivity.this, MainBuyerActivity.class);
                            startActivity(move);
                            Toast.makeText(mContext, "Login Successfull", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(mContext, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    }catch(JSONException | IOException e){
                        e.printStackTrace();
                    }
                }else{
                    Toast.makeText(mContext, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(mContext, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}