package com.example.tealist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Tea App";
    Button btn_addOne;

    List<Tea> teaList;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    RecyleViewAdapter.onItemClickListener itemClickListener;

    protected void onResume() {
        LayoutInflater layoutInflater = getLayoutInflater();
        super.onResume();
        ControllerDataBase db = new ControllerDataBase(this);
        teaList = db.select();
        mAdapter = new RecyleViewAdapter(teaList, MainActivity.this, itemClickListener);
        recyclerView.setAdapter(mAdapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ControllerDataBase db = new ControllerDataBase(this);

        teaList = db.select();


        Log.d(TAG, "onCreate: "+ teaList.toString());
        //Toast.makeText(this, "TeaCount = " + teaList.size(), Toast.LENGTH_SHORT).show();


        btn_addOne = findViewById(R.id.btn_addOne);

        btn_addOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddOne.class);
                startActivity(intent);
            }
        });
        recyclerView = findViewById(R.id.lv_teaList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        itemClickListener = new RecyleViewAdapter.onItemClickListener() {
            @Override
            public void onItemClick(Tea tea, int position) {
                Intent intent = new Intent(MainActivity.this, OnePage.class);
                intent.putExtra("teaId", tea.getId());
                startActivity(intent);

            }
        };
        mAdapter = new RecyleViewAdapter(teaList, MainActivity.this, itemClickListener);
        recyclerView.setAdapter(mAdapter);

//        recyclerView.setOn;
    }


}