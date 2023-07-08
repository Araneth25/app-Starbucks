package com.example.starbucks.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.starbucks.Domain.CategoryDomain;
import com.example.starbucks.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    ArrayList<CategoryDomain> categoryDomains;

    public CategoryAdapter(ArrayList<CategoryDomain> categoryDomains) {
        this.categoryDomains = categoryDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryName.setText(categoryDomains.get(position).getTitle());
        String picUrl = "";

        switch (position){
            case 0:{
                picUrl = "espres";
                break;
            }
            case 1:{
                picUrl = "merchandising";
                break;
            }
            case 2:{
                picUrl = "boxess";
                break;
            }
            case 3:{
                picUrl = "keke";
                break;
            }
            case 4:{
                picUrl = "cafe";
                break;
            }
            case 5:{
                picUrl = "promo";
                break;
            }
            case 6:{
                picUrl = "sand";
                break;
            }
            case 7:{
                picUrl = "duos";
                break;
            }
            case 8:{
                picUrl="recienhorneados";
                break;
            }
            case 9:{
                picUrl = "postres";
                break;
            }
            case 10:{
                picUrl = "frap";
                break;
            }
            case 11:{
                picUrl = "refresher";
                break;
            }
            case 12:{
                picUrl = "espressofrio";
                break;
            }
            case 13:{
                picUrl = "shakenesp";
                break;
            }
            case 14:{
                picUrl = "newespres";
                break;
            }
            case 15:{
                picUrl = "nuevasbebida";
                break;
            }
            case 16:{
                picUrl = "otrasbebida";
                break;
            }
            case 17:{
                picUrl = "otrosalimentos";
                break;
            }
        }
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(picUrl, "drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.categryPic);
    }

    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView categoryName;
        ImageView categryPic;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categryPic = itemView.findViewById(R.id.categoryPic);
        }
    }
}
