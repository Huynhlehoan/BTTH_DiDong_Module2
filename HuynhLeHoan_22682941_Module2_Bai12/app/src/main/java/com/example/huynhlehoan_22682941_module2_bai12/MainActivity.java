package com.example.huynhlehoan_22682941_module2_bai12;

import android.content.DialogInterface;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUser = findViewById(R.id.editcateid);
        edtPassword = findViewById(R.id.editTextTextPassword2);
        chkSaveInfo = findViewById(R.id.checkBox);
        btnLogin = findViewById(R.id.btn1);
        btnExit = findViewById(R.id.btn2);

        // Xử lý nút Đăng nhập
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });

        // Xử lý nút Thoát
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showExitDialog();
            }
        });
    }

    private void handleLogin() {
        String message = "Chào mừng bạn đăng nhập hệ thống, bạn " +
                (chkSaveInfo.isChecked() ? "đã lưu thông tin" : "không lưu thông tin");
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void showExitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xác nhận");
        builder.setMessage("Bạn có chắc muốn thoát không?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish(); // Thoát ứng dụng
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