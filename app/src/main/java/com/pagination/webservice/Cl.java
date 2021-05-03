package com.pagination.webservice;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Cl {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).build();

        //Gson gson=new GsonB
        //Gson gson = new GsonBuilder().setLenient().create();

        retrofit = new Retrofit.Builder()
                //.baseUrl("http://successking.in/demo/webserviceapi/")
                .baseUrl( "https://timescrm.com/ACZone/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
