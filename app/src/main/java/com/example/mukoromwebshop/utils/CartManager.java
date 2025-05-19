package com.example.mukoromwebshop.utils;

import java.util.ArrayList;
import java.util.List;
import com.example.mukoromwebshop.models.Product;

public class CartManager {
    private List<Product> cart = new ArrayList<>();
    private Context context;

    public CartManager(Context context) {
        this.context = context;
    }

    public void addToCart(Product product) {
        cart.add(product);
        Toast.makeText(context, "Termék hozzáadva a kosárhoz", Toast.LENGTH_SHORT).show();
    }

    public List<Product> getCart() {
        return cart;
    }

    public void clearCart() {
        cart.clear();
    }
}

