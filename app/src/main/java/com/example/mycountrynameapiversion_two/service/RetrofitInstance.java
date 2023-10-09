package com.example.mycountrynameapiversion_two.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit=null;
    //give the base URL
    private static String BASE_URL="https://api.printful.com";

    public static GetCountryDataService getCountryDataService(){
        //
        if(retrofit==null){
            // single tone design pattern
            retrofit= new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        }
        return  retrofit.create(GetCountryDataService.class);
    }
}
//retrofit instance
//interface
//model