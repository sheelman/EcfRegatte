package com.kdg3.rsultats.data.Service;

import com.kdg3.rsultats.data.Modele.Voilier;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by sheelman on 09/11/17.
 */

public interface VoilierApi {
    @GET("/voilier/")
    Call<List<Voilier>> getVoilierList();//pour récuperer plusieur élément en Json séparé par des crochets

    @GET("/voilier/{voilier}")
    Call<com.kdg3.rsultats.data.Modele.Voilier> getVoilier(@Path("voilier") int voilierId);//Pour récupérer des groupe de donnée
}
