/*
创建数据库和数据表
 */
package com.example.myapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper {

    private static final String DB_NAME = "book.db";
    private static final int DB_VERSION = 1;

    public static final String KEY_ID = "id";//每张表都有一个自动增长的ID

    //员工信息表
    public static final String DB_TABLE1 = "manager";
    public static final String KEY_USERID = "user_id";//相当于用户名
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_IDENTITY = "identity";//填写BOSS或者管理员

    //订刊报表
    public static final String DB_TABLE2 = "book_eidt";
    public static final String KEY_BOOKNAME = "book_name";
    public static final String KEY_BOOKCODE = "book_code";
    public static final String KEY_COUNT = "count";
    public static final String KEY_TYPE = "type";
    public static final String KEY_DATE = "publication_date";
    public static final String KEY_MAJOR = "major_supplier";
    public static final String KEY_SECONDARY = "secondary_supplier";

    //期刊信息表（卡片）
    public static final String DB_TABLE3 = "book_card";
    public static final String KEY_TOTALNUMBER = "total_number";//总期号
    public static final String KEY_COPYSERIALNUMBER = "copy_serial_number";//复本序号
    public static final String KEY_THISISSUE = "this_issue";//本年期号
    public static final String KEY_PUBLISH = "publishing_house";//出版社

    //借阅证表
    public static final String DB_TABLE4 = "borrow_card";
    public static final String KEY_BORROWID = "borrow_id";
    public static final String KEY_WORKID = "work_id";
    public static final String KEY_READERNME = "reader_name";
    public static final String KEY_DEPARTMENT = "department";
    public static final String KEY_REGISTERDATE = "register_date";
    public static final String KEY_PHONE = "phone";

    //读者借还记录表
    public static final String DB_TABLE5 = "borrow_return";
    public static final String KEY_BORROWDATE = "borrow_date";
    public static final String KEY_RETURNDATE = "return_date";
    public static final String KEY_CHOOSE = "choose";

    //期刊状态表
    public static final String DB_TABLE6 = "book_reman";
    public static final String KEY_REMANNUMBER = "reman_number";

    private SQLiteDatabase db;
    private final Context context;
    private DBOpenHelper dbOpenHelper;

    private static class DBOpenHelper extends SQLiteOpenHelper {
        //创建员工信息表
        private static final String DB_CREATE1 = "create table " + DB_TABLE1
                + " (" + KEY_ID + " integer primary key autoincrement, "
                + KEY_USERID + " varchar not null, " + KEY_PASSWORD + " varchar not null,"
                + KEY_IDENTITY + " varchar not null);";
        //创建订刊报表
        private static final String DB_CREATE2 = "create table " + DB_TABLE2
                + " (" + KEY_ID + " integer primary key autoincrement, "
                + KEY_BOOKCODE + " varchar not null, " + KEY_BOOKNAME + " varchar not null,"
                +KEY_COUNT + " varchar not null,"+KEY_TYPE + " varchar not null,"+
                KEY_DATE + " varchar not null,"+KEY_MAJOR + " varchar not null,"+ KEY_SECONDARY + " varchar not null);";

        //创建期刊信息（卡片）表
        private static final String DB_CREATE3 = "create table " + DB_TABLE3
                + " (" + KEY_ID + " integer primary key autoincrement, "
                + KEY_BOOKCODE + " varchar not null, " + KEY_TOTALNUMBER + " varchar not null,"
                +KEY_COPYSERIALNUMBER + " varchar not null,"+KEY_DATE + " varchar not null,"+
                KEY_THISISSUE + " varchar not null,"+KEY_PUBLISH +" varchar );";
        //创建借阅证表
        private static final String DB_CREATE4 = "create table " + DB_TABLE4
                + " (" + KEY_ID + " integer primary key autoincrement, "
                + KEY_BORROWID + " varchar not null, " + KEY_WORKID + " varchar not null,"
                +KEY_READERNME + " varchar not null,"+KEY_DEPARTMENT + " varchar not null,"+
                KEY_REGISTERDATE + " varchar not null,"+KEY_PHONE +" varchar not null);";
        //创建读者借还信息表
        private static final String DB_CREATE5 = "create table " + DB_TABLE5
                + " (" + KEY_ID + " integer primary key autoincrement, "
                + KEY_BORROWID + " varchar not null, " + KEY_WORKID + " varchar not null,"
                +KEY_READERNME + " varchar not null,"+KEY_BOOKCODE + " varchar not null,"+
                KEY_DEPARTMENT + " varchar not null,"+KEY_BORROWDATE + " varchar not null,"
                +KEY_RETURNDATE + " varchar not null," +KEY_PHONE + " varchar not null,"+ KEY_CHOOSE +" varchar not null);";
        //创建期刊状态表
        private static final String DB_CREATE6 = "create table " + DB_TABLE6
                + " (" + KEY_ID + " integer primary key autoincrement, "
                + KEY_BOOKCODE + " varchar not null, " + KEY_BOOKNAME + " varchar not null,"
                + KEY_COUNT + " varchar not null);";

        //然后添加构造方法：
        //DB_NAME是数据库名字，version是数据库版本。
        public DBOpenHelper(Context context, String name,
                            CursorFactory factory, int version) {
            super(context, DB_NAME, factory, version);
            // TODO Auto-generated constructor stub
        }

        //db.execSQL的作用是执行SQL语句
        @Override
        public void onCreate(SQLiteDatabase db) {
            // TODO Auto-generated method stub
            db.execSQL(DB_CREATE1);
            db.execSQL(DB_CREATE2);
            db.execSQL(DB_CREATE3);
            db.execSQL(DB_CREATE4);
            db.execSQL(DB_CREATE5);
            db.execSQL(DB_CREATE6);
        }

        //执行Sql语句"drop if table exists 表名
        //sqlite数据库和两张表就创建完成了
        @Override
        public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
            // TODO Auto-generated method stub
            db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE1);
            db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE2);
            db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE3);
            db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE4);
            db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE5);
            db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE6);

            onCreate(db);
        }
    }

    public DbHelper(Context _context) {
        context = _context;

    }

    public void open() throws SQLiteException {
        dbOpenHelper = new DBOpenHelper(context, DB_NAME, null, DB_VERSION);
        try {
            db = dbOpenHelper.getWritableDatabase();
        } catch (SQLiteException ex) {
            db = dbOpenHelper.getReadableDatabase();
        }
    }

    public void close() {
        if (db != null) {
            db.close();
            db = null;
        }
    }

    public long insert(String table, String nullColumnHack, ContentValues values) {
        return db.insert(table, nullColumnHack, values);
    }

    public long update(String table, ContentValues values, String whereClause,
                       String[] whereArgs) {
        return db.update(table, values, whereClause, whereArgs);
    }

    public long delete(String table, String whereClause, String[] whereArgs) {
        return db.delete(table, whereClause, whereArgs);
    }

    public Cursor query(String table, String[] columns, String selection,
                        String[] selectionArgs, String groupBy, String having,
                        String orderBy) {
        return db.query(table, columns, selection, selectionArgs, groupBy,
                having, orderBy);
    }
}
