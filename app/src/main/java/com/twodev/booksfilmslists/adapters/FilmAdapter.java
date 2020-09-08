package com.twodev.booksfilmslists.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.twodev.booksfilmslists.R;
import com.twodev.booksfilmslists.interfaces.OnItemClickListener;
import com.twodev.booksfilmslists.models.FilmModel;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.BookViewHolder> {
    List<FilmModel> list;
    OnItemClickListener mClickListener;

    public FilmAdapter(List<FilmModel> list, OnItemClickListener listener) {
        this.mClickListener = listener;
        this.list = list;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mClickListener = listener;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_view_holder_layout, parent, false);
        return new BookViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.band(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        ImageView bookImage;
        TextView bookTitle;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            bookImage = itemView.findViewById(R.id.book_image_view);
            bookTitle = itemView.findViewById(R.id.book_title_tv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mClickListener.onClick(getAdapterPosition());
                }
            });
        }

        public void band(FilmModel filmModel) {
            bookTitle.setText(filmModel.getTitle());
        }
    }
}
