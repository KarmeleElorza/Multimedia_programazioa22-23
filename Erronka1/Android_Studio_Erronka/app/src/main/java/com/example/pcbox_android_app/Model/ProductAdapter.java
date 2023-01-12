package com.example.pcbox_android_app.Model;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pcbox_android_app.Home;
import com.example.pcbox_android_app.Katalogoa;
import com.example.pcbox_android_app.MainActivity;
import com.example.pcbox_android_app.R;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    ArrayList<Produktua> produktuak;
    Context context;

    public ProductAdapter(ArrayList <Produktua> produktuak, Context activity) {
        this.produktuak = produktuak;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_produktuak,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Produktua produktuakList = produktuak.get(position);
        holder.textViewName.setText(produktuakList.getProduktua());
        holder.textViewDate.setText(biDezimalEzarri(produktuakList.getPrezioa()) + "€");
        /*Uri uriImage = Uri.parse("C:\\Users\\elorza.karmele\\Desktop\\Android_Studio_Erronka\\app\\src\\main\\res\\drawable\\vecerosketa.png");
        holder.movieImage.setImageURI(uriImage);*/

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, produktuakList.getProduktua(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return produktuak.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView movieImage;
        TextView textViewName;
        TextView textViewDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.imageArgazkia);
            textViewName = itemView.findViewById(R.id.txtProduktua);
            textViewDate = itemView.findViewById(R.id.txtPrezioa);

        }
    }

    private String biDezimalEzarri(double balorea){
        DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(2); // 2 dezimal definitu
        return format.format(balorea); // formatua aplikatu
    }
}
