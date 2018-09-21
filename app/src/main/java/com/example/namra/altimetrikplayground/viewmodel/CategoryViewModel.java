package com.example.namra.altimetrikplayground.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.namra.altimetrikplayground.Categories;
import com.example.namra.altimetrikplayground.retro.RetroClass;

public class CategoryViewModel extends AndroidViewModel {
        private Categories categories;
        String id,title;
        int count;

        private RetroClass retroClass ;
        private LiveData<Categories> liveData;
        public LiveData<Categories> getDataVal() {


            return liveData;
        }
        public CategoryViewModel(@NonNull Application application) {

            super(application);
            retroClass = new RetroClass();
            liveData = new MutableLiveData<>();
        }

        public void getCategoryLiveData(String id,String title, int count) {
            liveData = retroClass.setMapLiveData(id,title,count);

        }
      }

