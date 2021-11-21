package android.com.jumpco.io.superheroapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.app.ProgressDialog;
import android.com.jumpco.io.superheroapi.adapters.SuperheroAdapter;
import android.com.jumpco.io.superheroapi.adapters.SuperheroListAdapter;
import android.com.jumpco.io.superheroapi.interfaces.Api2;
import android.com.jumpco.io.superheroapi.interfaces.RetroFitHelper;
import android.com.jumpco.io.superheroapi.pojo.Results;
import android.com.jumpco.io.superheroapi.pojo.RetrofitClient;
import android.com.jumpco.io.superheroapi.pojo.SuperheroPojo;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity  {


//    This is besides the point (in a way), but the REST API should really have an
//    endpoint to give you the list directly. It feels quite wrong to
//    issue N requests this way, let alone guessing IDs by increment. –
//    Joffrey




    public static String BaseUrl = "https://superheroapi.com/api/4278893445508338/";
    public static String AppId = "4278893445508338";
    public static  int ID = 245;
    //https://superheroapi.com/api/4278893445508338/245

    //tut
    ListView superListView;

    //superhero using jsoup
    ArrayList<SuperheroPojo> superHeros;
    RecyclerView recyclerView;
    ProgressDialog progressDialog;
    String url = "https://superheroapi.com/ids.html";
    ArrayList<SuperheroPojo> idList = new ArrayList<>();
    public SuperheroListAdapter adapter;
    public SuperheroAdapter adapter2;
    public Context context;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tut
        context = this;

        superListView = findViewById(R.id.superListView);

        superListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //get superhero and pass intent
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                Intent n = new Intent(getApplicationContext(), SuperheroProfileActivity.class);
                n.putExtra("id", position);
                startActivity(n);
                Toast.makeText(getApplicationContext(), "HERO #"+position, Toast.LENGTH_SHORT).show();            }
        });

        //Lookup the recycler in activity
     //   recyclerView = (RecyclerView) findViewById(R.id.rvSuperHero);

        new ListOfSuperoTask ().execute();


    }

    //tut
    private void getSuperHeroes() {
        Call<List<Results>> call = RetrofitClient.getInstance().getMyApi().getsuperHeroes();
        //     Call<List<Results>> call = RetrofitClient.getInstance().getMyApi().getsuperHeroes2(ID);

        call.enqueue(new Callback<List<Results>>() {
            @Override
            public void onResponse(Call<List<Results>> call, Response<List<Results>> response) {
                List<Results> myheroList = response.body();
                String[] oneHeroes = new String[myheroList.size()];

                for (int i = 0; i < myheroList.size(); i++) {
                    oneHeroes[i] = myheroList.get(i).superName;
                }

                //      superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, oneHeroes));
            }

            @Override
            public void onFailure(Call<List<Results>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured "+t.toString(), Toast.LENGTH_LONG).show();
                System.out.println("Error  "+t.toString());
            }

        });
    }

    private class ListOfSuperoTask extends AsyncTask<String,String,String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Loading...");
            progressDialog.show();

        }

        @Override
        protected String doInBackground(String... strings) {
            Document document = null;


            try {
                //connect to website
                document = Jsoup.connect(url).get();

                //get title of the website
              //  title = document.title();

               //select table first
                org.jsoup.nodes.Element table = document.select("table").get(0);

                Iterator<Element> row = table.select("tr").iterator();
                row.next(); //Skipping the <th>

                while (row.hasNext()) {
                    Iterator<org.jsoup.nodes.Element> ite = ((org.jsoup.nodes.Element) row.next()).select("td").iterator();
                    SuperheroPojo pojo = new SuperheroPojo();
                    pojo.superHeroID = ite.next().text();
                    pojo.superHeroName = ite.next().text();
                    idList.add(pojo);

                }
                org.jsoup.nodes.Element table2 = document.select("table").get(1);//select table first
                Iterator<org.jsoup.nodes.Element> row2 = table2.select("tr").iterator();
                row2.next(); //Skipping the <th>

                while (row2.hasNext()) {
                    Iterator<org.jsoup.nodes.Element> ite = ((org.jsoup.nodes.Element) row2.next()).select("td").iterator();
                    SuperheroPojo pojo = new SuperheroPojo();
                    pojo.superHeroID = ite.next().text();
                    pojo.superHeroName = ite.next().text();
                    idList.add(pojo);

                }
                org.jsoup.nodes.Element table3 = document.select("table").get(2);//select table first
                Iterator<org.jsoup.nodes.Element> row3 = table3.select("tr").iterator();
                row3.next(); //Skipping the <th>

                while (row3.hasNext()) {
                    Iterator<org.jsoup.nodes.Element> ite = ((org.jsoup.nodes.Element) row3.next()).select("td").iterator();
                    SuperheroPojo pojo = new SuperheroPojo();
                    pojo.superHeroID = ite.next().text();
                    pojo.superHeroName = ite.next().text();
                    idList.add(pojo);

                }
            //    adapter = new SuperheroListAdapter(idList);
                adapter2 = new SuperheroAdapter(context,idList);

            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
        @Override
        protected void onPostExecute(String results) {
            super.onPostExecute(results);
            System.out.println(" results == "+results);
            progressDialog.dismiss();
//            textView.setText(title);
            superListView.setAdapter(adapter2);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate menu with items using menuInflator
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        //Initailize menu item search bar
        //with id and take its object

        MenuItem searchViewItem = menu.findItem(R.id.search_bar);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        // attach setOnQueryTextListener
        // to search view defined above
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//
//            // Override onQueryTextSubmit method
//            // which is call
//            // when submitquery is searched
//
//            @Override
//            public boolean onQueryTextSubmit(String query)
//            {
//                // If the list contains the search query
//                // than filter the adapter
//                // using the filter method
//                // with the query as its argument
//                if (mylist.contains(query)) {
//                    adapter.getFilter().filter(query);
//                }
//                else {
//                    // Search query not found in List View
//                    Toast.makeText(MainActivity.this,"Not found",Toast.LENGTH_LONG).show();
//                }
//                return false;
//            }
//
//            // This method is overridden to filter
//            // the adapter according to a search query
//            // when the user is typing search
//            @Override
//            public boolean onQueryTextChange(String newText)
//            {
//                adapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//


        return super.onCreateOptionsMenu(menu);
    }




}