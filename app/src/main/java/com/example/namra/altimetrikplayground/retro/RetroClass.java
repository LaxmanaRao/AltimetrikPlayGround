package com.example.namra.altimetrikplayground.retro;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.namra.altimetrikplayground.Categories;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClass extends Application {
        public static RetrofitInterface retrofitInterface;
        String id;
        String title;
        int count;
        public static final String url = "http://jservice.io";
        MutableLiveData<Categories> pojoMutable;
        static RetroClass app;

        @Override
        public void onCreate() {
            super.onCreate();
            app = RetroClass.this;
        }

        public RetrofitInterface getRetrofit() {

            if (retrofitInterface == null) {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient client = new OkHttpClient.Builder().retryOnConnectionFailure(true).readTimeout(10000, TimeUnit.SECONDS).connectTimeout(15000, TimeUnit.SECONDS).addInterceptor(interceptor).build();

                Retrofit retrofit= new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                retrofitInterface = retrofit.create(RetrofitInterface.class);
                return retrofitInterface;}

            else {
                return retrofitInterface;
            }
        }

        public LiveData<Categories> setMapLiveData(final String string, String str , int radius)
        {

            final MutableLiveData<Categories> pojoMutable = new MutableLiveData<>();
            RetrofitInterface retrofitMaps = getRetrofit();

            retrofitInterface.getCategories(id,title,count).enqueue(new Callback<Categories>() {
                @Override
                public void onResponse(Call<Categories> call, Response<Categories> response) {
                    try{
                        Categories categories=response.body();
                         pojoMutable.postValue(categories);
                    } catch (NullPointerException e) {
                        Log.d("onResponse", "There is an error");
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<Categories> call, Throwable t) {
                    Log.d("onFailure", t.toString());
                    t.printStackTrace();
                }
            });

            return pojoMutable;

        }

        private static GsonConverterFactory getApiConvertorFactory() {
            return GsonConverterFactory.create();
        }

        public static RetroClass getApp() {
            return app;
        }

    }

