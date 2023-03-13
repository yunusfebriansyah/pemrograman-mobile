package com.pengingatmu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

    private ArrayList idList, titleList;
    private Context ctx;
    private DBConfig config;

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

        holder.txtId.setText(idList.get(position).toString());
        holder.txtJudul.setText(titleList.get(position).toString());

    }

    @Override
    public int getItemCount() {
        return idList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtId, txtJudul;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            txtId = itemView.findViewById(R.id.txt_id);
            txtJudul = itemView.findViewById(R.id.txt_judul);
        }

    }

}
