/*
员工信息表操作类
 */
package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class UserUtil extends AppCompatActivity {
    private Context _Context;
    private DbHelper helper;
    public UserUtil(Context _Context)
    {
        try {
            this._Context = _Context;
            helper = new DbHelper(_Context);
            helper.open();
        }
        catch (Exception ex)
        {

        }
    }
    //插入管理员和BOSS账目密码
    public long Save(){
        String[] userID = new String[]{"m1","m2","m3","boss"};
        String[] pwd = new String[]{"m1","m2","m3","boss"};
        String[] identify = new String[]{"管理员","管理员","管理员","boss"};
        long count = 0;
        for(int i=0;i<4;i++) {
            ContentValues value = new ContentValues();
            value.put(DbHelper.KEY_USERID, userID[i]);
            value.put(DbHelper.KEY_PASSWORD, pwd[i]);
            value.put(DbHelper.KEY_IDENTITY, identify[i]);
            count = helper.insert(DbHelper.DB_TABLE1, DbHelper.KEY_ID, value);
        }
        return count;
    }

    //增加
    public long Add(HashMap<String,String> account)
    {
        ContentValues value=new ContentValues();
        value.put(DbHelper.KEY_USERID, account.get("user_id"));
        value.put(DbHelper.KEY_PASSWORD, account.get("password"));
        value.put(DbHelper.KEY_IDENTITY,account.get("identity"));
        long count=0;
        count=helper.insert(DbHelper.DB_TABLE1, DbHelper.KEY_ID, value);
        return count;
    }
    //删除
    public long Delete(int _UserId)
    {
        return helper.delete(DbHelper.DB_TABLE1, DbHelper.KEY_ID+"=?", new String[]{String.valueOf(_UserId)});
    }
    //修改
    public long Update(HashMap<String,String> account)
    {
        ContentValues value=new ContentValues();
        value.put(DbHelper.KEY_USERID, account.get("user_id"));
        value.put(DbHelper.KEY_PASSWORD, account.get("password"));
        long count=0;
        count=helper.update(DbHelper.DB_TABLE1, value, DbHelper.KEY_ID+"=?", new String[]{String.valueOf(account.get("id"))});
        return count;
    }
    //查询全部
    public ArrayList<HashMap<String,String>> query()
    {
        ArrayList<HashMap<String,String>> alUser=new ArrayList<HashMap<String,String>>();
        Cursor c = helper.query(DbHelper.DB_TABLE1,null,null,null,null,null,null);
        while(c.moveToNext())
        {
            HashMap<String,String> item = new HashMap<String,String>();
            item.put("id", c.getString(c.getColumnIndex("id")));
            item.put("user_id", c.getString(c.getColumnIndex("user_id")));
            item.put("password",c.getString(c.getColumnIndex("password")));
            alUser.add(item);
        }
        c.close();
        c=null;
        return alUser;
    }
    //按照条件查询(此处条件为USERID)
    public ArrayList<HashMap<String,String>> query2(String text)
    {
        if(text==null){
            return null;
        }
        ArrayList<HashMap<String,String>> alUser=new ArrayList<HashMap<String,String>>();
        Cursor c = helper.query(DbHelper.DB_TABLE1,null,DbHelper.KEY_USERID+"=?",new String[]{text},null,null,null);
        while(c.moveToNext())
        {
            HashMap<String,String> item = new HashMap<String,String>();
            item.put("id", c.getString(c.getColumnIndex("id")));
            item.put("user_id", c.getString(c.getColumnIndex("user_id")));
            item.put("password",c.getString(c.getColumnIndex("password")));
            item.put("identity",c.getString(c.getColumnIndex("identity")));
            alUser.add(item);
        }
        c.close();
        c=null;
        return alUser;
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        helper.close();
        super.finalize();
    }

}
