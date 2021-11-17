package com.example.android.searchlist;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;
import java.util.Objects;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {
    private Context context;
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

        Glide.with(context).load("https://image.tmdb.org/t/p/w500" + items.get(position).backdrop_path()).error(R.drawable.no_data).into(myViewHolder.img);

        myViewHolder.original_title.setText( items.get(position).original_title());

        myViewHolder.title.setText( items.get(position).title());

        myViewHolder.release_date.setText( items.get(position).release_date());

//        myViewHolder.container.setOnClickListener(view -> {
//            String MovieId = Objects.requireNonNull(items.get(position).id()).toString();
//            Toast.makeText(context, MovieId, Toast.LENGTH_LONG).show();
//        });

        myViewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String MovieId = Objects.requireNonNull(items.get(position).id()).toString();
                Toast.makeText(context, MovieId, Toast.LENGTH_LONG).show();

//                Intent intent = new Intent(context, MovieDetailView.class);
//                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout parentLayout;
        View container;
        ImageView img;
        TextView original_title;
        TextView title;
        TextView release_date;

        public MyViewHolder(View view) {
            super(view);
            context = view.getContext();
            container = view;
            img = view.findViewById(R.id.img);
            original_title = view.findViewById(R.id.original_title);
            title = view.findViewById(R.id.title);
            release_date = view.findViewById(R.id.release_date);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}