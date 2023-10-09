package com.example.mycountrynameapiversion_two;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.mycountrynameapiversion_two.adapter.CountryAdapter;
import com.example.mycountrynameapiversion_two.model.CountryModel;
import com.example.mycountrynameapiversion_two.model.Result;
import com.example.mycountrynameapiversion_two.service.GetCountryDataService;
import com.example.mycountrynameapiversion_two.service.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<CountryModel> countries;
    //bellow two line for adding recyle view
    private RecyclerView recyclerView;
    private CountryAdapter countryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //to display the data countries in to the log
        getCountries();
    }
    public ArrayList<CountryModel> getCountries(){
        GetCountryDataService getCountryDataService = RetrofitInstance.getCountryDataService();
        Call<Result> call= getCountryDataService.getResult();

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
              Result result=response.body();

                if(result != null && result.getResult() != null){
                    countries = (ArrayList<CountryModel>) result.getResult();

                    viewData();
                    //advance for loop
                  /*  for(CountryModel c:countries){
                       // Log.i("TAG",""+c.getName());

                    }*/
                }

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });

       return countries;
    }

    //this bellow code for adding in recycler view
    public  void  viewData(){
        //this method contain the declaration of recycler view
        recyclerView = findViewById(R.id.recyclerView);
        countryAdapter = new CountryAdapter(countries);
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(countryAdapter);
    }

}