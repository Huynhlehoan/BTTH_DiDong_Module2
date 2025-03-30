package com.example.huynhlehoan_22682941_module2_bai18;

import android.app.ListActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends ListActivity {
    private TextView textView3;
    private String[] brands = {"Intel", "Samsung", "Nokia", "Xiaomi", "Apple", "Oppo", "Sony", "LG"};
    private View selectedView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Tạo TextView để hiển thị giá trị được chọn
        textView3 = new TextView(this);
        textView3.setTextSize(18);
        textView3.setPadding(20, 20, 20, 20);
        textView3.setBackgroundColor(Color.parseColor("#198E84"));
        textView3.setTextColor(Color.WHITE);
        textView3.setText("Chọn một hãng điện thoại");

        // Thêm TextView vào ListView
        getListView().addHeaderView(textView3);

        // Adapter để hiển thị danh sách
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, brands));

        // Xử lý sự kiện khi chọn một item trong danh sách
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) return; // Bỏ qua header

                // Nếu có item cũ đang chọn, reset màu về mặc định
                if (selectedView != null) {
                    selectedView.setBackgroundColor(Color.TRANSPARENT);
                }

                // Đổi màu item mới được chọn
                view.setBackgroundColor(Color.rgb(104,185,215));
                selectedView = view;

                // Cập nhật TextView
                textView3.setText("Position: " + (position - 1) + "; Value = " + brands[position - 1]);
            }
        });
    }
    }
