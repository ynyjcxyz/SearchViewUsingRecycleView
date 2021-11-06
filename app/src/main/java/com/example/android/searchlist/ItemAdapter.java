package com.example.android.searchlist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {
    private final Context context;
    private final List<Item> items;

    public ItemAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, @SuppressLint("RecyclerView") final int position){
        myViewHolder.container.setOnClickListener(v -> {
            String message = items.get(position).id().toString();
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
//            Intent intent = new Intent(context, MovieDetail.class);
//            intent.putExtra("message",message);
//            context.startActivity(intent);
        });

        Glide.with(context).load("https://image.tmdb.org/t/p/w500" + items.get(position).backdrop_path()).error(R.drawable.no_data).into(myViewHolder.img);

        myViewHolder.original_title.setText( items.get(position).original_title());

        myViewHolder.title.setText( items.get(position).title());

        myViewHolder.release_date.setText( items.get(position).release_date());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        View container;
        ImageView img;
        TextView original_title;
        TextView title;
        TextView release_date;

        public MyViewHolder(View view) {
            super(view);
            container = view;
            img = view.findViewById(R.id.img);
            original_title = view.findViewById(R.id.original_title);
            title = view.findViewById(R.id.title);
            release_date = view.findViewById(R.id.release_date);
        }
    }
}
