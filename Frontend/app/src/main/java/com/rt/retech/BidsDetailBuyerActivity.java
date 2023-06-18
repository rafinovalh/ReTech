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


public class BidsDetailBuyerActivity extends AppCompatActivity {
    TextView productid, productpriceofferd, productstatusbid;

    Context mContext;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bids_detail_buyer);

        mContext = this;
        mApiService = UtilsApi.getApiService();

        productid = findViewById(R.id.productid);
        productpriceofferd = findViewById(R.id.productpriceoffered);
        productstatusbid = findViewById(R.id.productstatusbid);

        productid.setText(BidsDetailActivity.selectedBids.getProduct_id());
        productpriceofferd.setText(String.valueOf(BidsDetailActivity.selectedBids.getPrice_offered()));
        productstatusbid.setText(String.valueOf(BidsDetailActivity.selectedBids.getStatus_bids()));


    }
}