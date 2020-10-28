package com.example.mongorestapicall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button button;
    Retrofit retrofit;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        retrofit = new Retrofit.Builder().baseUrl("http://192.168.10.130:8090/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        button.setOnClickListener(view->{
            PostData();
        });
    }
    private void PostData(){
      Call<Person> call = jsonPlaceHolderApi.createPost(new Person(25,"Utkarsh"));
      call.enqueue(new Callback<Person>() {
          @Override
          public void onResponse(Call<Person> call, Response<Person> response) {
              if(!response.isSuccessful()){
                  Log.e("Code: ",String.valueOf(response.code()));
                  Log.e("vishal","rana");
              }
              Person person = response.body();
              Log.e("id : ",String.valueOf(person.getId()));
              Log.e("Name : ",person.getName());
              Log.e("vihsla","rana");
          }

          @Override
          public void onFailure(Call<Person> call, Throwable t) {
                  Log.e("Error : ",t.getMessage());
                  Log.e("Vishal","Rana");
          }
      });
    }
}