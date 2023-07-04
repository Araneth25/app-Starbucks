package com.example.starbucks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.starbucks.Adapter.CategoryAdapter;
import com.example.starbucks.Adapter.ProductAdapter;
import com.example.starbucks.Domain.CategoryDomain;
import com.example.starbucks.Domain.FoodDomain;

import java.util.ArrayList;

public class InicioPrincipalActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategory, recyclerViewFoodList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_principal);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

        recyclerViewCategory();
        recyclerViewFoodList();
    }

    private void recyclerViewFoodList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerViewFoodList = findViewById(R.id.view2);
        recyclerViewFoodList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodDomains = new ArrayList<>();
        foodDomains.add(new FoodDomain("Croissant de mantequilla", "cromante", 5.83, 4));
        foodDomains.add(new FoodDomain("Sweet Pack", "spack", 35.00,5));
        foodDomains.add(new FoodDomain("Desayuno para dos", "desayunoparados", 25.00,4.5));
        foodDomains.add(new FoodDomain("Desayuno familiar", "desayunofamiliar", 49.00,5));
        foodDomains.add(new FoodDomain("Duo engreimiento", "duoen", 9.00,5));

        adapter2 = new ProductAdapter(foodDomains);
        recyclerViewFoodList.setAdapter(adapter2);
    }

    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategory = findViewById(R.id.view1);
        recyclerViewCategory.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();

        categoryList.add(new CategoryDomain("Café en granos","espres"));
        categoryList.add(new CategoryDomain("Merchandising","merchandising"));
        categoryList.add(new CategoryDomain("Boxes","boxess"));
        categoryList.add(new CategoryDomain("Keke","keke"));
        categoryList.add(new CategoryDomain("Café en grano","cafe"));
        categoryList.add(new CategoryDomain("Promociones","promocioness"));
        categoryList.add(new CategoryDomain("Sándwiches","sand"));
        categoryList.add(new CategoryDomain("Duos","duosg"));
        categoryList.add(new CategoryDomain("Recién Horneados","recienhorneadoss"));
        categoryList.add(new CategoryDomain("Postres","postress"));
        categoryList.add(new CategoryDomain("Frappuccinos","frap"));
        categoryList.add(new CategoryDomain("Refreshers","refreshers"));
        categoryList.add(new CategoryDomain("Espresso Frío","espressofrio"));
        categoryList.add(new CategoryDomain("Shaken Espresso","shakenes"));
        categoryList.add(new CategoryDomain("Espresso","newespres"));
        categoryList.add(new CategoryDomain("Nuevas bebidas","nuevasbebid"));
        categoryList.add(new CategoryDomain("Otras bebidas","otrasbebidas"));
        categoryList.add(new CategoryDomain("Otros alimentos","otrosalimentoss"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategory.setAdapter(adapter);
    }
}