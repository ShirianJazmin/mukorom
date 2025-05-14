package com.example.mukoromwebshop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mukoromwebshop.R;
import com.example.mukoromwebshop.FirebaseService;

public class LoginActivity extends AppCompatActivity {
    private EditText emailInput, passwordInput;
    private Button loginBtn, registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginBtn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.registerBtn);

        loginBtn.setOnClickListener(v -> login());
        registerBtn.setOnClickListener(v -> register());
    }

    private void login() {
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        FirebaseService.auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    startActivity(new Intent(this, com.example.mukoromwebshop.MainActivity.class));
                    finish();
                })
                .addOnFailureListener(e -> Toast.makeText(this, "Sikertelen bejelentkezés", Toast.LENGTH_SHORT).show());
    }

    private void register() {
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        FirebaseService.auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> Toast.makeText(this, "Sikeres regisztráció", Toast.LENGTH_SHORT).show())
                .addOnFailureListener(e -> Toast.makeText(this, "Sikertelen regisztráció", Toast.LENGTH_SHORT).show());
    }
}