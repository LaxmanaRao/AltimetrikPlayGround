package com.example.namra.altimetrikplayground.retro;

import com.example.namra.altimetrikplayground.Categories;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {
    @GET("api/categories/")
    Call<Categories> getCategories(@Query("id") String id,
                                   @Query("title") String title,
                                   @Query("count") int count);
}
