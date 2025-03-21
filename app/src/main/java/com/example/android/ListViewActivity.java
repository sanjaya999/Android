package com.example.android;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;

    private ListAdapter adapter;
    private ArrayList<Product> productList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initToolbar();
        findView();


    }

    private void findView() {
        listView = findViewById(R.id.listView);
        setProductData();

        adapter = new ListAdapter(productList, ListViewActivity.this);
        listView.setAdapter(adapter);
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


}