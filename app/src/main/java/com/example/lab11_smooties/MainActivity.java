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
        drink.setDrink_image("https://i.imgur.com/WOGHtyS.png");
        drink.setDrink_price(40);
        drinks.add(drink);

        Drink drink2 = new Drink();
        drink2.setDrink_name("สตอเบอรี่ปั่น");
        drink2.setDrink_image("https://i.imgur.com/bYK164a.png");
        drink2.setDrink_price(40);
        drinks.add(drink2);

        Drink drink3 = new Drink();
        drink3.setDrink_name("ส้มปั่น");
        drink3.setDrink_image("https://i.imgur.com/mG6iOMS.png");
        drink3.setDrink_price(35);
        drinks.add(drink3);

        Drink drink4 = new Drink();
        drink4.setDrink_name("อโวคาโดปั่น");
        drink4.setDrink_image("https://i.imgur.com/C0UIt5i.png");
        drink4.setDrink_price(40);
        drinks.add(drink4);

        Drink drink5 = new Drink();
        drink5.setDrink_name("มะพร้าวปั่น");
        drink5.setDrink_image("https://i.imgur.com/267XXRS.png");
        drink5.setDrink_price(40);
        drinks.add(drink5);

        mAdapter = new MyAdapter(drinks, this);
        recyclerView.setAdapter(mAdapter);


    }
}