package android.com.jumpco.io.superheroapi.interfaces;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetroFitHelper {
//    public static String BaseUrl = "https://superheroapi.com/api/4278893445508338/";

    // search using id
    @GET("https://superheroapi.com/api/4278893445508338/{id}")
    Call<Api2> findSuperhero(@Path("id") String id);


    // search using name
    @GET("https://superheroapi.com/api/4278893445508338/search/{name}")
    Call<Api2> findSuperheroByName(@Path("name") String name);

}
