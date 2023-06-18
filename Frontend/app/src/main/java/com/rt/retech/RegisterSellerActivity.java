package com.rt.retech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rt.retech.request.BaseApiService;
import com.rt.retech.request.UtilsApi;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class RegisterSellerActivity extends AppCompatActivity {
    Context mContext;
    BaseApiService mApiService;

    EditText username, email, phone, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_seller);

        mContext = this;
        mApiService = UtilsApi.getApiService();

        Button buttonRegister = findViewById(R.id.buttonRegister);
        username = findViewById(R.id.username_input);
        email = findViewById(R.id.email_input);
        phone = findViewById(R.id.phone_input);
        password = findViewById(R.id.password_input);

        buttonRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                requestRegisterSeller();
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent move = new Intent(RegisterSellerActivity.this, LoginSellerActivity.class);
                startActivity(move);
            }
        });
    }


    protected void requestRegisterSeller(){
        mApiService.registerRequestSeller(username.getText().toString(), password.getText().toString(), email.getText().toString(), Integer.getInteger(phone.getText().toString())).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    try{
                        JSONObject theJson = new JSONObject(response.body().string());
                        if(theJson.getString("Message").equals("Success")){
                            //masih ga tau pas dan bener apa ga
                            Intent move = new Intent(RegisterSellerActivity.this, LoginSellerActivity.class);
                            startActivity(move);
                            Toast.makeText(mContext, "Register Successfull", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(mContext, "Register Failed", Toast.LENGTH_SHORT).show();
                        }
                    }catch(JSONException | IOException e){
                        e.printStackTrace();
                    }
                }else{
                    Toast.makeText(mContext, "Register Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(mContext, "Register Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

}