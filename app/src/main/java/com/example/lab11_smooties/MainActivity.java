package com.example.lab11_smooties;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab11_smooties.model.Drink;
import com.example.lab11_smooties.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<Drink> drinks = new ArrayList<Drink>();
        Drink drink = new Drink();
        drink.setDrink_name("โก้โก้ปั่น");
        drink.setDrink_image("https://d9p8enmph3kvc.cloudfront.net/static/media/recipe/2023/11/08/17/cca0/1699437950.1716.jpg");
        drink.setDrink_price(40);
        drinks.add(drink);

        Drink drink2 = new Drink();
        drink2.setDrink_name("สตอเบอรี่ปั่น");
        drink2.setDrink_image("https://img.wongnai.com/p/1920x0/2019/04/09/6a7aa08690af420cb9e18179bd5cd56e.jpg");
        drink2.setDrink_price(40);
        drinks.add(drink2);

        Drink drink3 = new Drink();
        drink3.setDrink_name("ส้มปั่น");
        drink3.setDrink_image("https://www.ofm.co.th/blog/wp-content/uploads/2022/03/%E0%B8%9B%E0%B8%A3%E0%B8%B0%E0%B9%82%E0%B8%A2%E0%B8%8A%E0%B8%99%E0%B9%8C%E0%B8%82%E0%B8%AD%E0%B8%87%E0%B8%99%E0%B9%89%E0%B8%B3%E0%B8%9C%E0%B8%A5%E0%B9%84%E0%B8%A1%E0%B9%89-1.jpg");
        drink3.setDrink_price(35);
        drinks.add(drink3);

        Drink drink4 = new Drink();
        drink4.setDrink_name("อโวคาโดปั่น");
        drink4.setDrink_image("https://www.naibann.com/blog/wp-content/uploads/2015/11/23-frozen-drink-recipes-1.png");
        drink4.setDrink_price(40);
        drinks.add(drink4);

        Drink drink5 = new Drink();
        drink5.setDrink_name("มะพร้าวปั่น");
        drink5.setDrink_image("https://menu-ded.com/wp-content/uploads/2023/02/%E0%B8%99%E0%B9%89%E0%B8%B3%E0%B8%A1%E0%B8%B0%E0%B8%9E%E0%B8%A3%E0%B9%89%E0%B8%B2%E0%B8%A71.webp");
        drink5.setDrink_price(40);
        drinks.add(drink5);

        mAdapter = new MyAdapter(drinks, this);
        recyclerView.setAdapter(mAdapter);
//hees

    }
}