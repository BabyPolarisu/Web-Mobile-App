package com.example.lab11_smooties;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String drinkName = getIntent().getStringExtra("drink_name");
        String drinkImage = getIntent().getStringExtra("drink_image");
        int drinkPrice = getIntent().getIntExtra("drink_price", 0);

        TextView nameTextView = findViewById(R.id.drink_name);
        ImageView imageView = findViewById(R.id.drink_image);
        TextView priceTextView = findViewById(R.id.drink_price);

        nameTextView.setText(drinkName);
        priceTextView.setText("ราคา: " + drinkPrice + " บาท");

        Glide.with(this)
                .load(drinkImage)
                .into(imageView);
    }
}
