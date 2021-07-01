package com.fineapps.books.custom_binding_adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fineapps.books.R;
import com.fineapps.books.adapter.BooksAdapter;

import java.util.List;

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

    @BindingAdapter("authorsList")
    public  static void  showAuthorsList(LinearLayout linearLayout, List<String> authors){
        if (authors!=null) {
            for (String author : authors) {
                View root = LayoutInflater.from(linearLayout.getContext()).inflate(R.layout.author_item,null);
                TextView tv = root.findViewById(R.id.authorNameText);
                tv.setText(author);
                linearLayout.addView(root);
            }
        }
    }

    @BindingAdapter("categoryList")
    public static void showCategoryList(LinearLayout linearLayout, List<String> categories){
        if (categories!=null) {
            for (String category : categories) {
                View root = LayoutInflater.from(linearLayout.getContext()).inflate(R.layout.category_item, null);
                TextView tv = root.findViewById(R.id.categoryNameText);
                tv.setText(category);
                linearLayout.addView(root);
            }
        }
    }
}
