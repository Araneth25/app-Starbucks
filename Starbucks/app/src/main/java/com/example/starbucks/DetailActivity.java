package com.example.starbucks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.starbucks.Domain.FoodDomain;
import com.example.starbucks.Helper.ManagmentCart;

public class DetailActivity extends AppCompatActivity {
    private Button addToCartBtn;
    private TextView plusBtn, minusBtn, titleTxt, feeTxt, descriptionTxt, numberOrderTxt, startTxt;
    private ImageView picFood, backBtn;
    private FoodDomain object;
    private int numberOrder = 1;
    private ManagmentCart managmentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        managmentCart = new ManagmentCart(DetailActivity.this);

        initView();
        getBundle();
        setVariable();
    }

    private void setVariable() {
        backBtn.setOnClickListener(v -> finish());
    }

    private void getBundle(){
        object = (FoodDomain) getIntent().getSerializableExtra("object");

        int drawableResourceId = this.getResources().getIdentifier(object.getPic(), "drawable",this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picFood);
        titleTxt.setText(object.getTitle());
        feeTxt.setText("S/ "+object.getPrecio());
        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(""+numberOrder);
        startTxt.setText(object.getStar()+"");
        addToCartBtn.setText("Añadido al carrito - S/ "+String.format("%.2f",numberOrder*object.getPrecio()));

        plusBtn.setOnClickListener(v -> {
            numberOrder = numberOrder + 1;
            numberOrderTxt.setText(""+numberOrder);
            addToCartBtn.setText("Añadido al carrito - S/ "+String.format("%.2f",numberOrder*object.getPrecio()));
        });

        minusBtn.setOnClickListener(v -> {
            numberOrder = numberOrder - 1;
            numberOrderTxt.setText(""+numberOrder);
            addToCartBtn.setText("Añadido al carrito - S/ "+String.format("%.2f",numberOrder*object.getPrecio()));
        });

        addToCartBtn.setOnClickListener(v -> {
            object.setNumberCart(numberOrder);
            managmentCart.insertFood(object);
        });
    }

    private void initView(){
        addToCartBtn = findViewById(R.id.addToCartBtn);
        titleTxt = findViewById(R.id.titletxt);
        feeTxt = findViewById(R.id.pricetxt);
        descriptionTxt = findViewById(R.id.description);
        numberOrderTxt = findViewById(R.id.numberItemTxt);
        plusBtn = findViewById(R.id.plusCardBtn);
        minusBtn = findViewById(R.id.MinusCardBtn);
        picFood =  findViewById(R.id.productoPic);
        startTxt = findViewById(R.id.startTxt);
        backBtn = findViewById(R.id.backdBtn);
    }
}