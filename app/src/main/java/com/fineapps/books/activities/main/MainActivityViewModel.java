package com.fineapps.books.activities.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fineapps.books.models.VolumesResponse;
import com.fineapps.books.repositories.VolumesRepository;

public class MainActivityViewModel extends ViewModel {
    MutableLiveData<VolumesResponse> volumesResponseMutableLiveData;
    VolumesRepository volumesRepository;
    MutableLiveData<Boolean> isLoading;

    public MainActivityViewModel(){
        volumesRepository=VolumesRepository.getInstance();
        volumesResponseMutableLiveData= volumesRepository.getVolumesResponseMutableLiveData();
        isLoading = new MutableLiveData<>();
    }

    public void getVolumes(String searchTerms, int startIndex){
            isLoading.setValue(true);
            volumesRepository.getVolumes(searchTerms, startIndex);
    }

    public LiveData<VolumesResponse> getVolumesResponseLiveData(){
        return volumesResponseMutableLiveData;
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

}
