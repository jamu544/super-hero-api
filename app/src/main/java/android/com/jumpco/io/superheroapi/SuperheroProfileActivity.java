package android.com.jumpco.io.superheroapi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.app.ProgressDialog;
import android.com.jumpco.io.superheroapi.interfaces.Api2;
import android.com.jumpco.io.superheroapi.interfaces.RetroFitHelper;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.util.Locale;

public class SuperheroProfileActivity extends AppCompatActivity  implements View.OnClickListener, TextWatcher {


    private ImageView profileimage;
    private TextView nameTextView,biographyTextView,fullNameTextView,
            placeOfBirthTextView,appearanceTextView,
            publisherTextView,alignmentTextView,occupationTextTView,groupAffiliationTextTview,relativesTextView;
    private Button searchButton;
    private ProgressDialog progressDialog;
    private EditText searchHero;
 //   private ProgressBar progressBarForImage;
    private String name;


    public String URL = "https://superheroapi.com/api/4278893445508338/";
    public Context context;


    private static final String TAG = "SuperheroProfileActvty";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        context = this;
        Log.d(TAG,"On Create" );
        init();

//        Log.e("ApiUrl = ", "MyApiUrl") (error)
//                Log.w("ApiUrl = ", "MyApiUrl") (warning)
//                Log.i("ApiUrl = ", "MyApiUrl") (information)
//                Log.d("ApiUrl = ", "MyApiUrl") (debug)
//                Log.v("ApiUrl = ", "MyApiUrl") (verbose)
    }
    // initailize widgets
    private void init(){
        profileimage=(ImageView)findViewById(R.id.profilePhoto);
        nameTextView =(TextView)findViewById(R.id.nameID);
        biographyTextView =(TextView)findViewById(R.id.biography_id);
        fullNameTextView = (TextView) findViewById(R.id.fullName_id);
        placeOfBirthTextView = (TextView) findViewById(R.id.placeOfBirth_id);
        appearanceTextView = (TextView) findViewById(R.id.firstAppearance_id);
        publisherTextView = (TextView) findViewById(R.id.publisher_id);
        alignmentTextView = (TextView) findViewById(R.id.alignment_id);
        occupationTextTView = (TextView) findViewById(R.id.occupation_id);
        groupAffiliationTextTview = (TextView) findViewById(R.id.groupAffiliation_id);
        relativesTextView = (TextView) findViewById(R.id.relatives_id);
        searchButton = (Button) findViewById(R.id.button_id);
        searchButton.setOnClickListener(this);
        searchHero = (EditText) findViewById(R.id.search_hero_id);
        searchHero.addTextChangedListener(this);
     //   progressBarForImage = (ProgressBar) findViewById(R.id.progress);
        Log.d(TAG,"On Create - init" );


    }

    // get response from the server...get id from listview
    public void getCurrentHeroInfo(String heroName){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        RetroFitHelper client = retrofit.create(RetroFitHelper.class);
        Call<Api2> call = client.findSuperhero(heroName);

        //Set up progress before call

        progressDialog = new ProgressDialog(SuperheroProfileActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        // show it
        progressDialog.show();

        call.enqueue(new Callback<Api2>() {

            @Override
            public void onResponse(Call<Api2> call, Response<Api2> response) {


                String resultName = response.body().name;
                Toast.makeText(context," The word is: " + resultName ,Toast.LENGTH_LONG).show();

                    nameTextView.setText(resultName);
                    fullNameTextView.setText(response.body().biography.fullName);
                    placeOfBirthTextView.setText(response.body().biography.placeOfBirth);
                    appearanceTextView.setText(response.body().biography.firstAppearance);
                    publisherTextView.setText(response.body().biography.publisher);
                    alignmentTextView.setText(response.body().biography.alignment);
                    occupationTextTView.setText(response.body().work.occupation);
                    groupAffiliationTextTview.setText(response.body().connections.groupAffiliation);
                    relativesTextView.setText(response.body().connections.relatives);


                   Glide.with(context)
                        .load(response.body().image.url)
//                           .apply(new RequestOptions()
//                                   .placeholder(R.color.colorPrimary)
//                                   .dontAnimate().skipMemoryCache(true))
//                           .listener(new RequestListener<Drawable>() {
//                               @Override
//                               public boolean onLoadFailed(@Nullable  GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                                   progressBarForImage.setVisibility(View.GONE);
//                                   return false;
//                               }
//
//                               @Override
//                               public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                                   progressBarForImage.setVisibility(View.GONE);
//                                   return false;
//                               }
//                           })
                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                        .into(profileimage);

                   Log.d("Image response", response.body().image.url.toString());
                   progressDialog.dismiss();

            }


            @Override
            public void onFailure(Call<Api2> call, Throwable t) {
                Toast.makeText(context," Error..." ,Toast.LENGTH_LONG).show();

                Log.e("Error", t.getMessage());
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate menu with items using MenuInflator
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.superhero_profile_menu, menu);

        //Initialise menu item search bar
        // with id take its object
        MenuItem searchViewItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);

        //attach setOnQueryTextListener to serach view defined above
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // Override onQueryTextSubmit method which is call when submitquery is searched
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String charText) {

                charText = charText.toLowerCase(Locale.getDefault());
              //  getCurrentHeroInfo(charText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_id:
                if(checkInternetConnectivity()) {
                    getCurrentHeroInfo(name);
                    Log.i("Info log", "Search Button Clicked");
                }
                else {
                    Log.w(TAG, "No Internet connection!!!");
                }

            default:
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

        name = editable.toString();
    }

    //check internet connection for both MOBILE and WIFI
    private boolean checkInternetConnectivity(){
        boolean haveConnectionWifi = false;
        boolean haveConnectedMobile = false;
        ConnectivityManager cm =((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE));
        NetworkInfo[] networkInfos = cm.getAllNetworkInfo();

        for (NetworkInfo in : networkInfos){
            if(in.getTypeName().equalsIgnoreCase("WIFI"))
                if(in.isConnected())
                    haveConnectionWifi = true;
            if(in.getTypeName().equalsIgnoreCase("MOBILE"))
                if(in.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectionWifi || haveConnectedMobile;
    }

    //detect Orientation changes
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //Checks the orientaion of the screen
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(this, "landscape",Toast.LENGTH_SHORT).show();
        }
        else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait",Toast.LENGTH_SHORT).show();
        }
    }
}