package com.hcmute.edu.vn.calculatorapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityDemo extends AppCompatActivity {

    double kq = 0;
    String toantu ="";
    boolean trangthaiTT = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giaodiendemo);
    }
    public void Bt_Click(View view){
        TextView hienthi = (TextView)findViewById(R.id.tvkq);

        if(hienthi.getText().equals("0") == true || trangthaiTT == true)
        {
            hienthi.setText("");
        }
        trangthaiTT = false;
        Button button = (Button)view;
        if(button.getText().toString().equals("."))
        {
            if(hienthi.getText().toString().contains(".") == false){
                hienthi.setText(hienthi.getText().toString() + button.getText().toString());
            }
        }else{
            hienthi.setText(hienthi.getText().toString() + button.getText().toString());
        }
    }
    public void bt_Clear(View view){
        TextView hienthi = (TextView)findViewById(R.id.tvkq);
        hienthi.setText("0");
        kq = 0;
        toantu = "";
        trangthaiTT = false;
        reset_Color();
    }
    public void bt_delete(View view){
        TextView hienthi = (TextView)findViewById(R.id.tvkq);
        String chuoiKq = hienthi.getText().toString();
        if(chuoiKq.length() > 1 && !(Double.parseDouble(hienthi.getText().toString()) <=-1 && Double.parseDouble(hienthi.getText().toString()) >=-9)){
            hienthi.setText(chuoiKq.substring(0, chuoiKq.length() - 1));
        }else{
            hienthi.setText("0");
        }
    }
    public void ToanTu(View view){
        reset_Color();
        if(kq != 0)
        {
            click_Bang(view);
        }else {
            TextView hienthi = (TextView) findViewById(R.id.tvkq);
            if(toantu.equals("-")){
                kq = (-1)*Double.parseDouble(hienthi.getText().toString());
            }else{
                kq = Double.parseDouble(hienthi.getText().toString());
            }
        }
        Button button = (Button)view;
        button.setBackgroundColor(Color.rgb(255,140,0));
        toantu = button.getText().toString();
        trangthaiTT = true;
    }
    public void click_Bang(View view){
        TextView hienthi = (TextView)findViewById(R.id.tvkq);
        String chuoiKq = hienthi.getText().toString();
        switch (toantu){
            case "+":
                kq = kq + Double.parseDouble(chuoiKq);
                HienThi(kq);
                break;
            case "*":
                kq = kq * Double.parseDouble(chuoiKq);
                HienThi(kq);
                break;
            case "-":
                kq = kq - Double.parseDouble(chuoiKq);
                HienThi(kq);
                break;
            case "/":
                kq = kq / Double.parseDouble(chuoiKq);
                HienThi(kq);
                break;
            default:
                break;
        }
        toantu = "";
        reset_Color();
    }
    public void HienThi(double kq)
    {
        TextView hienthi = (TextView)findViewById(R.id.tvkq);
        if(kq == (int)kq)
        {
            hienthi.setText(String.valueOf((int) kq));
        }
        else {
            hienthi.setText(Double.toString(kq));
        }
    }
    void reset_Color()
    {
        Button bt1 = (Button)findViewById(R.id.tru);
        bt1.setBackgroundColor(Color.rgb(100,29,67));
        bt1 = (Button) findViewById(R.id.cong);
        bt1.setBackgroundColor(Color.rgb(100,29,67));
        bt1 = (Button) findViewById(R.id.nhan);
        bt1.setBackgroundColor(Color.rgb(100,29,67));
        bt1 = (Button) findViewById(R.id.chia);
        bt1.setBackgroundColor(Color.rgb(100,29,67));

    }
}