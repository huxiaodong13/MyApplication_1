package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ManagerActivity extends AppCompatActivity {
    private Button btnReader;
    private Button btnMagazine;
    private Button btnBorrow;
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_layout);
        init();
    }
    public void init() {
        btnBack = (Button) this.findViewById(R.id.manager_btnBack);
        btnReader = (Button)this.findViewById(R.id.manager_btnReader);
        btnMagazine = (Button) this.findViewById(R.id.manager_btnMagazine);
        btnBorrow = (Button) this.findViewById(R.id.manager_btnBorrow);

        //点击事件
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(ManagerActivity.this, LoginActivity.class));
            }
        });

        btnReader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(ManagerActivity.this, BorrowCardActivity.class));
            }
        });

        btnMagazine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(ManagerActivity.this, BookManagementActivity.class));
            }
        });

        btnBorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                startActivity(new Intent(ManagerActivity.this, BorrowManagementActivity.class));
            }
        });
    }
}
