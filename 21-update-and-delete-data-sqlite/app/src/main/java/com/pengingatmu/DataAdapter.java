package com.pengingatmu;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

    private ArrayList idList, titleList;
    private Context ctx;
    private DBConfig config;
    private SQLiteDatabase db;

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

        // event long click / tahan pada pada
        holder.cardView.setOnLongClickListener(v -> {

            // Bottom Sheet Dialog
            BottomSheetDialog bsdOption = new BottomSheetDialog(ctx);
            bsdOption.setContentView( LayoutInflater.from(ctx.getApplicationContext()).inflate( R.layout.bottom_sheet_dialog, null ) );

            // kasih event kalo update nya yang di click
            bsdOption.findViewById(R.id.option_edit).setOnClickListener(v1 -> {
                intent = new Intent(ctx, EditActivity.class);
                intent.putExtra("id", id);
                ctx.startActivity(intent);
            });

            // kalo delete nya yang di klik
            bsdOption.findViewById(R.id.option_delete).setOnClickListener( v2 -> {
                deleteData(id);
                bsdOption.dismiss();
            });

            bsdOption.show();

            return false;
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

    private void deleteData( String id )
    {

        // Alert Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle("Yakin ingin menghapus data?")
                .setItems(new CharSequence[]{"Ya, hapus", "Tidak"}, (dialog, which) -> {

                    // switch case
                    switch (which){

                        case 0 :
                            db = config.getReadableDatabase();
                            db.execSQL("DELETE FROM notes WHERE id = '" + id + "'");
                            Toast.makeText(ctx, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
                            ((MainActivity)ctx).showData();
                            break;

                    }

                });
        builder.show();
    }

}
