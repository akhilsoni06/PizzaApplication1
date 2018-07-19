package com.example.akhil.pizzaapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PizzaListAdapter extends RecyclerView.Adapter<PizzaListAdapter.ItemHolder> {

    private ItemClickListener mListener;
    public PizzaListAdapter(ItemClickListener callBack) {
        this.mListener = callBack;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.pizza_list_item_layoyt, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        holder.mTxtPizzaName.setText("pos=" + position);
        holder.mTxtPizzaType.setText("type=" + position);
    }

    @Override
    public int getItemCount() {
        return 100;
    }


    public class ItemHolder extends RecyclerView.ViewHolder {

        TextView mTxtPizzaName;
        TextView mTxtPizzaType;

        public ItemHolder(View itemView) {
            super(itemView);
            mTxtPizzaName = (TextView) itemView.findViewById(R.id.pizza_name);
            mTxtPizzaType = (TextView) itemView.findViewById(R.id.txt_pizza_size);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemCallBack();
                }
            });

        }
    }


}
