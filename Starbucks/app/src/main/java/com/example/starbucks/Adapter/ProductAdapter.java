package com.example.starbucks.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.starbucks.DetailActivity;
import com.example.starbucks.Domain.FoodDomain;
import com.example.starbucks.R;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.Viewholder> {

    ArrayList<FoodDomain> items;
    Context context;

    public ProductAdapter(ArrayList<FoodDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_product,parent,false);
        context = parent.getContext();
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.title.setText(items.get(position).getTitle());
        holder.precio.setText(String.valueOf(items.get(position).getPrecio()));
        holder.star.setText(String.valueOf(items.get(position).getStar()));

        int drawableResourceId = holder.itemView.getResources().getIdentifier(items.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .transform(new GranularRoundedCorners(30,30,0,0 ))
                .into(holder.pic);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("object",items.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        TextView title, precio, star;
        ImageView pic;

        public Viewholder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.title);
            pic = itemView.findViewById(R.id.pic);
            precio = itemView.findViewById(R.id.precio);
            star = itemView.findViewById(R.id.star);
        }
    }
}
