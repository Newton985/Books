package com.fineapps.books.repositories;

import androidx.lifecycle.MutableLiveData;

import com.fineapps.books.models.Volume;
import com.fineapps.books.models.VolumeInfo;
import com.fineapps.books.services.VolumesService;
import com.fineapps.books.api.RetrofitService;
import com.fineapps.books.models.VolumesResponse;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VolumesRepository {

    private static VolumesRepository volumesRepository;
    MutableLiveData<VolumesResponse> volumesResponseMutableLiveData=new MutableLiveData<>();
    MutableLiveData<Volume> volumeMutableLiveData = new MutableLiveData<>();

    public static VolumesRepository getInstance(){
        if (volumesRepository==null){
            volumesRepository=new VolumesRepository();
        }
        return volumesRepository;
    }

    private final VolumesService volumesService;

    private VolumesRepository(){
        volumesService = RetrofitService.createService(VolumesService.class);
    }

    public void getVolumes(String searchQuery, int startIndex){


        volumesService.getVolumes(searchQuery,startIndex,20).enqueue(new Callback<VolumesResponse>() {
            @Override
            public void onResponse(Call<VolumesResponse> call, Response<VolumesResponse> response) {
                if (response.isSuccessful()){
                    volumesResponseMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<VolumesResponse> call, Throwable t) {
                   System.out.println("FAILURE::::::"+t.getMessage());
                   volumesResponseMutableLiveData.setValue(null);
            }
        });

    }

    public void getVolumeInfo(String volumeId){

        volumesService.getVolumeInfo(volumeId).enqueue(new Callback<Volume>() {
            @Override
            public void onResponse(Call<Volume> call, Response<Volume> response) {
                if (response.isSuccessful()){
                    volumeMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Volume> call, Throwable t) {
                volumeMutableLiveData.setValue(null);
            }
        });


    }

    public MutableLiveData<Volume> getVolumeMutableLiveData() {
        return volumeMutableLiveData;
    }

    public MutableLiveData<VolumesResponse> getVolumesResponseMutableLiveData() {
        return volumesResponseMutableLiveData;
    }
}
