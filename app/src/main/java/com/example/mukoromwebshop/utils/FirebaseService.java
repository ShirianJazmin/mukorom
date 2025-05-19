package com.example.mukoromwebshop.utils;

import android.annotation.SuppressLint;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseService {
    public static FirebaseAuth auth = FirebaseAuth.getInstance();
    @SuppressLint("StaticFieldLeak")
    public static FirebaseFirestore db = FirebaseFirestore.getInstance();
}
