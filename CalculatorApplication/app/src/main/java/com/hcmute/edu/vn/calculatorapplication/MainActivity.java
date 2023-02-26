package com.hcmute.edu.vn.calculatorapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    private TextView tvPhepTinh, tvKq;
    private String pheptinh = "", kq = "0";
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnXoa, bntXoaHet, btnTru, btnCong, btnNhan, btnChia, btnCham, btnBang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giaodien);

        tvPhepTinh = findViewById(R.id.tvPhepTinh);
        tvKq = findViewById(R.id.tvkq);

        btn0 = findViewById(R.id.bt0);
        btn0.setOnClickListener(this);
        btn1 = findViewById(R.id.bt1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.bt2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.bt3);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.bt4);
        btn4.setOnClickListener(this);
        btn5 = findViewById(R.id.bt5);
        btn5.setOnClickListener(this);
        btn6 = findViewById(R.id.bt6);
        btn6.setOnClickListener(this);
        btn7 = findViewById(R.id.bt7);
        btn7.setOnClickListener(this);
        btn8 = findViewById(R.id.bt8);
        btn8.setOnClickListener(this);
        btn9 = findViewById(R.id.bt9);
        btn9.setOnClickListener(this);
        btnCong = findViewById(R.id.btCong);
        btnCong.setOnClickListener(this);
        btnTru = findViewById(R.id.btTru);
        btnTru.setOnClickListener(this);
        btnNhan = findViewById(R.id.btNhan);
        btnNhan.setOnClickListener(this);
        btnChia = findViewById(R.id.btChia);
        btnChia.setOnClickListener(this);
        btnCham = findViewById(R.id.btCham);
        btnCham.setOnClickListener(this);
        btnXoa = findViewById(R.id.btXoa);
        btnXoa.setOnClickListener(this);
        bntXoaHet = findViewById(R.id.btXoaHet);
        bntXoaHet.setOnClickListener(this);
        btnBang = findViewById(R.id.btBang);
        btnBang.setOnClickListener(this);
        Log.i("Assigned", "Assigned view with this Id");
    }
    @Override
    public void onClick(View view) {
        Log.i("A button was CLICKED", "");
        switch (view.getId())
        {
            case R.id.bt0:
                changePhepTinh(btn0);
                break;
            case R.id.bt1:
                changePhepTinh(btn1);
                break;
            case R.id.bt2:
                changePhepTinh(btn2);
                break;
            case R.id.bt3:
                changePhepTinh(btn3);
                break;
            case R.id.bt4:
                changePhepTinh(btn4);
                break;
            case R.id.bt5:
                changePhepTinh(btn5);
                break;
            case R.id.bt6:
                changePhepTinh(btn6);
                break;
            case R.id.bt7:
                changePhepTinh(btn7);
                break;
            case R.id.bt8:
                changePhepTinh(btn8);
                break;
            case R.id.bt9:
                changePhepTinh(btn9);
                break;
            case R.id.btCham:
                changePhepTinh(btnCham);
                break;
            case R.id.btCong:
                changePhepTinh(btnCong);
                break;
            case R.id.btTru:
                changePhepTinh(btnTru);
                break;
            case R.id.btNhan:
                changePhepTinh(btnNhan);
                break;
            case R.id.btChia:
                changePhepTinh(btnChia);
                break;
            case R.id.btXoa:
                xoa();
                break;
            case R.id.btXoaHet:
                xoaHet();
            case R.id.btBang:
                tinhtoan();
                break;
            default:
                Log.e("can not find the button was clicked", "");

        }
    }

    public void changePhepTinh(@NonNull Button btn){
        if((pheptinh.endsWith("+") ||
                pheptinh.endsWith("-")||
                pheptinh.endsWith("*")||
                pheptinh.endsWith("/")
            ) &&
            (btn.getText().toString().trim().equals("+") ||
             btn.getText().toString().trim().equals("-") ||
             btn.getText().toString().trim().equals("*") ||
             btn.getText().toString().trim().equals("/")
            )
        )
            pheptinh = pheptinh.substring(0,pheptinh.length() - 1).trim();
        this.pheptinh += btn.getText().toString().trim();
        Log.i("Clicked", "" + pheptinh);
        tvPhepTinh.setText(pheptinh);
    }

    public void xoa(){
        pheptinh = pheptinh.substring(0,pheptinh.length() - 1).trim();
        tvPhepTinh.setText(pheptinh);
    }

    public void xoaHet(){
        pheptinh = "";
        tvPhepTinh.setText(pheptinh);
        kq = "0";
        tvKq.setText(kq);
    }

    public void tinhtoan(){
        tvKq.setText(kq);
    }
}