package com.girlswearingleather.app.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.girlswearingleather.app.R;
import com.girlswearingleather.app.model.CardItem;

import java.util.List;

/**
 * Created by Dani on 13/09/2015.
 */
public class CardItemAdapter extends RecyclerView.Adapter<CardItemAdapter.CardItemViewHolder>{

    private List<CardItem> itemList;

    public CardItemAdapter(List<CardItem> itemList){
        this.itemList = itemList;
    }

    @Override
    public int getItemCount(){
        return itemList.size();
    }

    @Override
    public void onBindViewHolder(CardItemViewHolder contactViewHolder, int i) {
        CardItem ci = itemList.get(i);
        contactViewHolder.vName.setText(ci.name);
        contactViewHolder.vSurname.setText(ci.surname);
    }

    @Override
    public CardItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View item = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_item_layout,viewGroup,false);
        return new CardItemViewHolder(item);
    }

    public static class CardItemViewHolder extends RecyclerView.ViewHolder{

        protected TextView vName;
        protected TextView vSurname;

        public CardItemViewHolder(View v){
            super(v);
            vName = (TextView)v.findViewById(R.id.name);
            vSurname = (TextView)v.findViewById(R.id.surname);
        }
    }
}
