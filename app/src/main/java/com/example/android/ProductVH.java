package com.example.android;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ProductVH extends RecyclerView.ViewHolder {
    ImageView imageProduct;
    TextView textProductName , txtProductDescription , txtProductPrice;
    public ProductVH(@NonNull View view) {
        super(view);
        imageProduct = view.findViewById(R.id.image);
        textProductName = view.findViewById(R.id.name);
        txtProductDescription = view.findViewById(R.id.description);
        txtProductPrice = view.findViewById(R.id.price);
    }
}
