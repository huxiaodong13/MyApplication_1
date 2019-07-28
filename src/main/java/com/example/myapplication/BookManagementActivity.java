package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class BookManagementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_management);
        init();//初始化函数，实现页面跳转
    }

    public void init() {
        //“订购期刊”按钮
        findViewById(R.id.btn_book_edit).setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
              Intent intent = new Intent();
              intent.setClass(BookManagementActivity.this, BookEditActivity.class);
              BookManagementActivity.this.startActivity(intent);

           }
           });
         //“卡片”按钮
        findViewById(R.id.btn_card_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(BookManagementActivity.this, CardEditActivity.class);
                BookManagementActivity.this.startActivity(intent);
            }
        });





    }


}