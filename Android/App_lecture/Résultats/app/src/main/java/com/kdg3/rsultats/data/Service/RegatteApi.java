package com.kdg3.rsultats.data.Service;

import com.kdg3.rsultats.data.Modele.Regatte;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by sheelman on 09/11/17.
 */

public interface RegatteApi {
    @GET("/regatte/{id}")
    Call<List<Regatte>> getRegatteList(@Path("id") int id);//pour récuperer plusieur élément en Json séparé par des crochets

    @GET("/regatte/{regatte}")
    Call<Regatte> getRegatte(@Path("regatte") int regatteId);//Pour récupérer des groupe de donnée
}
