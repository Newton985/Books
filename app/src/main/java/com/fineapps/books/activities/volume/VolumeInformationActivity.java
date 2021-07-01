package com.fineapps.books.activities.volume;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.fineapps.books.R;
import com.fineapps.books.databinding.ActivityVolumeInformationBinding;
import com.fineapps.books.models.Volume;

public class VolumeInformationActivity extends AppCompatActivity {
    ActivityVolumeInformationBinding volumeInformationBinding;
    VolumeInformationViewModel volumeInformationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Volume Info");
       volumeInformationBinding = DataBindingUtil.setContentView(this,R.layout.activity_volume_information);

        ViewModelProvider viewModelProvider = new ViewModelProvider(getViewModelStore(), ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()));
        volumeInformationViewModel = viewModelProvider.get(VolumeInformationViewModel.class);
        volumeInformationBinding.setVolumeInfoViewModel(volumeInformationViewModel);

        volumeInformationViewModel.getVolumeMutableLiveData().observe(this, new Observer<Volume>() {
            @Override
            public void onChanged(Volume volume) {
                volumeInformationViewModel.getIsLoading().setValue(false);
                if (volume!=null){
                    volumeInformationBinding.setVolume(volume);
                }
            }
        });

        volumeInformationViewModel.getIsLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    volumeInformationBinding.loaderView.setVisibility(View.VISIBLE);
                }else {
                    volumeInformationBinding.loaderView.setVisibility(View.GONE);
                }
            }
        });

        if (getIntent().getStringExtra("id")!=null) {
            volumeInformationViewModel.getIsLoading().setValue(true);
            volumeInformationViewModel.getVolumeInformation(getIntent().getStringExtra("id"));
        }


    }
}