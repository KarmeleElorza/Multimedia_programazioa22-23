package com.example.pcbox_android_app.Model;

import android.media.Image;

public class Argazkia {
    private String id,name;
    private Image archivo;

    public Argazkia(String argazkia_id, String argazkia_path) {
        this.id = argazkia_id;
        this.name = argazkia_path;
    }

    public Image getArchivo() {
        return archivo;
    }

    public void setArchivo(Image archivo) {
        this.archivo = archivo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.id+" : "+this.name;
    }
}
