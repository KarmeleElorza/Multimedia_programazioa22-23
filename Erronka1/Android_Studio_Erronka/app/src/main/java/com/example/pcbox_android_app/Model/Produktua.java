package com.example.pcbox_android_app.Model;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import static com.example.pcbox_android_app.Model.DatuBaseKonekzioa.connect;

import android.util.Log;

import java.util.ArrayList;


public class Produktua {
    private int id;
    private String produktua;
    private double prezioa;
    public Produktua() {
    }

    public Produktua(int id, String produktua, double prezioa) {
        this.id = id;
        this.produktua = produktua;
        this.prezioa = prezioa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduktua() {
        return produktua;
    }

    public void setProduktua(String produktua) {
        this.produktua = produktua;
    }

    public double getPrezioa() {
        return prezioa;
    }

    public void setPrezioa(double prezioa) {
        this.prezioa = prezioa;
    }

    public static ArrayList<Produktua> irakurriProduktuak(){
        ArrayList<Produktua> produktuak = new ArrayList<>();
        String sql = "SELECT product_template.id, product_template.name,product_template.list_price FROM public.product_template ORDER BY product_template.id";
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try (Connection conn = connect();
                     PreparedStatement stmt = conn.prepareStatement(sql);
                     ResultSet rs = stmt.executeQuery())  {
                    while (rs.next()) {
                        produktuak.add(new Produktua(rs.getInt("id"), rs.getString("name"), rs.getFloat("list_price")));
                    }
                } catch (SQLException e) {
                    Log.e("Produktuak", e.getMessage());
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produktuak;
    }
}
