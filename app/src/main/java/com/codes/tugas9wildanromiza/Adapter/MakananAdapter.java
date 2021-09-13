package com.codes.tugas9wildanromiza.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.codes.tugas9wildanromiza.DetailWeb;
import com.codes.tugas9wildanromiza.Model.Makanan;
import com.codes.tugas9wildanromiza.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;

public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.MakananViewHolder> {
    private Context context;
    private List<Makanan> makananList = new ArrayList<>();

    public MakananAdapter(Context context, List<Makanan> makananList) {
        this.context = context;
        this.makananList = makananList;
    }


    @NonNull
    @Override
    public com.codes.tugas9wildanromiza.Adapter.MakananAdapter.MakananViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_makanan, parent, false);
        return new MakananViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.codes.tugas9wildanromiza.Adapter.MakananAdapter.MakananViewHolder holder, int position) {
        Makanan makanan = makananList.get(position);
        holder.nama.setText(makanan.getNama());
        holder.harga.setText(makanan.getHarga());
        Glide.with(context)
                .load(makanan.getGambar())
                .centerCrop()
                .into(holder.gambar);
        holder.cl_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailWeb.class);
                intent.putExtra("url",makanan.getUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return makananList.size();
    }

    public class MakananViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView gambar;
        TextView nama,harga;
        ConstraintLayout cl_item;
        public MakananViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama);
            harga = itemView.findViewById(R.id.harga);
            gambar = itemView.findViewById(R.id.gambar);
            cl_item = itemView.findViewById(R.id.cl_item);
        }
    }
}
