package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Where_queryActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv1;
    EditText etName;
    ListView list;
    Button btnQuery,btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.where_query_layout);

        tv1 = this.findViewById(R.id.where_query_tv1);
        etName = this.findViewById(R.id.where_query_etName);
        list = this.findViewById(R.id.where_query_lv);
        btnQuery = this.findViewById(R.id.where_query_btnQuery);
        btnBack = this.findViewById(R.id.where_query_btnBack);

    }
    @Override
    public void onClick(View v) {

    }
}
