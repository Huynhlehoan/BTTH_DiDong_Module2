package com.example.huynhlehoan_22682941_module2_bai22;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.imageViewDetail);
        Intent intent = getIntent();

        if (intent != null && intent.hasExtra("imageId")) {
            int imageId = intent.getIntExtra("imageId", 0);
            imageView.setImageResource(imageId);
        }
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            finish(); // Đóng DetailActivity và quay về MainActivity
        });
    }
}

