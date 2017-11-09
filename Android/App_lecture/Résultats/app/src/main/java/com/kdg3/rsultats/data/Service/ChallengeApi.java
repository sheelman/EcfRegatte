package com.kdg3.rsultats.data.Service;

import com.kdg3.rsultats.data.Modele.Challenge;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by sheelman on 09/11/17.
 */

public interface ChallengeApi {
    @GET("/challenge/")
    Call<List<Challenge>> getChallengeList();//pour récuperer plusieur élément en Json séparé par des crochets

    @GET("/challenge/{challenge}")
    Call<Challenge> getChallenge(@Path("challenge") int challengeId);//Pour récupérer des groupe de donnée
}
