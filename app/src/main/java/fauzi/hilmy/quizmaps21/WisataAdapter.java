package fauzi.hilmy.quizmaps21;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import fauzi.hilmy.quizmaps21.model.Wisata;

import static fauzi.hilmy.quizmaps21.DetailActivity.EX_DETAIL;
import static fauzi.hilmy.quizmaps21.DetailActivity.EX_GAMBAR;
import static fauzi.hilmy.quizmaps21.DetailActivity.EX_LAT;
import static fauzi.hilmy.quizmaps21.DetailActivity.EX_LONG;
import static fauzi.hilmy.quizmaps21.DetailActivity.EX_NAMA;

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.MyViewHolder> {
    private ArrayList<Wisata> wisatas;
    private Context context;

    public WisataAdapter(ArrayList<Wisata> wisatas, Context context) {
        this.wisatas = wisatas;
        this.context = context;
    }

    @NonNull
    @Override
    public WisataAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WisataAdapter.MyViewHolder myViewHolder, final int i) {
        myViewHolder.txt.setText(wisatas.get(i).getNama());
        Picasso.with(context)
                .load(wisatas.get(i).getGambar())
                .fit()
                .into(myViewHolder.img);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(context, DetailActivity.class);
                inte.putExtra(EX_NAMA, wisatas.get(i).getNama());
                inte.putExtra(EX_LAT, wisatas.get(i).getLati());
                inte.putExtra(EX_DETAIL, wisatas.get(i).getDetail());
                inte.putExtra(EX_GAMBAR, wisatas.get(i).getGambar());
                inte.putExtra(EX_LONG, wisatas.get(i).getLongi());
                context.startActivity(inte);
            }
        });
    }

    @Override
    public int getItemCount() {
        return wisatas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgWisata);
            txt = itemView.findViewById(R.id.txtNamaWisata);
        }
    }
}
