package com.kdg3.rsultats.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.kdg3.rsultats.R;

import com.kdg3.rsultats.data.Modele.Course;

import com.kdg3.rsultats.data.Modele.Voilier;
import com.kdg3.rsultats.data.Service.AddressBookApi;
import com.kdg3.rsultats.data.Service.CourseApi;
import com.kdg3.rsultats.data.Service.VoilierApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GroupListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VoilierApi service = retrofit.create(VoilierApi.class);

        service.getVoilierList().enqueue(new Callback<List<Voilier>>() {
            @Override
            public void onResponse(Call<List<Voilier>> call, Response<List<Voilier>> response) {
                Log.i("retrofit", "Download ok");
                for (Voilier voilier:response.body()) {
                    Log.i("retrofit", "Voilier : " + voilier.getNumero_voile());
                }
            }

            @Override
            public void onFailure(Call<List<Voilier>> call, Throwable t) {

            }
        });
    }


}
