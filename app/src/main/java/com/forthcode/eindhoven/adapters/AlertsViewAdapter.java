package com.forthcode.eindhoven.adapters;

/**
 * Created by Chetan.Nayak on 2017-04-20.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.forthcode.eindhoven.R;
import com.forthcode.eindhoven.model.pNotification;

import java.util.List;

public class AlertsViewAdapter extends RecyclerView.Adapter<AlertsViewAdapter.MyViewHolder> {
    private List<pNotification> alertList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title,message;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.tvalert);
            message = (TextView) view.findViewById(R.id.tvmsg);
        }
    }


    public AlertsViewAdapter(List<pNotification> alertList) {
        this.alertList = alertList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.alerts_display, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        pNotification movie = alertList.get(position);
        holder.title.setText(movie.getpTitle());
        holder.message.setText(movie.getpMessage());
    }

    @Override
    public int getItemCount() {
        return alertList.size();
    }
}