package android.com.jumpco.io.superheroapi.interfaces;

import android.com.jumpco.io.superheroapi.pojo.Results;
import android.com.jumpco.io.superheroapi.pojo.SuperheroResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL = "https://simplifiedcoding.net/demos/";

    String BASE_URL3 = "https://superheroapi.com/ids.html";
    @GET("marvel")
    Call<List<Results>> getsuperHeroes();

    String BASE_URL2 = "https://superheroapi.com/api/4278893445508338/150/";
    String API_KEY = "";
    @GET("id")
//    Call<Results> getCurrentSuperheroDataInfo();
//    Call<Results> getCurrentSuperheroData();
//
    Call<Results> getCurrentSuperheroDataInfo(@Query("id") int id);
//    Call<List<Results>> getsuperHeroes2(@Query("name") String name);


}
