package com.fineapps.books.services;

import com.fineapps.books.models.Volume;
import com.fineapps.books.models.VolumesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface VolumesService {
    @GET("volumes/")
    Call<VolumesResponse> getVolumes(@Query("q") String searchTerms, @Query("startIndex") int startIndex, @Query("maxResults") int maxResults);

    @GET("volumes/{id}")
    Call<Volume> getVolumeInfo(@Path("id") String volumeId);
}
