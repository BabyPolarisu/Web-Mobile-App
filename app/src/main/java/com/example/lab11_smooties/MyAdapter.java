package com.example.lab11_smooties;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lab11_smooties.model.Drink;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Drink> drinkList;
    private Context context;

    public MyAdapter(List<Drink> drinks, Context context) {
        this.drinkList = drinks;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drink_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Drink drink = drinkList.get(position);
        holder.drinkName.setText(drink.getDrink_name());
        holder.drinkPrice.setText("Price: " + drink.getDrink_price() + " THB");

        // ใช้ Glide ในการโหลดรูปภาพจาก URL
        Glide.with(context)
                .load(drink.getDrink_image())
                .into(holder.drinkImage);

        // เพิ่มการคลิกเพื่อแสดงรายละเอียด
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, detail.class);
                intent.putExtra("drink_name", drink.getDrink_name());
                intent.putExtra("drink_image", drink.getDrink_image());
                intent.putExtra("drink_price", drink.getDrink_price());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return drinkList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView drinkName;
        public ImageView drinkImage;
        public TextView drinkPrice;

        public ViewHolder(View view) {
            super(view);
            drinkName = view.findViewById(R.id.drink_name);
            drinkImage = view.findViewById(R.id.drink_image);
            drinkPrice = view.findViewById(R.id.drink_price);
        }
    }
}
