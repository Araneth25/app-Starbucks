package com.example.starbucks.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.starbucks.Domain.FoodDomain;
import com.example.starbucks.Helper.ChangeNumberItemsListener;
import com.example.starbucks.Helper.ManagmentCart;
import com.example.starbucks.R;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {

    ArrayList<FoodDomain> listfoodSelected;
    private ManagmentCart managmentCart;
    ChangeNumberItemsListener changeNumberItemsListener;

    public CartListAdapter(ArrayList<FoodDomain> listfoodSelected, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.listfoodSelected = listfoodSelected;
        managmentCart = new ManagmentCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart,parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(listfoodSelected.get(position).getTitle());
        holder.precioEachItem.setText("S/" +String.format("%.2f",listfoodSelected.get(position).getPrecio()));
        holder.totalEachItem.setText("S/ "+String.format("%.2f",listfoodSelected.get(position).getNumberCart()*listfoodSelected.get(position).getPrecio()));
        holder.num.setText(String.valueOf(listfoodSelected.get(position).getNumberCart()));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(listfoodSelected.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .transform(new GranularRoundedCorners(30,30,30,30))
                .into(holder.pic);

        holder.plusItem.setOnClickListener(v -> managmentCart.plusNumberFood(listfoodSelected,position, () ->{
            notifyDataSetChanged();
            changeNumberItemsListener.changed();
        }));

        holder.minuItem.setOnClickListener(v -> managmentCart.minusNumberFood(listfoodSelected,position, () ->{
            notifyDataSetChanged();
            changeNumberItemsListener.changed();
        }));
    }

    @Override
    public int getItemCount() {
        return listfoodSelected.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, precioEachItem, plusItem, minuItem;
        ImageView pic;
        TextView totalEachItem, num;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            pic = itemView.findViewById(R.id.pic);
            precioEachItem = itemView.findViewById(R.id.precioEachItem);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
            plusItem = itemView.findViewById(R.id.plusCartBtn);
            minuItem = itemView.findViewById(R.id.minusCartBtn);
            num = itemView.findViewById(R.id.numberItemTxt);
        }
    }
}
