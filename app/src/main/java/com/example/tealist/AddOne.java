package com.example.tealist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class AddOne extends AppCompatActivity {

    Button btn_ok, btn_cancel;

    ControllerDataBase controllerDataBase;

    List<Tea> teaList;

    EditText et_presDisc, et_presName, et_presPic;

    MyApplication myApplication = (MyApplication) this.getApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_one);

        controllerDataBase = new ControllerDataBase(this);

        teaList = controllerDataBase.select();

        btn_ok = findViewById(R.id.btn_ok);
        btn_cancel = findViewById(R.id.btn_cancel);
        et_presName = findViewById(R.id.et_teaName);
        et_presDisc = findViewById(R.id.et_description);
        et_presPic = findViewById(R.id.et_pictureURL);

        Intent intent = getIntent();
        int teaId = intent.getIntExtra("teaId",-1);

        btn_ok.setOnClickListener(new View.OnClickListener() { // создаем кнопку изменения

            int nextId= myApplication.getNextId();
            @Override
            public void onClick(View view) {
                if(teaId<0){
            Tea newTea = new Tea(nextId, et_presName.getText().toString(), et_presDisc.getText().toString(), et_presPic.getText().toString());
                controllerDataBase.insert(newTea);
                finish();
                }
                else {
                    Tea tea = new Tea(teaId,et_presName.getText().toString(), et_presDisc.getText().toString(), et_presPic.getText().toString());
                    controllerDataBase.update(tea);
                    finish();
                }

            }
        });



        btn_cancel.setOnClickListener(new View.OnClickListener() {// создаем кнопку отмены
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddOne.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}