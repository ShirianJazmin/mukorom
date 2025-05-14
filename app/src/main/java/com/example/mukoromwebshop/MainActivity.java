package com.example.mukoromwebshop;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mukoromwebshop.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Navigáció, pl. bejelentkezés gomb
        findViewById(R.id.loginBtn).setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
        });
    }
}