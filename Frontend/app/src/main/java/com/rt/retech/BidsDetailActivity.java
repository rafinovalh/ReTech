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
import com.rt.retech.model.Bids;
import com.rt.retech.request.BaseApiService;
import com.rt.retech.request.UtilsApi;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Callback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;;

public class BidsDetailActivity extends AppCompatActivity {
    private ArrayList<Bids> bids = new ArrayList<>();
    private ArrayList<String> items;
    private ArrayAdapter<Bids> itemsAdapter;
    private ListView listBids;
    public static Bids selectedBids = null;

    Context mContext;
    BaseApiService mApiService;

    Button bidHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bids_detail);

        mContext = this;
        mApiService = UtilsApi.getApiService();

        requestList();
        listBids.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedBids = bids.get(position);
                Intent move = new Intent(mContext, BidsDetailBuyerActivity.class);
                startActivity(move);
            }
        });

    }

    void requestList(){
        Gson gson = new Gson();
        mApiService.showBidBuyerRequest(BidsDetailActivity.selectedBids.getBuyer_id()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    try{
                        JSONObject theJson = new JSONObject(response.body().string());
                        JSONArray arrJson = theJson.getJSONArray("bids");
                        if(theJson.getString("Message").equals("Success")){
                            //masih ga tau pas dan bener apa ga
                            bids = gson.fromJson(arrJson.toString(), new TypeToken<ArrayList<Bids>>() {}.getType());
                            itemsAdapter = new ArrayAdapter<Bids>(getApplicationContext(), android.R.layout.simple_list_item_1, bids);
                            listBids.setAdapter(itemsAdapter);
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