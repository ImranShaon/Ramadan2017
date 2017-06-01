package com.emranlive.www.ramadan2017.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.emranlive.www.ramadan2017.R;
import com.emranlive.www.ramadan2017.model.ExtraDoya;

import java.util.List;

/**
 * Created by Imran on 5/17/2017.
 */

public class ExtraDoyaAdapter extends RecyclerView.Adapter<ExtraDoyaAdapter.Holder> {
    private List<ExtraDoya> list;

    public ExtraDoyaAdapter(List<ExtraDoya> list){
        this.list = list;
    }

    @Override
    public ExtraDoyaAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.extra_doya_layout,parent,false);

        return new ExtraDoyaAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(ExtraDoyaAdapter.Holder holder, int position) {
        holder.extraTitleTextView.setText(list.get(position).getDoyaTitle());
        holder.extraDetailsTextView.setText(list.get(position).getDoyaDetails());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView extraTitleTextView,extraDetailsTextView;
        public Holder(View itemView) {
            super(itemView);
            extraTitleTextView = (TextView) itemView.findViewById(R.id.extraTitleTextView);
            extraDetailsTextView = (TextView) itemView.findViewById(R.id.extraDetailsTextView);
        }
    }
}
