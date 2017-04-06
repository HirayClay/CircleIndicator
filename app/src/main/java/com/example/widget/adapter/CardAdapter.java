package com.example.widget.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.widget.R;

import java.util.List;

/**
 * Created by CJJ on 2017/3/7.
 *
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<String> datas;

    public CardAdapter(List<String> datas) {
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null)
            inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.item_card,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(datas.get(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return datas == null?0:datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.name);
        }
    }
}
