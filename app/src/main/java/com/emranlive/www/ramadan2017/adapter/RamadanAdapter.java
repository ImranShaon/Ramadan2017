package com.emranlive.www.ramadan2017.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.emranlive.www.ramadan2017.R;
import com.emranlive.www.ramadan2017.model.Ramadan;

import java.util.List;

/**
 * Created by Imran on 5/13/2017.
 */

public class RamadanAdapter extends RecyclerView.Adapter<RamadanAdapter.Holder> {

    List<Ramadan> list;
    int layoutId;

    public RamadanAdapter(List<Ramadan> list, int layoutId) {
        this.list = list;
        this.layoutId = layoutId;
    }

    @Override
    public RamadanAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RamadanAdapter.Holder holder, int position) {
        holder.rojaTextView.setText(list.get(position).getNoOfRoja());
        holder.dateTextView.setText(list.get(position).getDate());
        holder.sehriTimeTextView.setText(list.get(position).getSehriTime());
        holder.iftarTimeTextView.setText(list.get(position).getIftarTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        TextView rojaTextView,dateTextView,sehriTimeTextView,iftarTimeTextView;

        public Holder(View itemView) {
            super(itemView);

            rojaTextView = (TextView) itemView.findViewById(R.id.rojaTextView);
            dateTextView = (TextView) itemView.findViewById(R.id.dateTextView);
            sehriTimeTextView = (TextView) itemView.findViewById(R.id.sehriTimeTextView);
            iftarTimeTextView = (TextView) itemView.findViewById(R.id.iftarTimeTextView);
        }
    }

}
