package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class BorrowManagementActivity extends AppCompatActivity implements View.OnClickListener{


    Button borrow_Return_add,borrow_Return_query,reman_query,where_query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow_management);

        //关联控件
        borrow_Return_add = this.findViewById(R.id.borrow_Return_add);
        borrow_Return_query = this.findViewById(R.id.borrow_Return_query);
        reman_query = this.findViewById(R.id.reman_query);
        where_query = this.findViewById(R.id.where_query);

        borrow_Return_add.setOnClickListener(this);
        borrow_Return_query.setOnClickListener(this);
        reman_query.setOnClickListener(this);
        where_query.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //添加
            case R.id.borrow_Return_add:
                Intent intent1 = new Intent(this, Borrow_Return_addActivity.class);
                this.startActivity(intent1);
                break;
            case R.id.borrow_Return_query:
                Intent intent2 = new Intent(this, Borrow_Return_queryActivity.class);
                this.startActivity(intent2);
                break;
            case R.id.reman_query:
                Intent intent3 = new Intent(this, Reman_queryActivity.class);
                this.startActivity(intent3);
                this.finish();
                break;
            case R.id.where_query:
                Intent intent4 = new Intent(this, Where_queryActivity.class);
                this.startActivity(intent4);
                this.finish();
                break;
        }
    }
}
