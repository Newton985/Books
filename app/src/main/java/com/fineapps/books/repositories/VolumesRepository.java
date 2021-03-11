package com.fineapps.books.repositories;

import androidx.lifecycle.MutableLiveData;

import com.fineapps.books.api.RetrofitInterface;
import com.fineapps.books.api.RetrofitService;
import com.fineapps.books.models.VolumesResponse;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VolumesRepository {

    private static VolumesRepository volumesRepository;

    public static VolumesRepository getInstance(){
        if (volumesRepository==null){
            volumesRepository=new VolumesRepository();
        }
        return volumesRepository;
    }

    private final RetrofitInterface retrofitInterface;

    public VolumesRepository(){
        retrofitInterface= RetrofitService.createService(RetrofitInterface.class);
    }

    public MutableLiveData<VolumesResponse> getVolumes(String searchQuery){
        MutableLiveData<VolumesResponse> volumesResponseMutableLiveData=new MutableLiveData<>();

        retrofitInterface.getVolumes(searchQuery).enqueue(new Callback<VolumesResponse>() {
            @Override
            public void onResponse(Call<VolumesResponse> call, Response<VolumesResponse> response) {
                if (response.isSuccessful()){
                    String resp=new Gson().toJson(response.body());
                    System.out.println("RESPONSE::::::"+resp);
                    volumesResponseMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<VolumesResponse> call, Throwable t) {
                   System.out.println("FAILURE::::::"+t.getMessage());
                   volumesResponseMutableLiveData.setValue(null);
            }
        });

        return volumesResponseMutableLiveData;
    }
}
