package com.twodev.booksfilmslists.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.twodev.booksfilmslists.R;
import com.twodev.booksfilmslists.interfaces.OnItemClickListener;
import com.twodev.booksfilmslists.models.Example;
import com.twodev.booksfilmslists.models.FilmModel;

import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogViewHolder> {
    List<String> list;
    OnItemClickListener mClickListener;

    public DogAdapter(List<String> list, OnItemClickListener listener) {
        this.mClickListener = listener;
        this.list = list;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mClickListener = listener;
    }

    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dog_view_holder, parent, false);
        return new DogViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull DogViewHolder holder, int position) {
        holder.band(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DogViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public DogViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.dog_title_tv);
            itemView.setOnClickListener(view -> mClickListener.onClick(getAdapterPosition()));
        }

        public void band(String example) {
            textView.setText(example);

        }
    }
}
