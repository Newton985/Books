package com.fineapps.books.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.fineapps.books.R;
import com.fineapps.books.databinding.BookItemBinding;
import com.fineapps.books.models.Volume;
import com.fineapps.books.models.VolumesResponse;
import com.fineapps.books.viewholder.BooksViewHolder;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksViewHolder> {
    List<Volume> volumes;

    public BooksAdapter(List<Volume> volumes){
         this.volumes=volumes;
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        BookItemBinding bookItemBinding= DataBindingUtil.inflate(inflater, R.layout.book_item, parent,false);
        return new BooksViewHolder(bookItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {
        Volume volume=volumes.get(position);
        holder.bind(volume);

    }

    @Override
    public int getItemCount() {
        return volumes.size();
    }
}
