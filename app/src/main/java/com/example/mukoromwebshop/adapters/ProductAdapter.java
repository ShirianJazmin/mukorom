package com.example.mukoromwebshop.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mukoromwebshop.R;
import com.example.mukoromwebshop.models.Product;
import com.example.mukoromwebshop.utils.CartManager;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    private List<Product> productList;
    private CartManager cartManager;

    public ProductAdapter(Context context, List<Product> productList, CartManager cartManager) {
        this.context = context;
        this.productList = productList;
        this.cartManager = cartManager;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.nameText.setText(product.getName());
        holder.descriptionText.setText(product.getDescription());
        holder.priceText.setText(product.getPrice() + " Ft");
        holder.imageView.setImageResource(product.getImageResId());

        holder.addButton.setOnClickListener(v -> cartManager.addToCart(product));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView nameText, descriptionText, priceText;
        ImageView imageView;
        Button addButton;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.product_name);
            descriptionText = itemView.findViewById(R.id.product_description);
            priceText = itemView.findViewById(R.id.product_price);
            imageView = itemView.findViewById(R.id.product_image);
            addButton = itemView.findViewById(R.id.button_add);
        }
    }
}