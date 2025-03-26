package com.example.android;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.movie.MovieResults;
import com.example.android.movie.movieContainer;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ProductRecyclerViewActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private ArrayList<Product> productList = new ArrayList<>();

    private movieContainer movieData;
    private ArrayList<MovieResults> movieResultList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_recycler_view);
        initToolbar();
        JSONAsyncTask jsonAsyncTask = new JSONAsyncTask();
        jsonAsyncTask.execute();
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                findView();
            }
        },5000 );

    }
    private void findView(){
        recyclerView = findViewById(R.id.recyclerView);


    }
    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("List View");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setProductData() {
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        Product p4 = new Product();
        p1.setName("Subarna");
        p1.setDescription("Male");
        p1.setPrice(200);
        p1.setImage(R.drawable.girlstudy);

        p2.setName("ruzin");
        p2.setDescription("male");
        p2.setPrice(150);
        p2.setImage(R.drawable.home);

        p3.setName("samip");
        p3.setDescription("male");
        p3.setPrice(100);
        p3.setImage(R.drawable.nature);

        p4.setName("utshav");
        p4.setDescription("male");
        p4.setPrice(50);
        p4.setImage(R.drawable.tree);

        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);


    }

    class JSONAsyncTask extends AsyncTask<Void , Void , Boolean >{

        ProgressDialog progressDialog = new ProgressDialog(ProductRecyclerViewActivity.this);



        @Override
        protected void  onPreExecute() {
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(false);
            progressDialog.show();
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url("https://api.themoviedb.org/3/movie/upcoming?api_key=ef8f48b43832a9e95b87408bf739ed51").build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    Log.d("error" , String.valueOf(e.getLocalizedMessage()));
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    progressDialog.dismiss();
                    if(response.isSuccessful()){
                        String jsonObject = response.body().string();
                        Gson gsonObject = new Gson();
                        movieData = gsonObject.fromJson(jsonObject , movieContainer.class);
                        movieResultList.clear();
                        movieResultList.addAll(movieData.getResultList());
                        adapter = new ProductAdapter(movieResultList , ProductRecyclerViewActivity.this);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ProductRecyclerViewActivity.this , LinearLayoutManager.HORIZONTAL , false);
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(ProductRecyclerViewActivity.this , 2);
                        recyclerView.setLayoutManager(linearLayoutManager

                        );
                        recyclerView.setAdapter(adapter);
                    }
                }
            });

            return null;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {

            super.onPostExecute(aBoolean);
        }

    }

}