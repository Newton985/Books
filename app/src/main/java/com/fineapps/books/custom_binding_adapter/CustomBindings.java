package com.fineapps.books.custom_binding_adapter;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fineapps.books.adapter.BooksAdapter;

public class CustomBindings {

    @BindingAdapter("imageUrl")
    public static void imageUrl(ImageView imageView, String url){
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }


    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView recyclerView, BooksAdapter adapter){
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}
