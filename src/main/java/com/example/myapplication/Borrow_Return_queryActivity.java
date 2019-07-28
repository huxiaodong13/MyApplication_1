package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Borrow_Return_queryActivity extends AppCompatActivity implements View.OnClickListener {

    ListView list;
    Button btnOK;
    Button btnCancel;
    ArrayList<HashMap<String,String>> allBorrowReturn;
    BorrowReturnUtil brUtil;
    SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow_return_query);

        //关联控件
        list = this.findViewById(R.id.br_query_list);
        btnOK = this.findViewById(R.id.br_query_btnOK);
        btnCancel = this.findViewById(R.id.br_query_btnCancel);


        btnOK.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        brUtil = new BorrowReturnUtil(this);
        allBorrowReturn = new ArrayList<HashMap<String, String>>();
        adapter = new SimpleAdapter(this, allBorrowReturn, R.layout.li_borrow_return,
                new String[]{"reader_name","book_code","book_name","return_date"},
                new int[]{R.id.li_br_readerName,R.id.li_br_bookCode,R.id.li_br_borrowDate,R.id.li_br_returnDate});
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.br_query_btnOK:
                allBorrowReturn = brUtil.query();
                if (allBorrowReturn == null || allBorrowReturn.size() == 0) {  //如果数据库中没有数据
                    // 显示提示信息，没有相关记录
                    Toast.makeText(this, "还没有借阅情况喔！", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    adapter = new SimpleAdapter(this, allBorrowReturn, R.layout.li_borrow_return,
                            new String[]{"reader_name","book_code","book_name","return_date"},
                            new int[]{R.id.li_br_readerName,R.id.li_br_bookCode,R.id.li_br_borrowDate,R.id.li_br_returnDate});
                    list.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    break;
                }
            case R.id.br_query_btnCancel:
                Intent intent1 = new Intent(this, BorrowManagementActivity.class);
                this.startActivity(intent1);
                break;
        }
    }

    //弹出对话框
    public void showdialog(String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("错误信息");
        builder.setMessage(msg);

        //setPositiveButton 确认
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //   Toast.makeText(MainActivity.this,"you choose 确认:",Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
}
