package com.example.star.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.star.helloworld.util.ToastUtil;

public class EventActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnEvent = findViewById(R.id.btn_event);
        //内部类实现
/*        OnClick onClick = new OnClick();
        mBtnEvent.setOnClickListener(onClick);*/
        //匿名内部类
/*        mBtnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showMsg(EventActivity.this,"click...");
            }
        });*/
        //通过事件源所在的类实现
/*        mBtnEvent.setOnClickListener(EventActivity.this);*/
        //通过外部类实现（不常用）
        mBtnEvent.setOnClickListener(new MyClickListener(EventActivity.this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_event:
                ToastUtil.showMsg(EventActivity.this,"click...");
                break;
        }
    }

    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_event:
                    ToastUtil.showMsg(EventActivity.this,"click...");
                    break;
            }
        }
    }
}
