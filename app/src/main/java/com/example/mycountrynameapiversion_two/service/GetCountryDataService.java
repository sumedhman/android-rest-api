package com.example.mycountrynameapiversion_two.service;

import com.example.mycountrynameapiversion_two.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCountryDataService {

      @GET("countries")  //end points

      Call<Result>  getResult();
}
