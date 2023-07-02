package com.example.starbucks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.starbucks.Adapter.CategoryAdapter;
import com.example.starbucks.Domain.CategoryDomain;

import java.util.ArrayList;

public class InicioPrincipalActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategory, recyclerViewPopularList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_principal);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

        recyclerViewCategory();
    }

    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategory = findViewById(R.id.view1);
        recyclerViewCategory.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();

        categoryList.add(new CategoryDomain("Cafe","cafe"));
        categoryList.add(new CategoryDomain("Frappuccino","frappuccino"));
        categoryList.add(new CategoryDomain("Granos cafe","granoscafe"));
        categoryList.add(new CategoryDomain("Merchandising","merchandising"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategory.setAdapter(adapter);
    }
}