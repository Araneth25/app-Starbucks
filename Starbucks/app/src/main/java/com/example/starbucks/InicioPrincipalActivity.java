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
        foodDomains.add(new FoodDomain("Croissant de mantequilla","Nuestro croissant de mantequilla es un delicioso y clásico producto de panadería, apreciado por su sabor excepcional y su cuidadosa elaboración artesanal. Con una apariencia tentadora, se presenta como un hojaldre triangular, que a simple vista revela su textura dorada y escamosa.", "cromante", 5.83, 4));
        foodDomains.add(new FoodDomain("Sweet Pack", "Es una selección de dulces irresistibles que te deleitarán en cada bocado. Con una variedad de sabores y texturas, es la opción perfecta para satisfacer tus antojos dulces. En Starbucks, nos encanta endulzar tu día con nuestro Sweet Pack","spack", 35.00,5));
        foodDomains.add(new FoodDomain("Desayuno para dos", "Es la elección perfecta para comenzar el día con energía. Incluye una combinación de bebidas calientes y frescas, junto con deliciosos panes y pastelería recién horneada. Nos esforzamos por ofrecer desayunos memorables que satisfagan todos los gustos y te preparen para un gran día","dosdesayuno", 25.00,4.5));
        foodDomains.add(new FoodDomain("Desayuno familiar", "En Starbucks Perú es una opción ideal para compartir momentos especiales en familia. Incluye una variedad de bebidas y delicias matutinas que todos disfrutarán. En Starbucks nos preocupamos por crear experiencias memorables y sabores que unan a las familias en cada desayuno.","desayunofamiliar", 49.00,5));
        foodDomains.add(new FoodDomain("Duo engreimiento", "Es una opción perfecta para consentirte a ti mismo o a alguien especial. Combina una bebida deliciosa con un postre tentador, ofreciendo una experiencia de indulgencia en solo dos elementos.","engreduo", 9.00,5));

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