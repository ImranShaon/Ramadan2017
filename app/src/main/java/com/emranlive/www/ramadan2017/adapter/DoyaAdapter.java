package com.emranlive.www.ramadan2017.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.emranlive.www.ramadan2017.R;
import com.emranlive.www.ramadan2017.model.Doya;

import java.util.List;

/**
 * Created by Imran on 5/14/2017.
 */

public class DoyaAdapter extends RecyclerView.Adapter<DoyaAdapter.DoyaHolder>{

    private List<Doya> list;

    public DoyaAdapter(List<Doya> list){
        this.list = list;
    }

    @Override
    public DoyaAdapter.DoyaHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doya_layout,parent,false);

        return new DoyaHolder(view);
    }

    @Override
    public void onBindViewHolder(DoyaAdapter.DoyaHolder holder, int position) {
        holder.titleTextView.setText(list.get(position).getNoOfRamadan());
        holder.arabicTextView.setText(list.get(position).getDoyaArabic());
        holder.banglaTextView.setText(list.get(position).getDoyaBangla());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DoyaHolder extends RecyclerView.ViewHolder {

        TextView titleTextView,arabicTextView,banglaTextView;

        public DoyaHolder(View itemView) {
            super(itemView);

            titleTextView = (TextView) itemView.findViewById(R.id.doyaTitleitleTextView);
            arabicTextView = (TextView) itemView.findViewById(R.id.arabicTextView);
            banglaTextView = (TextView) itemView.findViewById(R.id.banglaTextView);
        }
    }
}
