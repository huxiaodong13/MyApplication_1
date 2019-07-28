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
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private EditText userName;//用户名
    private EditText pwd;//密码
    private Button btnLogin;
    String name,password;
    UserUtil user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        init();
    }

    public void init() {
        //邦控件
        userName = (EditText) this.findViewById(R.id.activity_main_etUser);
        pwd = (EditText) this.findViewById(R.id.activity_main_etPwd);
        btnLogin = (Button) this.findViewById(R.id.activity_main_btnLogin);

        user = new UserUtil(this);
        user.Save();
        //点击事件
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //获取输入在相应控件中的字符串
                name = userName.getText().toString().trim();
                password = pwd.getText().toString().trim();

                if(TextUtils.isEmpty(name)){
                    Toast.makeText(LoginActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                }else{
                    //判断密码是否对应
                    ArrayList<HashMap<String,String>> data = new ArrayList<HashMap<String,String>>();
                    data = user.query2(name);
                    if(data == null || data.size()==0){
                        Toast.makeText(LoginActivity.this, "您没有权限！！！", Toast.LENGTH_SHORT).show();
                    }else{
                        for(HashMap map: data){
                            if(map != null) {
                                if(password.equals(map.get("password").toString())){
                                    //是管理员还是老板
                                    if(map.get("identity").equals("管理员")){
                                        finish();
                                        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(LoginActivity.this, ManagerActivity.class));
                                    }else{
                                        finish();
                                        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(LoginActivity.this, Borrow_Return_queryActivity.class));
                                    }
                                }else {
                                    Toast.makeText(LoginActivity.this, "请核对您的用户和密码", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }

                }
            }
        });

    }
}
