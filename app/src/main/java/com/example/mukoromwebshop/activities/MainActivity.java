package com.example.mukoromwebshop.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import com.example.mukoromwebshop.R;
import com.example.mukoromwebshop.adapters.ProductAdapter;
import com.google.android.gms.analytics.ecommerce.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProductAdapter adapter;
    ArrayList<Product> productList = new ArrayList<>();
    Button cartBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cartBtn = findViewById(R.id.cartBtn);
        recyclerView = findViewById(R.id.recyclerView);

        loadProducts();
        adapter = new ProductAdapter(productList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        cartBtn.setOnClickListener(v -> startActivity(new Intent(this, CartActivity.class)));
    }

    private void loadProducts() {
        productList.add(new Product("Rózsaszín műköröm", "Szép rózsaszín gél lakk", R.drawable.nail1, 1990));
        productList.add(new Product("Csillámos műköröm", "Parti stílusú csillámos szett", R.drawable.nail2, 2490));
    }
}
