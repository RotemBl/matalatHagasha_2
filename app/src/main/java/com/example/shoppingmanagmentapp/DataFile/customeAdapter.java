package com.example.shoppingmanagmentapp.DataFile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingmanagmentapp.R;

import java.util.ArrayList;

public class customeAdapter extends RecyclerView.Adapter<customeAdapter.MyViewHolder> {
     private ArrayList<DataModle> dataset;

    public customeAdapter(ArrayList<DataModle> dataSet) {
        this.dataset = dataSet;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {



        DataModle currentItem = dataset.get(position);

        holder.textViewName.setText(currentItem.getItemName());
        holder.textViewquantity.setText(String.valueOf(currentItem.getQuantity()));
        holder.imageViewitem.setImageResource(currentItem.getImage());
        holder.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = currentItem.getQuantity();
                quantity++;
                currentItem.setQuantity(quantity);
                holder.textViewquantity.setText(String.valueOf(quantity));
            }
        });
        holder.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = currentItem.getQuantity();
                if (quantity > 0) {
                    quantity--;
                    currentItem.setQuantity(quantity);
                    holder.textViewquantity.setText(String.valueOf(quantity));
                }
            }
        });


        holder.addToCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add the current item to the cart
                CartItems cartItem = new CartItems(currentItem.getItemName(), currentItem.getQuantity(), currentItem.getImage());
                MyData.cartItemsList.add(cartItem);

                // Optionally, display a toast message
                Toast.makeText(v.getContext(), "Item added to cart", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewquantity;
        ImageView imageViewitem;
        Button plusButton;
        Button minusButton;
        Button addToCardButton;


        public MyViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.itemNameTextView);
            textViewquantity = itemView.findViewById(R.id.quantitytextView);
            imageViewitem = itemView.findViewById(R.id.itemImage);
            plusButton = itemView.findViewById(R.id.plusButton);
            minusButton=itemView.findViewById(R.id.minusButton);
            addToCardButton = itemView.findViewById(R.id.addToCardButton);

        }

    }
}

