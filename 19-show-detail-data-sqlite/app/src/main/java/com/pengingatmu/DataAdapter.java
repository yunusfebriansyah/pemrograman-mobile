package com.pengingatmu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

    private ArrayList idList, titleList;
    private Context ctx;
    private DBConfig config;

    private Intent intent;

    public DataAdapter(Context ctx, ArrayList idList, ArrayList titleList) {
        this.ctx = ctx;
        this.idList = idList;
        this.titleList = titleList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        config = new DBConfig(listItemView.getContext());
        return new ViewHolder(listItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String id = idList.get(position).toString();

        holder.txtId.setText(id);
        holder.txtJudul.setText(titleList.get(position).toString());

        // event click listener saat data di click
        holder.cardView.setOnClickListener( v -> {
            intent = new Intent(ctx, DetailActivity.class);
            intent.putExtra("id", id);
            ctx.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return idList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtId, txtJudul;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            txtId = itemView.findViewById(R.id.txt_id);
            txtJudul = itemView.findViewById(R.id.txt_judul);
            cardView = itemView.findViewById(R.id.card_view);
        }

    }

}
