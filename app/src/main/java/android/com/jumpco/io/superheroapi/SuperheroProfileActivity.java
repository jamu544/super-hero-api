package android.com.jumpco.io.superheroapi;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.com.jumpco.io.superheroapi.interfaces.Api2;
import android.com.jumpco.io.superheroapi.interfaces.RetroFitHelper;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SuperheroProfileActivity extends AppCompatActivity  {


    ImageView profileimage;
    TextView nameTextView,powerstatsTextView,
            biographyTextView,appearanceTextView,
            workTextView,connectionsTextView;

    //testing two

    public String URL = "https://superheroapi.com/api/4278893445508338/";
    public Context context;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        context = this;
        init();
        getCurrentHeroInfo();
    }
    // initailize widgets
    private void init(){
        profileimage=(ImageView)findViewById(R.id.profile_image);
        nameTextView =(TextView)findViewById(R.id.nameID);
        powerstatsTextView=(TextView)findViewById(R.id.powerstatsID);
//        biographyTextView=(TextView)findViewById(R.id.biographyID);
//        appearanceTextView=(TextView)findViewById(R.id.appearanceID);
//        workTextView=(TextView)findViewById(R.id.workID);
//        connectionsTextView=(TextView)findViewById(R.id.connectionsID);
    }

    // get response from the server...get id from listview
    public void getCurrentHeroInfo(){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        RetroFitHelper client = retrofit.create(RetroFitHelper.class);
        Call<Api2> call = client.findSuperhero("150");

        call.enqueue(new Callback<Api2>() {
            /**
             * Invoked for a received HTTP response.
             * <p>
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call {@link Response#isSuccessful()} to determine if the response indicates success.
             *
             * @param call
             * @param response
             */
            @Override
            public void onResponse(Call<Api2> call, Response<Api2> response) {
                String resultName = response.body().name;

                Toast.makeText(context," The word is: " + resultName ,Toast.LENGTH_LONG).show();

                     nameTextView.setText(resultName);
                    powerstatsTextView.setText(response.body().powerStats.intelligence+" "+response.body().powerStats.strength
                    +" "+response.body().powerStats.speed+" "+response.body().powerStats.durability+"  " +
                            ""+response.body().powerStats.power+"  "+
                            response.body().powerStats.combat );

//                    biographyTextView.setText(biography);
//                    appearanceTextView.setText(appearance);
//                    workTextView.setText(work);
//                    connectionsTextView.setText(connections);
            }

            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected
             * exception occurred creating the request or processing the response.
             *
             * @param call
             * @param t
             */
            @Override
            public void onFailure(Call<Api2> call, Throwable t) {
                Toast.makeText(context," Error..." ,Toast.LENGTH_LONG).show();
                System.out.println("Error "+ t.getMessage());

            }


        });


    }

}