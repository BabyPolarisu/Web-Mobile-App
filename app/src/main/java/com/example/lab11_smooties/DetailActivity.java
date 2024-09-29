package com.example.lab11_smooties;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    ImageView background;
    Button back;
    String url = "https://i.imgur.com/3ucD4sr.jpeg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(back);
            }
        });

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String img = intent.getStringExtra("img");
        int price = intent.getIntExtra("price",0);
        String nutrient = intent.getStringExtra("nutrient");
        String detail = intent.getStringExtra("detail");


        background = findViewById(R.id.background);
        Glide.with(this).load(url).into(background);


        ImageView imageView = findViewById(R.id.drink_image);
        Glide.with(this)
                .load(img)
                .into(imageView);


        TextView textView = findViewById(R.id.drink_name);
        TextView textView2 = findViewById(R.id.drink_price);
        textView.setText("ชื่อ: " + name);
        textView2.setText("ราคา: " + price);

        TextView textView3 = findViewById(R.id.drink_nutrient);
        textView3.setText("ส่วนผสม: " + nutrient);

        TextView textView4 = findViewById(R.id.Detail);
        textView4.setText("รายละเอียด: " + detail);

    }
}