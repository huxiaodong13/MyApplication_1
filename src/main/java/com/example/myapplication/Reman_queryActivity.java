package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Reman_queryActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv1,tv2,tv3;
    EditText etName,etNum;
    Button btnQuery,btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reman_query_layout);

        tv1 = this.findViewById(R.id.reman_query_tv1);
        tv2 = this.findViewById(R.id.reman_query_tv2);
        tv3 = this.findViewById(R.id.reman_query_tv3);
        etName = this.findViewById(R.id.reman_query_etName);
        etNum = this.findViewById(R.id.reman_query_etNum);
        btnQuery = this.findViewById(R.id.reman_query_btnQuery);
        btnBack = this.findViewById(R.id.reman_query_btnBack);

    }
    @Override
    public void onClick(View v) {

    }
}
