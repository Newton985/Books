package com.fineapps.books.activities.volume;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.fineapps.books.models.Volume;
import com.fineapps.books.repositories.VolumesRepository;

public class VolumeInformationViewModel extends AndroidViewModel {
    VolumesRepository volumesRepository;
    MutableLiveData<Volume> volumeMutableLiveData;
    MutableLiveData<Boolean> isLoading;

    public VolumeInformationViewModel(@NonNull Application application) {
        super(application);
        volumesRepository = VolumesRepository.getInstance();
        volumeMutableLiveData = volumesRepository.getVolumeMutableLiveData();
        isLoading = new MutableLiveData<>();
    }

    public void getVolumeInformation(String id){
         volumesRepository.getVolumeInfo(id);
    }

    public MutableLiveData<Volume> getVolumeMutableLiveData() {
        return volumeMutableLiveData;
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }
}
