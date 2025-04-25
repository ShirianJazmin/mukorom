package com.example.mukoromwebshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);
        Button goToRegisterButton = findViewById(R.id.goToRegisterButton);

        // Bejelentkezés gomb
        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (!email.isEmpty() && !password.isEmpty()) {
                Toast.makeText(this, "Sikeres bejelentkezés!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Kérjük, töltse ki az emailt és a jelszót!", Toast.LENGTH_SHORT).show();
            }
        });


        goToRegisterButton.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}
