package com.example.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.movie.MovieResults;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductVH> {


    private ArrayList<MovieResults> movieResults = new ArrayList<>();
    private Context mContext;


    public ProductAdapter(ArrayList<MovieResults> dataList, Context context){
//        movieResults.clear();
        this.movieResults = dataList;
        this.mContext = context;


    }
    @NonNull
    @Override
    public ProductVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_list_item , parent , false);
        return new ProductVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductVH holder, int position) {
        holder.textProductName.setText(movieResults.get(position).getTitle());
        holder.txtProductPrice.setText(String.valueOf(movieResults.get(position).getOverview()));
        holder.txtProductDescription.setText(movieResults.get(position).getReleaseDate());
//        holder.imageProduct.setImageDrawable(mContext.getDrawable(movieResults.get(position).getImage()));
        Picasso.get().load("https://image.tmdb.org/t/p/w500/" + movieResults.get(position).getPosterPath()).into(holder.imageProduct);
    }


    @Override
    public int getItemCount() {
        return movieResults.size();
    }
}
