package com.fineapps.books.viewholder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fineapps.books.databinding.BookItemBinding;
import com.fineapps.books.models.ImageLink;
import com.fineapps.books.models.Volume;
import com.fineapps.books.models.VolumeInfo;

import java.util.List;
import java.util.Map;

public class BooksViewHolder extends RecyclerView.ViewHolder {
    BookItemBinding bookItemBinding;

    public BooksViewHolder(@NonNull BookItemBinding bookItemBinding) {
        super(bookItemBinding.getRoot());
        this.bookItemBinding=bookItemBinding;
    }

    public void bind(Volume volume){
        bookItemBinding.setVolume(volume);

        VolumeInfo volumeInfo=volume.getVolumeInfo();
        bookItemBinding.setVolumeInfo(volumeInfo);

        ImageLink imageLink=volumeInfo.getImageLinks();
        bookItemBinding.setImageLinks(imageLink);






    }
}
