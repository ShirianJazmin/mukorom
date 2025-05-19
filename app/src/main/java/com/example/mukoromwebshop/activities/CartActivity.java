package com.example.mukoromwebshop.activities;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mukoromwebshop.R;
import com.example.mukoromwebshop.models.Product;
import com.example.mukoromwebshop.utils.CartManager;

import java.util.List;

public class CartActivity extends AppCompatActivity {
    TextView cartContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartContent = findViewById(R.id.cartContent);
        List<Product> cartItems = CartManager.getInstance().getCartItems();

        StringBuilder builder = new StringBuilder();
        int total = 0;
        for (Product p : cartItems) {
            builder.append(p.getName()).append(" - ").append(p.getPrice()).append(" Ft\n");
            total += p.getPrice();
        }

        builder.append("\nÖsszesen: ").append(total).append(" Ft");
        cartContent.setText(builder.toString());
    }
}

