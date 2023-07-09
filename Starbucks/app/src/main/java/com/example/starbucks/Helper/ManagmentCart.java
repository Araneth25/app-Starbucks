package com.example.starbucks.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.starbucks.Domain.FoodDomain;

import java.util.ArrayList;

public class ManagmentCart {

    private Context context;
    private TinyDB tinyDB;

    public ManagmentCart(Context context){
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(FoodDomain item){
        ArrayList<FoodDomain> listFood = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int x = 0; x < listFood.size() ; x++){
            if (listFood.get(x).getTitle().equals(item.getTitle())){
                existAlready = true;
                n = x ;
                break;
            }
        }

        if(existAlready){
            listFood.get(n).setNumberCart(item.getNumberCart());
        }else{
            listFood.add(item);
        }
        tinyDB.putListObject("CartList",listFood);
        Toast.makeText(context,"Añadido al carrito",Toast.LENGTH_SHORT).show();
    }

    public ArrayList<FoodDomain> getListCart(){
        return tinyDB.getListObject("CartList");
    }

    public void minusNumberFood(ArrayList<FoodDomain> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener){

        if(listfood.get(position).getNumberCart() == 1){
           listfood.remove(position);
        }else{
            listfood.get(position).setNumberCart(listfood.get(position).getNumberCart()-1);
        }

        tinyDB.putListObject("CartList",listfood);
        changeNumberItemsListener.changed();
    }

    public void plusNumberFood(ArrayList<FoodDomain> listfood, int position,ChangeNumberItemsListener changeNumberItemsListener){

        listfood.get(position).setNumberCart(listfood.get(position).getNumberCart()+1);
        tinyDB.putListObject("CartList",listfood);
        changeNumberItemsListener.changed();
    }

    public Double getTotalPrecio(){

        ArrayList<FoodDomain> listfood2 = getListCart();
        double fee = 0;

        for(int i = 0; i < listfood2.size(); i++){
            fee = fee + (listfood2.get(i).getPrecio()*listfood2.get(i).getNumberCart());
        }

        return fee;

    }
}