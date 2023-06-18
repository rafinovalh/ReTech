package com.rt.retech;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rt.retech.model.Products;
import com.rt.retech.request.BaseApiService;
import com.rt.retech.request.UtilsApi;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Callback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;;

public class MainBuyerActivity extends AppCompatActivity {
    private ArrayList<Products> products = new ArrayList<>();
    private ArrayList<String> items;
    private ArrayAdapter<Products> itemsAdapter;
    private ListView listProducts;
    public static Products selectedProducts = null;

    Context mContext;
    BaseApiService mApiService;

    Button bidHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_buyer);

        mContext = this;
        mApiService = UtilsApi.getApiService();

        requestList();
        listProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedProducts = products.get(position);
                Intent move = new Intent(mContext, ProductsDetailActivity.class);
                startActivity(move);
            }
        });


        bidHistory = findViewById(R.id.bidHistory);
        bidHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move = new Intent(MainBuyerActivity.this, BidsDetailActivity.class);
                startActivity(move);
            }
        });
    }

    void requestList(){
        Gson gson = new Gson();
        mApiService.showProductRequest().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    try{
                        JSONObject theJson = new JSONObject(response.body().string());
                        JSONArray arrJson = theJson.getJSONArray("products");
                        if(theJson.getString("Message").equals("Success")){
                            //masih ga tau pas dan bener apa ga
                            products = gson.fromJson(arrJson.toString(), new TypeToken<ArrayList<Products>>() {}.getType());
                            itemsAdapter = new ArrayAdapter<Products>(getApplicationContext(), android.R.layout.simple_list_item_1, products);
                            listProducts.setAdapter(itemsAdapter);
                        }else{
                            Toast.makeText(mContext, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }catch(JSONException | IOException e){
                        e.printStackTrace();
                    }
                }else {
                    Toast.makeText(mContext, "Already Login", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(mContext, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}