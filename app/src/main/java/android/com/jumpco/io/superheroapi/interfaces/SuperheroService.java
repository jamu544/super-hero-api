package android.com.jumpco.io.superheroapi.interfaces;

import android.com.jumpco.io.superheroapi.pojo.SuperheroResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SuperheroService {
   // https://superheroapi.com/api/4278893445508338/245
    @GET("superheroAPI")
    Call<SuperheroResponse> getCurrentSuperheroData(@Query("id") int id);

}
