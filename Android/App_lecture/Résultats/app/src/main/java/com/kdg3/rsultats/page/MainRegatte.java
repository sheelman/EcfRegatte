package com.kdg3.rsultats.page;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kdg3.rsultats.R;


import com.kdg3.rsultats.data.Modele.Regatte;
import com.kdg3.rsultats.data.Service.AddressBookApi;
import com.kdg3.rsultats.data.Service.RegatteApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainRegatte extends AppCompatActivity {

    private ListView list = null;
    private List<Regatte> regattes = new ArrayList<>();
    public static final String BASE_URL = "http://10.0.2.2:8080";
    private ArrayAdapter<Regatte> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_regatte);

        Intent intent = getIntent();
        int idChallenge = intent.getIntExtra("id_challenge", 0);

        list = (ListView) findViewById(R.id.ListRegattes);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegatteApi service = retrofit.create(RegatteApi.class);

        service.getRegatteList(idChallenge).enqueue(new Callback<List<Regatte>>(){

            @Override
            public void onResponse(Call<List<Regatte>> call, Response<List<Regatte>> response) {
                regattes = response.body();
                adapter = (new ArrayAdapter<>(MainRegatte.this, android.R.layout.simple_list_item_1, regattes));
                list.setAdapter(adapter);
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Regatte regatte = (Regatte) list.getItemAtPosition(position);
                        int idRegatte = regatte.getId();
                        Intent intent = new Intent(MainRegatte.this, MainRegatte.class);
                        intent.putExtra("id_regatte", idRegatte);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Regatte>> call, Throwable t) {

            }
        });
    }

}