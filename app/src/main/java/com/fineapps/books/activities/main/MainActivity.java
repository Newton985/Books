package com.fineapps.books.activities.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.fineapps.books.R;
import com.fineapps.books.adapter.BooksAdapter;
import com.fineapps.books.databinding.ActivityMainBinding;
import com.fineapps.books.models.Volume;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Volume> volumes=new ArrayList<>();
    MainActivityViewModel mainActivityViewModel;
    MenuItem searchViewMenu;
    int loadIndex = 0;
    int totalItems= 0;
    String searchTerms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding= DataBindingUtil.setContentView(this, R.layout.activity_main);

        ViewModelProvider viewModelProvider=new ViewModelProvider(getViewModelStore(),ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()));
        mainActivityViewModel =viewModelProvider.get(MainActivityViewModel.class);

        mainActivityViewModel.getVolumesResponseLiveData().observe(this, volumesResponse -> {
            mainActivityViewModel.getIsLoading().setValue(false);
            if (volumesResponse==null && volumes.size()<1){
                binding.noResults.setVisibility(View.VISIBLE);
            }else {
                binding.noResults.setVisibility(View.GONE);
                totalItems = volumesResponse.getTotalItems();
                volumes.addAll(volumesResponse.getItems());
                BooksAdapter booksAdapter = new BooksAdapter(volumes);
                binding.setBooksAdapter(booksAdapter);
                for (int i = 0; i < volumes.size(); i++) {
                    booksAdapter.notifyDataSetChanged();
                }
            }

            binding.booksRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(@NonNull @NotNull RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    if (!recyclerView.canScrollVertically(1) && loadIndex<=totalItems){
                        loadIndex +=20;
                        mainActivityViewModel.getVolumes(searchTerms, loadIndex);
                    }
                }
            });
        });

        mainActivityViewModel.getIsLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    binding.loaderView.setVisibility(View.VISIBLE);
                }else {
                    binding.loaderView.setVisibility(View.GONE);
                }
            }
        });

        mainActivityViewModel.getVolumes("Java Programming",0);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu,menu);
        searchViewMenu = menu.findItem(R.id.searchbar);
        SearchView searchView =(SearchView) searchViewMenu.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                volumes = new ArrayList<>();
                mainActivityViewModel.getVolumes(query,0);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                volumes = new ArrayList<>();
                if (newText.length()>3){
                    mainActivityViewModel.getVolumes(newText,0);
                }
                return false;
            }
        });

       return  super.onCreateOptionsMenu(menu);

    }
}