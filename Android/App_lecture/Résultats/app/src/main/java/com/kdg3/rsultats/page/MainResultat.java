package com.kdg3.rsultats.page;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kdg3.rsultats.MainActivity;
import com.kdg3.rsultats.R;

import com.kdg3.rsultats.data.Modele.Course;
import com.kdg3.rsultats.data.Service.AddressBookApi;
import com.kdg3.rsultats.data.Service.CourseApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainResultat extends AppCompatActivity {

    private ListView list = null;
    private List<Course> courses = new ArrayList<>();
    public static final String BASE_URL = "http://10.0.2.2:8080";
    private ArrayAdapter<Course> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_resultat);

        Intent intent = getIntent();
        int idRegatte = intent.getIntExtra("id_regatte", 0);

        list = (ListView) findViewById(R.id.ListResultats);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CourseApi service = retrofit.create(CourseApi.class);

        service.getCourseList(idRegatte).enqueue(new Callback<List<Course>>(){

            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                courses = response.body();
                adapter = (new ArrayAdapter<>(MainResultat.this, android.R.layout.simple_list_item_1, courses));
                list.setAdapter(adapter);
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Course course = (Course) list.getItemAtPosition(position);
                        int idCourse = course.getId();
                        Intent intent = new Intent(MainResultat.this, MainActivity.class);
                        intent.putExtra("id_course", idCourse);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {

            }
        });
    }

}
