package com.example.star.helloworld;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.star.helloworld.util.ToastUtil;

public class ProgressActivity extends AppCompatActivity {

    private ProgressBar mPb3;
    private Button mBtnStart,mBtnProgressDialog1,mBtnProgressDialog2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        mPb3 = findViewById(R.id.pb3);
        mBtnStart = findViewById(R.id.btn_start);
        mBtnProgressDialog1 = findViewById(R.id.btn_progress_dialog1);
        mBtnProgressDialog2 = findViewById(R.id.btn_progress_dialog2);
        mPb3.setProgress(30);
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(0);
            }
        });
        mBtnProgressDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                //已弃用
            }
        });
    }



    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(mPb3.getProgress() < 100){
                handler.postDelayed(runnable,500);
            }else {
                ToastUtil.showMsg(ProgressActivity.this,"加载完成");
            }
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mPb3.setProgress(mPb3.getProgress() + 5);
            handler.sendEmptyMessage(0);
        }
    };
}
