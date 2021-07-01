package com.fineapps.books;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.fineapps.books.adapter.BooksAdapter;
import com.fineapps.books.databinding.ActivityMainBinding;
import com.fineapps.books.models.Volume;
import com.fineapps.books.viewmodel.VolumesViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Volume> volumes=new ArrayList<>();
    VolumesViewModel volumesViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);



        ViewModelProvider viewModelProvider=new ViewModelProvider(getViewModelStore(),ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()));
        volumesViewModel=viewModelProvider.get(VolumesViewModel.class);

        volumesViewModel.init("search+terms");

        volumesViewModel.getVolumes().observe(this, volumesResponse -> {
            volumes=volumesResponse.getItems();
            BooksAdapter booksAdapter=new BooksAdapter(volumes);
            binding.setBooksAdapter(booksAdapter);
            for (int i=0; i<volumes.size();i++) {
                booksAdapter.notifyDataSetChanged();
            }
        });


    }
}