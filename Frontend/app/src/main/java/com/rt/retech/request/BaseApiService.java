package com.rt.retech.request;

import com.rt.retech.model.Status_Bids;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;

public interface BaseApiService {
    /**
     * Call Login Request Seller
     * @param username username
     * @param password password
     * @return call
     */
    @FormUrlEncoded
    @POST("loginseller")
    Call<ResponseBody> loginRequestSeller(
            @Field("username") String username,
            @Field("password") String password
    );

    /**
     * Call Login Request Buyer
     * @param username username
     * @param password password
     * @return
     */
    @FormUrlEncoded
    @POST("loginbuyer")
    Call<ResponseBody> loginRequestBuyer(
            @Field("username") String username,
            @Field("password") String password
    );

    /**
     * Call Register Request Seller
     * @param username username
     * @param password password
     * @return Call
     */
    @FormUrlEncoded
    @POST("registerseller")
    Call<ResponseBody> registerRequestSeller(
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            @Field("phone") Integer phone
    );

    /**
     * Call Register Request buyer
     * @param username username
     * @param password password
     * @return Call
     */
    @FormUrlEncoded
    @POST("registerbuyer")
    Call<ResponseBody> registerRequestBuyer(
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            @Field("phone") Integer phone
    );

    @GET("showProduct")
    Call<ResponseBody> showProductRequest();

    @GET("showProductSeller")
    Call<ResponseBody> showProductSellerRequest(@Field("seller_id") Integer seller_id);


    @FormUrlEncoded
    @POST("addBid")
    Call<ResponseBody> addBidRequest(
            @Field("product_id") Integer product_id,
            @Field("seller_id") Integer seller_id,
            @Field("price_offered") Double price_offered,
            @Field("status_bids") Status_Bids status_bids
            );

    @GET("showBidBuyer")
    Call<ResponseBody> showBidBuyerRequest(@Field("buyer_id") Integer buyer_id);


}
