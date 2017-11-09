package com.kdg3.rsultats.data.Service;

import com.kdg3.rsultats.data.Modele.Course;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by sheelman on 09/11/17.
 */

public interface CourseApi {
    @GET("/course/{id}")
    Call<List<Course>> getCourseList(@Path("id") int id);//pour récuperer plusieur élément en Json séparé par des crochets

    @GET("/course/{course}")
    Call<Course> getCourse(@Path("course") int courseId);//Pour récupérer des groupe de donnée
}
