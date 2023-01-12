package com.example.pcbox_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Erosketa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erosketa);
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
        btnKatalogoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(getApplicationContext(), Katalogoa.class);
                intent.putExtra("txtErabiltzailea",txtErabiltzailea.getText().toString());
                startActivity(intent);
            }
        });
    }

}