package com.rt.retech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rt.retech.model.Status_Bids;
import com.rt.retech.request.BaseApiService;
import com.rt.retech.request.UtilsApi;

import com.rt.retech.model.Status_Products;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;


public class ProductsDetailActivity extends AppCompatActivity {
    TextView productname, productdesc, productprice, productnegotiabel, productstatus, productseller;
    Button bidbutton, addbid;
    EditText yourbid;

    Context mContext;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_detail);

        mContext = this;
        mApiService = UtilsApi.getApiService();

        productname = findViewById(R.id.productname);
        productdesc = findViewById(R.id.productdesc);
        productprice = findViewById(R.id.productprice);
        productnegotiabel = findViewById(R.id.productnegotiable);
        productstatus = findViewById(R.id.productstatus);
        productseller = findViewById(R.id.productseller);

        productname.setText(MainBuyerActivity.selectedProducts.getName());
        productprice.setText(String.valueOf(MainBuyerActivity.selectedProducts.getPrice()));
        productdesc.setText(MainBuyerActivity.selectedProducts.getDescription());
        productnegotiabel.setText(String.valueOf(MainBuyerActivity.selectedProducts.getIs_Negotiable()));
        productstatus.setText(String.valueOf(MainBuyerActivity.selectedProducts.getStatus_products()));
        //yg bawah ini kyknya salah
        productseller.setText(MainBuyerActivity.selectedProducts.getSeller_id());

        //bawah ini bakal salah kyknya
        String negotiable = String.valueOf(MainBuyerActivity.selectedProducts.getIs_Negotiable());
        bidbutton = findViewById(R.id.bidbutton);
        Status_Products statusProduct = MainBuyerActivity.selectedProducts.getStatus_products();
        if(statusProduct == Status_Products.SELL & negotiable== "true"){
            bidbutton.setVisibility(View.VISIBLE);
        }else{
            bidbutton.setVisibility(View.INVISIBLE);
        }

        addbid = findViewById(R.id.addbidbutton);
        yourbid = findViewById(R.id.yourbid);
        bidbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                bidbutton.setVisibility(View.INVISIBLE);
                yourbid.setVisibility(View.VISIBLE);
                addbid.setVisibility(View.VISIBLE);
                requestBid();
            }
        });
    }

    public void requestBid(){
        double bidValue = Double.parseDouble(yourbid.getText().toString());
        mApiService.addBidRequest(MainBuyerActivity.selectedProducts.getId(), MainBuyerActivity.selectedProducts.getSeller_id(), bidValue, Status_Bids.WAIT).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    try{
                        JSONObject theJson = new JSONObject(response.body().string());
                        if(theJson.getString("Message").equals("Success")){
                            //masih ga tau pas dan bener apa ga
                            Intent move = new Intent(ProductsDetailActivity.this, MainBuyerActivity.class);
                            startActivity(move);
                            Toast.makeText(mContext, "Add Successfull", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(mContext, "Add Failed", Toast.LENGTH_SHORT).show();
                        }
                    }catch(JSONException | IOException e){
                        e.printStackTrace();
                    }
                }else{
                    Toast.makeText(mContext, "Add Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(mContext, "Add Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}