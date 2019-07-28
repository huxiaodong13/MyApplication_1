package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BorrowCardActivity extends AppCompatActivity {

    private ListView persons;
    private Button add,back;
    BorrowCardUtil card;
    ArrayList<HashMap<String,String>> listItems;
    SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.borrowcard_layout);
        card = new BorrowCardUtil(this);
        HashMap<String,String> account = new HashMap<>();
        init();

    }
    public void init() {
        persons = (ListView) this.findViewById(R.id.borrowcard_lvPersons);
        add = findViewById(R.id.borrowcard_btnAdd);
        back = findViewById(R.id.borrowcard_btnBack);

        listItems = new ArrayList<HashMap<String,String>>(); // 创建一个list集合,将从数据库取出的数据全部放于其中
        listItems = card.query();
        if(listItems.size() == 0){
            Toast.makeText(this, "请添加借阅证", Toast.LENGTH_SHORT).show();
        }else {
            adapter = new SimpleAdapter(this, listItems,
                    R.layout.singeone_layout, new String[] { "borrow_id"}, new int[] {
                    R.id.borowid});

            persons.setAdapter(adapter); // 将适配器与ListView关联
            adapter.notifyDataSetChanged();
        }

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(BorrowCardActivity.this, PersonActivity.class));
                ArrayList<HashMap<String,String>> listItems = new ArrayList<HashMap<String,String>>(); // 创建一个list集合,将从数据库取出的数据全部放于其中
                BorrowCardUtil borrowCardUtil = new BorrowCardUtil(BorrowCardActivity.this);
                listItems = borrowCardUtil.query();
                SimpleAdapter adapter = new SimpleAdapter(BorrowCardActivity.this, listItems,
                        R.layout.singeone_layout, new String[] { "borrow_id"}, new int[] {
                        R.id.borowid});

                persons.setAdapter(adapter); // 将适配器与ListView关联
                adapter.notifyDataSetChanged();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(BorrowCardActivity.this, ManagerActivity.class));
            }
        });
        persons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> map = ( Map<String, Object> )parent.getItemAtPosition(position); 	//获取选择项的值
                Toast.makeText(BorrowCardActivity.this,map.get("borrow_id").toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
