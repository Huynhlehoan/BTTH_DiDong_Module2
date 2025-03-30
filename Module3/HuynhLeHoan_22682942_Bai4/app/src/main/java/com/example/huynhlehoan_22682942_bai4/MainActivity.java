package com.example.huynhlehoan_22682942_bai4;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText edtUser, edtPassword;
    private CheckBox chkSaveInfo;
    private Button btnLogin, btnExit;
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "LoginPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        // Nếu đã lưu đăng nhập, vào thẳng WelcomeActivity
        if (sharedPreferences.getBoolean("checked", false)) {
            Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
            intent.putExtra("username", sharedPreferences.getString("user", ""));
            startActivity(intent);
            finish(); // Đóng MainActivity
            return; // Không chạy tiếp code dưới
        }

        setContentView(R.layout.activity_main);

        edtUser = findViewById(R.id.editcateid);
        edtPassword = findViewById(R.id.editTextTextPassword2);
        chkSaveInfo = findViewById(R.id.checkBox);
        btnLogin = findViewById(R.id.btnDangNhap);
        btnExit = findViewById(R.id.btnThoat);

        restoreLoginInfo();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showExitDialog();
            }
        });
    }


    private void handleLogin() {
        String username = edtUser.getText().toString();
        String password = edtPassword.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            return;
        }

        saveLoginInfo();

        // Chuyển sang WelcomeActivity
        Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }

    private void saveLoginInfo() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (chkSaveInfo.isChecked()) {
            editor.putString("user", edtUser.getText().toString());
            editor.putString("pwd", edtPassword.getText().toString());
            editor.putBoolean("checked", true);
        } else {
            editor.clear();
        }
        editor.apply();
    }

    private void restoreLoginInfo() {
        boolean isChecked = sharedPreferences.getBoolean("checked", false);
        if (isChecked) {
            edtUser.setText(sharedPreferences.getString("user", ""));
            edtPassword.setText(sharedPreferences.getString("pwd", ""));
        }
        chkSaveInfo.setChecked(isChecked);
    }

    private void showExitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xác nhận");
        builder.setMessage("Bạn có chắc muốn thoát không?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
