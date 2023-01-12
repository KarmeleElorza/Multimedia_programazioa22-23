package com.example.pcbox_android_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pcbox_android_app.Model.ProductAdapter;
import com.example.pcbox_android_app.Model.Produktua;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Katalogoa extends AppCompatActivity {
    private static Connection conexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katalogoa);
        String txtErabiltzailea_Bidalia = getIntent().getExtras().getString("txtErabiltzailea");
        TextView txtErabiltzailea = (TextView)findViewById(R.id.txtErabiltzailea);
        txtErabiltzailea.setText(txtErabiltzailea_Bidalia);
        ImageView btnHasiera = (ImageView)findViewById(R.id.btnHasiera);
        ImageView btnErosketa = (ImageView)findViewById(R.id.btnErosketa);
        ImageView btnKatalogoa = (ImageView)findViewById(R.id.btnKatalogoa);
        btnHasiera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(getApplicationContext(), Home.class);
                intent.putExtra("txtErabiltzailea",txtErabiltzailea.getText().toString());
                startActivity(intent);
            }
        });
        btnErosketa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(getApplicationContext(), Erosketa.class);
                intent.putExtra("txtErabiltzailea",txtErabiltzailea.getText().toString());
                startActivity(intent);
            }
        });
        ArrayList<Produktua> produktuenZerrenda = Produktua.irakurriProduktuak();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ProductAdapter produkAdapter = new ProductAdapter(produktuenZerrenda, this);
        recyclerView.setAdapter(produkAdapter);
    }
}
