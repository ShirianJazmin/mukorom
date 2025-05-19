package com.example.mukoromwebshop.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mukoromwebshop.R;
import com.example.mukoromwebshop.models.Product;
import com.example.mukoromwebshop.utils.CartManager;


public class ProductDetailsActivity extends AppCompatActivity {
    ImageView image;
    TextView title, description, price;
    Button addToCartBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        image = findViewById(R.id.productImage);
        title = findViewById(R.id.productTitle);
        description = findViewById(R.id.productDescription);
        price = findViewById(R.id.productPrice);
        addToCartBtn = findViewById(R.id.addToCartBtn);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int imageRes = extras.getInt("image");
            String name = extras.getString("name");
            String desc = extras.getString("description");
            int priceVal = extras.getInt("price");

            image.setImageResource(imageRes);
            title.setText(name);
            description.setText(desc);
            price.setText(priceVal + " Ft");

            addToCartBtn.setOnClickListener(v -> {
                CartManager.getInstance().addToCart(new Product(name, desc, imageRes, priceVal));
                finish();
            });
        }
    }
}
