package com.rt.retech.request;

public class UtilsApi {
    public static final String BASE_URL_API = "http://localhost:3000/rt/";

    public static BaseApiService getApiService() {
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
