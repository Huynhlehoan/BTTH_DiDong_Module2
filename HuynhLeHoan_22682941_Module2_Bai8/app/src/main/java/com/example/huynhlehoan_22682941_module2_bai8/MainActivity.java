package com.example.huynhlehoan_22682941_module2_bai8;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnHieu = findViewById(R.id.btnHieu);
        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edita = findViewById(R.id.txtA);
                EditText editb = findViewById(R.id.txtB);
                TextView result = findViewById(R.id.textView4);

                int a = Integer.parseInt(edita.getText().toString());
                int b = Integer.parseInt(editb.getText().toString());

                result.setText(String.valueOf(a - b));
            }
        });
        Button btnTich = findViewById(R.id.btnTich);
        btnTich.setOnClickListener(this);


        View.OnClickListener listenerThuong = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edita = findViewById(R.id.txtA);
                EditText editb = findViewById(R.id.txtB);
                TextView txtResult = findViewById(R.id.textView4);

                int a = Integer.parseInt(edita.getText().toString());
                int b = Integer.parseInt(editb.getText().toString());
                if (b != 0) {
                    txtResult.setText(String.valueOf((double) a / b));
                } else {
                    txtResult.setText("Không thể chia cho 0");
                }
            }
        };
        Button btnThuong = findViewById(R.id.btnThuong);
        btnThuong.setOnClickListener(listenerThuong);

        EditText edita = findViewById(R.id.txtA);
        EditText editb = findViewById(R.id.txtB);
        TextView txtResult = findViewById(R.id.textView4);
        Button btnUCLN = findViewById(R.id.btnUCLN);
        btnUCLN.setOnClickListener(new UCLNListener(edita, editb, txtResult));

        Button btnThoat = findViewById(R.id.btnThoat);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Xác nhận thoát")
                        .setMessage("Bạn có chắc muốn thoát ứng dụng không?")
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finishAffinity();
                                System.exit(0);
                            }
                        })
                        .setNegativeButton("Không", null)
                        .show();
            }
        });

    }
    public void tinhTong(View view) {
        EditText edita = findViewById(R.id.txtA);
        EditText editb = findViewById(R.id.txtB);
        TextView txtResult = findViewById(R.id.textView4);

        int a = Integer.parseInt(edita.getText().toString());
        int b = Integer.parseInt(editb.getText().toString());
        int sum = a + b;

        txtResult.setText(String.valueOf(sum));
    }

    @Override
    public void onClick(View v) {
        EditText edita = findViewById(R.id.txtA);
        EditText editb = findViewById(R.id.txtB);
        TextView txtResult = findViewById(R.id.textView4);

        int a = Integer.parseInt(edita.getText().toString());
        int b = Integer.parseInt(editb.getText().toString());

        if (v.getId() == R.id.btnTich) {
            txtResult.setText(String.valueOf(a * b));
        }
    }
}

