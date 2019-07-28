package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Borrow_Return_addActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvCardID,tvWorkID,tvName,tvBookCode,tvDepartment,tvLendDate,tvReturnDate,tvPhone;
    EditText etCardID,etWorkID,etName,etBookCode,etDepartment,etLendDate,etRetutnDate,etPhone;
    Button btnOK,btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow_return_add);

        tvCardID = this.findViewById(R.id.br_add_tvCardID);
        etCardID = this.findViewById(R.id.br_add_etCardID);
        tvWorkID = this.findViewById(R.id.br_add_tvWorkID);
        etWorkID = this.findViewById(R.id.br_add_etWorkID);
        tvName = this.findViewById(R.id.br_add_tvName);
        etName = this.findViewById(R.id.br_add_etName);
        tvBookCode = this.findViewById(R.id.br_add_tvBookCode);
        etBookCode = this.findViewById(R.id.br_add_etBookCode);
        tvDepartment = this.findViewById(R.id.br_add_tvDepartment);
        etDepartment = this.findViewById(R.id.br_add_etDepartment);
        tvLendDate = this.findViewById(R.id.br_add_tvLendDate);
        etLendDate = this.findViewById(R.id.br_add_etLendDate);
        tvReturnDate = this.findViewById(R.id.br_add_tvReturnDate);
        etRetutnDate = this.findViewById(R.id.br_add_etReturnDate);
        tvPhone = this.findViewById(R.id.br_add_tvPhone);
        etPhone = this.findViewById(R.id.br_add_etPhone);
        btnOK = this.findViewById(R.id.br_query_btnOK);
        btnCancel = this.findViewById(R.id.br_add_btnCancel);

        btnOK.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.br_add_btnOK:
//                Intent intent1 = new Intent(this, BorrowManagementActivity.class);
//                this.startActivity(intent1);
//                this.finish();
//                break;
//            case R.id.br_add_btnCancel:
//                Intent intent2 = new Intent(this, BorrowManagementActivity.class);
//                this.startActivity(intent2);
//                this.finish();
//                break;
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
