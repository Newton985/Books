package com.fineapps.books.api;

import com.fineapps.books.models.VolumesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {
    @GET("volumes/")
    Call<VolumesResponse> getVolumes(@Query("q") String searchTerms);
}
