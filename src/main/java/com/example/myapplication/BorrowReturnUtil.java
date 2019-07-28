package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class BorrowReturnUtil extends AppCompatActivity {
    private Context _Context;
    private DbHelper helper;
    public BorrowReturnUtil(Context _Context)
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
    //增加
    public long Add(HashMap<String,String> account)
    {
        ContentValues value=new ContentValues();
        value.put(DbHelper.KEY_BORROWID, account.get("borrow_id"));
        value.put(DbHelper.KEY_WORKID, account.get("work_id"));
        value.put(DbHelper.KEY_READERNME, account.get("reader_name"));
        value.put(DbHelper.KEY_BOOKCODE, account.get("book_code"));
        value.put(DbHelper.KEY_DEPARTMENT, account.get("department"));
        value.put(DbHelper.KEY_BORROWDATE, account.get("borrow_date"));
        value.put(DbHelper.KEY_RETURNDATE, account.get("return_date"));
        long count=0;
        count=helper.insert(DbHelper.DB_TABLE5, DbHelper.KEY_ID, value);
        return count;
    }
    //删除
    public long Delete(int _UserId)
    {
        return helper.delete(DbHelper.DB_TABLE5, DbHelper.KEY_ID+"=?", new String[]{String.valueOf(_UserId)});
    }
    //修改
    public long Update(HashMap<String,String> account)
    {
        ContentValues value=new ContentValues();
        value.put(DbHelper.KEY_BORROWID, account.get("borrow_id"));
        value.put(DbHelper.KEY_WORKID, account.get("work_id"));
        value.put(DbHelper.KEY_READERNME, account.get("reader_name"));
        value.put(DbHelper.KEY_BOOKCODE, account.get("book_code"));
        value.put(DbHelper.KEY_DEPARTMENT, account.get("department"));
        value.put(DbHelper.KEY_BORROWDATE, account.get("borrow_date"));
        value.put(DbHelper.KEY_RETURNDATE, account.get("return_date"));
        long count=0;
        count=helper.update(DbHelper.DB_TABLE5, value, DbHelper.KEY_ID+"=?", new String[]{String.valueOf(account.get("id"))});
        return count;
    }
    //查询全部
    public ArrayList<HashMap<String,String>> query()
    {
        ArrayList<HashMap<String,String>> alUser=new ArrayList<HashMap<String,String>>();
        Cursor c = helper.query(DbHelper.DB_TABLE5,null,null,null,null,null,null);
        while(c.moveToNext())
        {
            HashMap<String,String> item = new HashMap<String,String>();
            item.put("id", c.getString(c.getColumnIndex("id")));
            item.put("borrow_id", c.getString(c.getColumnIndex("borrow_id")));
            item.put("work_id", c.getString(c.getColumnIndex("work_id")));
            item.put("reader_name",c.getString(c.getColumnIndex("reader_name")));
            item.put("book_code", c.getString(c.getColumnIndex("book_code")));
            item.put("department", c.getString(c.getColumnIndex("department")));
            item.put("borrow_date",c.getString(c.getColumnIndex("borrow_date")));
            item.put("return_date", c.getString(c.getColumnIndex("return_date")));
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
