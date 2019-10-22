package com.example.star.helloworld;

import android.app.Activity;
import android.view.View;

import com.example.star.helloworld.util.ToastUtil;

public class MyClickListener implements View.OnClickListener {

    private Activity mActivity;

    public MyClickListener(Activity activity){
        this.mActivity = activity;
    }

    @Override
    public void onClick(View v) {
        ToastUtil.showMsg(mActivity,"Click...");

    }
}
