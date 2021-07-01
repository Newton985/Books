package com.fineapps.books.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fineapps.books.models.VolumesResponse;
import com.fineapps.books.repositories.VolumesRepository;

public class VolumesViewModel extends ViewModel {
    MutableLiveData<VolumesResponse> volumesResponseMutableLiveData;
    VolumesRepository volumesRepository;

    public void init(String searchTerms){
        if (volumesResponseMutableLiveData==null){
            volumesRepository=VolumesRepository.getInstance();
            volumesResponseMutableLiveData=volumesRepository.getVolumes(searchTerms);
        }
    }

    public LiveData<VolumesResponse> getVolumes(){
        return volumesResponseMutableLiveData;
    }
}
