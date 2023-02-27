package com.hcmute.edu.vn.calculatorapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

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
        Log.i("A button was CLICKED", "" + view.getId());
        switch (view.getId()) {
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
                break;
            case R.id.btBang:
                tinhtoan();
                break;
            default:
                Log.e("can not find the button was clicked", "");

        }
    }

    public void changePhepTinh(@NonNull Button btn) {
        if ((pheptinh.endsWith("+") ||
                pheptinh.endsWith("-") ||
                pheptinh.endsWith("*") ||
                pheptinh.endsWith("/")
        ) &&
                (btn.getText().toString().trim().equals("+") ||
                        btn.getText().toString().trim().equals("-") ||
                        btn.getText().toString().trim().equals("*") ||
                        btn.getText().toString().trim().equals("/")
                )
        )
            pheptinh = pheptinh.substring(0, pheptinh.length() - 1).trim();
        this.pheptinh += btn.getText().toString().trim();
        Log.i("Clicked", "" + pheptinh);
        tvPhepTinh.setText(pheptinh);
    }

    public void xoa() {
        pheptinh = pheptinh.substring(0, pheptinh.length() - 1).trim();
        tvPhepTinh.setText(pheptinh);
    }

    public void xoaHet() {
        pheptinh = "";
        kq = "0";
        tvPhepTinh.setText(pheptinh);
        tvKq.setText(kq);
    }

    public void tinhtoan() {
        if (pheptinh.endsWith("+") || pheptinh.endsWith("-") || pheptinh.endsWith("*") || pheptinh.endsWith("/"))
            pheptinh = pheptinh.substring(0, pheptinh.length() - 1).trim();
        String val = pheptinh;
        Log.i("Tinh toan", "" + pheptinh);
        double result = eval(pheptinh);
//        double result = 0;
        kq = String.valueOf(result);
        Log.i("Ket qua", "" + kq);
        tvPhepTinh.setText(pheptinh);
        tvKq.setText(kq);
    }

    //eval function
    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
                Log.i("nextChar", "" + ch + " : " + str.substring(0, pos));
            }

            boolean eat(int charToEat) {
                if (ch == charToEat) {
                    Log.i("eat", "" + charToEat + " : " + str.substring(0, pos));
                    nextChar();
                    return true;
                }
                Log.i("eat", "");
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch + " : " + str.substring(0, pos));
                Log.i("parse", ""+x + " : " + str.substring(0, pos));
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if (eat('+')) x += parseTerm(); // Addition
                    else if (eat('-')) x -= parseTerm(); // Subtraction
                    else {
                        Log.i("parseExpression", ""+x + " : " + str.substring(0, pos));
                        return x;
                    }
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if (eat('*')) x *= parseFactor(); // Multiplication
                    else if (eat('/')) x /= parseFactor(); // Division
                    else return x;
                }
            }

            double parseFactor() {
                double x;
                int startPos = this.pos;
                if ((ch >= '0' && ch <= '9') || ch == '.') { // Numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                    Log.i("parseFactor", ""+x + " : " + str.substring(startPos, this.pos));
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch + " : " + str.substring(0, pos));
                }
                return x;
            }
        }.parse();
    }

}