package com.example.lab11_smooties;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lab11_smooties.model.Drink;
import com.example.lab11_smooties.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Drink> values;
    private Context context;

    public MyAdapter(List<Drink> values, Context context) {
        this.values = values;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgView;
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            imgView = (ImageView) v.findViewById(R.id.icon);
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
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

        final Drink drink = values.get(position);
        holder.txtHeader.setText(drink.getDrink_name());
        holder.txtFooter.setText(drink.getDrink_price() + " บาท");
        Glide.with(context)
                .load(drink.getDrink_image())
                .into(holder.imgView);
        holder.imgView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(context,
                        drink.getDrink_name(),
                        Toast.LENGTH_SHORT);
                toast.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return values.size();
    }

}