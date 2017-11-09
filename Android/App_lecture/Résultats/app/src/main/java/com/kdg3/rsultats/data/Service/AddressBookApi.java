package com.kdg3.rsultats.data.Service;

import com.kdg3.rsultats.data.Modele.Challenge;
import com.kdg3.rsultats.data.Modele.Course;
import com.kdg3.rsultats.data.Modele.Regatte;
import com.kdg3.rsultats.data.Modele.Voilier;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by sheelman on 08/11/17.
 */

public interface AddressBookApi {

    @GET("/challenge/")
    Call<List<Challenge>> getChallengeList();//pour récuperer plusieur élément en Json séparé par des crochets

    @GET("/challenge/{challenge}")
    Call<Challenge> getChallenge(@Path("challenge") int challengeId);//Pour récupérer des groupe de donnée

//---------------------------------------------------------------------------------------------------------------------

    @GET("/course/")
    Call<List<Course>> getCourseList();//pour récuperer plusieur élément en Json séparé par des crochets

    @GET("/course/{course}")
    Call<Course> getCourse(@Path("course") int courseId);//Pour récupérer des groupe de donnée

//---------------------------------------------------------------------------------------------------------------------

    @GET("/regatte/{id}")
    Call<List<Regatte>> getRegatteList(@Path("id") int id);//pour récuperer plusieur élément en Json séparé par des crochets

    @GET("/regatte/{regatte}")
    Call<Regatte> getRegatte(@Path("regatte") int regatteId);//Pour récupérer des groupe de donnée

//---------------------------------------------------------------------------------------------------------------------

    @GET("/voilier/")
    Call<List<Voilier>> getVoilierList();//pour récuperer plusieur élément en Json séparé par des crochets

    @GET("/voilier/{voilier}")
    Call<Voilier> getVoilier(@Path("voilier") int voilierId);//Pour récupérer des groupe de donnée

}
