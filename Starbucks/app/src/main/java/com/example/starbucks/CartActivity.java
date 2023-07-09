package com.example.starbucks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.starbucks.Adapter.CartListAdapter;
import com.example.starbucks.Helper.ChangeNumberItemsListener;
import com.example.starbucks.Helper.ManagmentCart;
import com.example.starbucks.R;

public class CartActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagmentCart managmentCart;
    private double igv;
    private TextView totalpreciotxt, totaltxt, emptytxt, igvtxt;
    private ScrollView scrollView;
    private ImageView backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        managmentCart= new ManagmentCart(this);

        initView();
        initList();
        calcularCart();
        setVariable();
    }

    private void setVariable() {
        backbtn.setOnClickListener(v -> finish());
    }

    private void initView(){
        totalpreciotxt = findViewById(R.id.subtotalTxt);
        igvtxt = findViewById(R.id.igvTxt);
        totaltxt = findViewById(R.id.totalTxt);
        recyclerViewList = findViewById(R.id.view3);
        scrollView = findViewById(R.id.scrollViewC);
        backbtn = findViewById(R.id.backBtn);
        emptytxt = findViewById(R.id.emptyTxt);

    }

    private void initList(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter(managmentCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                calcularCart();
            }
        });

        recyclerViewList.setAdapter(adapter);

        if(managmentCart.getListCart().isEmpty()){
            emptytxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }else{
            emptytxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void calcularCart(){
        double percentageIgv = 0.18 ;
        igv =  Math.round((managmentCart.getTotalPrecio()*percentageIgv*100.0))/100.0;

        double total = Math.round((managmentCart.getTotalPrecio()+igv)*100.0)/100;
        double itemTotal = Math.round(managmentCart.getTotalPrecio()*100.0)/100.0;

        totalpreciotxt.setText("S/"+itemTotal);
        igvtxt.setText("S/"+igv);
        totaltxt.setText("S/"+total);
    }
}