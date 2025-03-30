package com.example.module2_bai27;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnThemAlbum, btnXemAlbum, btnQuanLyBaiHat;
    ArrayList<Album> albumList = new ArrayList<>();
    ArrayAdapter<Album> albumAdapter;
    ListView lvAlbums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvAlbums = findViewById(R.id.lvAlbum);
        albumList.add(new Album(1, "Album 1"));
        albumList.add(new Album(2, "Album 2"));

        btnThemAlbum = findViewById(R.id.btnThemAlbum);
        btnXemAlbum = findViewById(R.id.btnXemAlbum);
        btnQuanLyBaiHat = findViewById(R.id.btnQuanLyBaiHat);
        // Adapter dùng Custom Layout
        albumAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, albumList);
        lvAlbums.setAdapter(albumAdapter);


        btnThemAlbum.setOnClickListener(v -> openDialogThemAlbum());
        // Xem danh sách Album

        btnXemAlbum.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuanLyAlbum.class);
            intent.putParcelableArrayListExtra("albums", albumList);
            startActivity(intent);
        });

        btnQuanLyBaiHat.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuanLyBaiHatActivity.class);
            intent.putParcelableArrayListExtra("albums", albumList);
            startActivity(intent);
        });
        //chinh sua khi click vao
        lvAlbums.setOnItemClickListener((parent, view, position, id) -> openDialogChinhSuaAlbum(position));
        //xoa khi nhan giu lau
        lvAlbums.setOnItemLongClickListener((parent, view, position, id) -> {
            confirmDeleteAlbum(position);
            return true;
        });

    }

    private void openDialogThemAlbum() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_them_album);
        EditText edtMaAlbum = dialog.findViewById(R.id.edtMaAlbum);
        EditText edtTenAlbum = dialog.findViewById(R.id.edtTenAlbum);
        Button btnLuu = dialog.findViewById(R.id.btnLuuAlbum);
        Button btnXoaTrang = dialog.findViewById(R.id.btnXoaTrang);

        btnLuu.setOnClickListener(v -> {
            int ma = Integer.parseInt(edtMaAlbum.getText().toString());
            String ten = edtTenAlbum.getText().toString();
            albumList.add(new Album(ma, ten));
            dialog.dismiss();
        });

        btnXoaTrang.setOnClickListener(v -> {
            edtMaAlbum.setText("");
            edtTenAlbum.setText("");
            edtMaAlbum.requestFocus();
        });

        dialog.show();
    }
    private void openDialogChinhSuaAlbum(int position) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_them_album);
        EditText edtMaAlbum = dialog.findViewById(R.id.edtMaAlbum);
        EditText edtTenAlbum = dialog.findViewById(R.id.edtTenAlbum);
        Button btnLuu = dialog.findViewById(R.id.btnLuuAlbum);
        Button btnXoaTrang = dialog.findViewById(R.id.btnXoaTrang);

        Album album = albumList.get(position);
        edtMaAlbum.setText(String.valueOf(album.getMa()));
        edtTenAlbum.setText(album.getTen());

        btnLuu.setText("Update");
        btnLuu.setOnClickListener(v -> {
            album.setMa(Integer.parseInt(edtMaAlbum.getText().toString()));
            album.setTen(edtTenAlbum.getText().toString());
            albumAdapter.notifyDataSetChanged();
            dialog.dismiss();
        });

        btnXoaTrang.setOnClickListener(v -> {
            edtMaAlbum.setText("");
            edtTenAlbum.setText("");
            edtMaAlbum.requestFocus();
        });

        dialog.show();
    }

    // Xác nhận xóa Album
    private void confirmDeleteAlbum(int position) {
        new AlertDialog.Builder(this)
                .setTitle("Xóa Album")
                .setMessage("Bạn có chắc muốn xóa Album này?")
                .setPositiveButton("Có", (dialog, which) -> {
                    albumList.remove(position);
                    albumAdapter.notifyDataSetChanged();
                })
                .setNegativeButton("Không", null)
                .show();
    }
}
