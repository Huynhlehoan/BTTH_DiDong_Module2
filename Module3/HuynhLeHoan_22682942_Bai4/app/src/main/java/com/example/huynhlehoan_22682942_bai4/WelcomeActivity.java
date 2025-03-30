package com.example.huynhlehoan_22682942_bai4;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    private TextView txtWelcome;
    private Button btnLogout, btnSave;
    private SeekBar seekBarSound, seekBarBrightness;
    private RadioGroup radioGroup;
    private RadioButton rdEasy, rdMedium, rdHard;
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "SettingsPrefs";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        txtWelcome = findViewById(R.id.txtWelcome);
        btnLogout = findViewById(R.id.btnLogout);


        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        String username = getIntent().getStringExtra("username");
        txtWelcome.setText("Xin chào, " + username + "!");

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }




    private void logout() {
        SharedPreferences.Editor editor = getSharedPreferences("LoginPrefs", MODE_PRIVATE).edit();
        editor.clear(); // Xóa thông tin đăng nhập
        editor.apply();

        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Đóng WelcomeActivity
    }
}

