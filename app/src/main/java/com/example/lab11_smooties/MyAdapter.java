package com.example.lab11_smooties;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView; // Import from androidx
import com.bumptech.glide.Glide;
import com.example.lab11_smooties.model.Drink;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Drink> values;
    private Context context;

    public MyAdapter(List<Drink> values, Context context) {
        this.values = values;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder { // Extend ViewHolder from androidx
        public ImageView imgView;
        public TextView txtHeader;
        public TextView txtFooter,txtThirdLine;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            imgView = v.findViewById(R.id.icon);
            txtHeader = v.findViewById(R.id.firstLine);
            txtFooter = v.findViewById(R.id.secondLine);
            txtThirdLine= v.findViewById(R.id.thirdline);

        }
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Drink chat = values.get(position);
        holder.txtHeader.setText(chat.getDrink_name());
        holder.txtFooter.setText("ราคา: " + chat.getDrink_price());
        holder.txtThirdLine.setText("กดที่รูปเพื่อดูรายละเอียด");
        Glide.with(context)
                .load(chat.getDrink_image())
                .into(holder.imgView);

        holder.imgView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("name", chat.getDrink_name());
            intent.putExtra("img", chat.getDrink_image());
            intent.putExtra("price", chat.getDrink_price());
            intent.putExtra("nutrient", chat.getDrink_nutrient());
            intent.putExtra("detail", chat.getDetail());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}

//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.example.lab11_smooties.model.Drink;
//
//import java.util.List;
//
//public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
//
//    private List<Drink> drinkList;
//    private Context context;
//
//    public MyAdapter(List<Drink> drinks, Context context) {
//        this.drinkList = drinks;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.activity_detail, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Drink drink = drinkList.get(position);
//        holder.txtHeader.setText(drink.getDrink_name());
//        holder.txtFooter.setText("ราคา: " + drink.getDrink_price() + " บาท");
//        Glide.with(context)
//                .load(drink.getDrink_image())
//                .into(holder.imgView);
//
//        holder.imgView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, DetailActivity.class);
//                intent.putExtra("drink_name", drink.getDrink_name());
//                intent.putExtra("drink_image", drink.getDrink_image());
//                intent.putExtra("drink_price", drink.getDrink_price());
//                context.startActivity(intent);
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return drinkList.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder { // Extend ViewHolder from androidx
//        public ImageView imgView;
//        public TextView txtHeader;
//        public TextView txtFooter,txtThirdLine;
//        public View layout;
//
//        public ViewHolder(View v) {
//            super(v);
//            layout = v;
//            imgView = v.findViewById(R.id.icon);
//            txtHeader = v.findViewById(R.id.firstLine);
//            txtFooter = v.findViewById(R.id.secondLine);
//        }
//    }
//}
