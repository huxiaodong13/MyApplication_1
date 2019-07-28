package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class PersonActivity extends AppCompatActivity {

    private EditText et_BorrowId,et_workId,et_name,et_home,et_date,et_tel;
    private Button btnBack,cancel,register;
    BorrowCardUtil card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_layout);
        init();
    }
    public void init() {
        et_BorrowId= findViewById(R.id.person_etBorroId);
        et_workId = findViewById(R.id.person_etWorkId);
        et_name = findViewById(R.id.person_etName);
        et_home = findViewById(R.id.person_etHome);
        et_date = findViewById(R.id.person_etDate);
        btnBack = findViewById(R.id.person_back);
        et_tel = findViewById(R.id.person_etPhone);
        register = findViewById(R.id.person_btnRegister);
        cancel = findViewById(R.id.person_btnCancel);
        card = new BorrowCardUtil(this);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入在相应控件中的字符串
                String borrow_id = et_BorrowId.getText().toString().trim();
                String work_id = et_workId.getText().toString().trim();
                String reader_name = et_name.getText().toString().trim();
                String department = et_home.getText().toString().trim();
                String register_date = et_date.getText().toString().trim();
                String phone = et_tel.getText().toString().trim();

                if(TextUtils.isEmpty(borrow_id)){
                    Toast.makeText(PersonActivity.this, "请输入借阅编号", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(work_id)){
                    Toast.makeText(PersonActivity.this, "请输入工作编号", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(reader_name)){
                    Toast.makeText(PersonActivity.this, "请输入姓名", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(department)){
                    Toast.makeText(PersonActivity.this, "请输入部门", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(register_date)){
                    Toast.makeText(PersonActivity.this, "请输入办证日期", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(phone)){
                    Toast.makeText(PersonActivity.this, "请输入联系方式", Toast.LENGTH_SHORT).show();
                }else {
                    ArrayList<HashMap<String,String>> que = new ArrayList<HashMap<String,String>>();
                    que = card.query2(borrow_id);
                    if(que.size()==0 || que == null){
                        //添加借阅证信息
                        HashMap<String,String> account = new HashMap<>();
                        account.put("id","0");
                        account.put("borrow_id",borrow_id);
                        account.put("work_id",work_id);
                        account.put("reader_name",reader_name);
                        account.put("department",department);
                        account.put("register_date",register_date);
                        account.put("phone",phone);

                        card.Add(account);
                        Toast.makeText(PersonActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(PersonActivity.this, BorrowCardActivity.class));
                    }else{
                        Toast.makeText(PersonActivity.this, "此编号借阅证已存在", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(PersonActivity.this, BorrowCardActivity.class));
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(PersonActivity.this, BorrowCardActivity.class));
            }
        });
    }
}
