package com.example.namra.altimetrikplayground;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.namra.altimetrikplayground.adapter.RecyclerAdapter;
import com.example.namra.altimetrikplayground.viewmodel.CategoryViewModel;

public class CategoryItems extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerAdapter recyclerAdapter;
    CategoryViewModel categoryViewModel;
    Context context;
    String id,title;
    int count;
    Observer<Categories> categoriesObserver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_items);
      //  ListMapAdapter listadapter = new ListMapAdapter();
       // RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        //recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setAdapter(listadapter);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_id);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerAdapter = new RecyclerAdapter();
        mRecyclerView.setAdapter(recyclerAdapter);
        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);

      //  Categories category = bundle1.getParcelable("Data");
       // recyclerAdapter.setMapList(categories);
       // recyclerAdapter.notifyDataSetChanged();


       // Bundle bundle=new Bundle();
        categoryViewModel.getDataVal().observe(this, new Observer<Categories>() {
            @Override
            public void onChanged(@Nullable Categories categories) {
                recyclerAdapter.setMapList(categories);
                recyclerAdapter.notifyDataSetChanged();
            }
        });
//        categoryViewModel.getCategoryLiveData(id,title, Integer.parseInt(count));
       // categoryViewModel.getDataVal().observe(this, new Observer<Categories>(){
         //   @Override
           // public void onChanged(@Nullable Categories categories) {
             //  categories=categories;
            //}
        //});


    }}

