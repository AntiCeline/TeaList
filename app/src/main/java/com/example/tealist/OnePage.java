package com.example.tealist;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class OnePage extends AppCompatActivity {

   private Intent intent;
   private int teaId;

   private ControllerDataBase db;

   TextView name, disc;
   ImageView pic;
   ImageButton delete;
   Button cansel, update;

   @Override
   protected void onResume() {
      super.onResume();
      Tea tea = db.select(teaId);
      name.setText(tea.getName());
      disc.setText(tea.getDescription());
      Glide.with(this).load(tea.getImageURL()).into(pic);
   }

   @Override
   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.one_page_tea);
      intent = getIntent();
      teaId = intent.getIntExtra("teaId",-1);
      db = new ControllerDataBase(this);
      Tea tea = db.select(teaId);
      name = findViewById(R.id.tv_mainTeaName);
      disc = findViewById(R.id.tv_mainTeaDiscription);
      pic = findViewById(R.id.iv_mainTeaPicture);
      cansel = findViewById(R.id.btn_cancel1);
      update = findViewById(R.id.btn_update);
      delete = findViewById(R.id.btn_delete);

      delete.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            db.delete(teaId);
            finish();
         }
      });

      name.setText(tea.getName());
      disc.setText(tea.getDescription());
      Glide.with(this).load(tea.getImageURL()).into(pic);

      update.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
                  Intent intent = new Intent(OnePage.this,AddOne.class);
                  intent.putExtra("teaId", teaId);
                  startActivity(intent);
         }
      });


      cansel.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Intent intent = new Intent(OnePage.this,MainActivity.class);
            startActivity(intent);
         }
      });
   }

}
