package com.example.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    private ArrayList<Product>  productList = new ArrayList<>();
    private Context context;

    public ListAdapter(ArrayList<Product> productList, Context context) {
        this.productList = productList; // Assign the passed list directly
        this.context = context;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Product getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View converView, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.adapter_list_item , null);
        ProductViewHolder productViewHolder = new ProductViewHolder(view);
        productViewHolder.textProductName.setText(productList.get(position).getName());
        productViewHolder.txtProductPrice.setText(String.valueOf(productList.get(position).getPrice()));
        productViewHolder.txtProductDescription.setText(productList.get(position).getDescription());
        productViewHolder.imageProduct.setImageDrawable(context.getDrawable(productList.get(position).getImage()));
        return view;
    }

    public static class ProductViewHolder{
        ImageView imageProduct;
        TextView textProductName , txtProductDescription , txtProductPrice;

        public  ProductViewHolder(View view){
            imageProduct = view.findViewById(R.id.image);
            textProductName = view.findViewById(R.id.name);
            txtProductDescription = view.findViewById(R.id.description);
            txtProductPrice = view.findViewById(R.id.price);

        }
    }
}
