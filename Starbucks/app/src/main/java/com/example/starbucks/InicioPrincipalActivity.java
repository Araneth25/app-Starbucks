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
        foodDomains.add(new FoodDomain("Frezzer chocolate", "freezdes", 9.10));
        foodDomains.add(new FoodDomain("Cafe con crema de vainilla", "cafecremades", 10.53));

        adapter2 = new ProductAdapter(foodDomains);
        recyclerViewFoodList.setAdapter(adapter2);
    }

    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategory = findViewById(R.id.view1);
        recyclerViewCategory.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();

        categoryList.add(new CategoryDomain("Café en granos","granoscafe"));
        categoryList.add(new CategoryDomain("Merchandising","merchandising"));
        categoryList.add(new CategoryDomain("Boxes","boxess"));
        categoryList.add(new CategoryDomain("Keke","keke"));
        categoryList.add(new CategoryDomain("Café en grano","cafe"));
        categoryList.add(new CategoryDomain("Promociones","promociones"));
        categoryList.add(new CategoryDomain("Sándwiches","sandwich"));
        categoryList.add(new CategoryDomain("Duos","duos"));
        categoryList.add(new CategoryDomain("Recién Horneados","recienhorneados"));
        categoryList.add(new CategoryDomain("Postres","postres"));
        categoryList.add(new CategoryDomain("Frappuccinos","frap"));
        categoryList.add(new CategoryDomain("Refreshers","refresher"));
        categoryList.add(new CategoryDomain("Espresso Frío","espressofrio"));
        categoryList.add(new CategoryDomain("Shaken Espresso","shakenespres"));
        categoryList.add(new CategoryDomain("Espresso","espresso"));
        categoryList.add(new CategoryDomain("Nuevas bebidas","nuevasbebidas"));
        categoryList.add(new CategoryDomain("Otras bebidas","otrasbebidas"));
        categoryList.add(new CategoryDomain("Otros alimentos","otrosalimentoss"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategory.setAdapter(adapter);
    }
}