package com.kdg3.rsultats.page;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kdg3.rsultats.R;
import com.kdg3.rsultats.data.Modele.Challenge;
import com.kdg3.rsultats.data.Service.AddressBookApi;
import com.kdg3.rsultats.data.Service.ChallengeApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainChallenge extends AppCompatActivity {

    private ListView list = null;
    private List<Challenge> challenges = new ArrayList<>();
    public static final String BASE_URL = "http://10.0.2.2:8080";
    private ArrayAdapter<Challenge> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_challenge);

        list = (ListView) findViewById(R.id.ListChallenges);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ChallengeApi service = retrofit.create(ChallengeApi.class);

        service.getChallengeList().enqueue(new Callback<List<Challenge>>(){

            @Override
            public void onResponse(Call<List<Challenge>> call, Response<List<Challenge>> response) {
                challenges = response.body();
                adapter = (new ArrayAdapter<>(MainChallenge.this, android.R.layout.simple_list_item_1, challenges));
                list.setAdapter(adapter);
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Challenge challenge = (Challenge) list.getItemAtPosition(position);
                        int idChallenge = challenge.getId();
                        Intent intent = new Intent(MainChallenge.this, MainRegatte.class);
                        intent.putExtra("id_challenge", idChallenge);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Challenge>> call, Throwable t) {

            }
        });
    }

}
