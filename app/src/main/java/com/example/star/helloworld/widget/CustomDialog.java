package com.example.star.helloworld.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.example.star.helloworld.R;

public class CustomDialog extends Dialog implements View.OnClickListener {

    private TextView mTvTitle,mTvMessage,mTvCancel,mTvConfirm;

    private String title,message,cancel,confirm;

    private IOnCancelListener cancelListener;

    private IOnConfirmListener confirmListener;

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setCancel(String cancel,IOnCancelListener listener) {
        this.cancel = cancel;
        this.cancelListener = listener;
        return this;
    }

    public CustomDialog setConfirm(String confirm,IOnConfirmListener listener) {
        this.confirm = confirm;
        this.confirmListener = listener;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);
        mTvTitle = findViewById(R.id.tv_title);
        mTvMessage = findViewById(R.id.tv_message);
        mTvCancel = findViewById(R.id.tv_cancel);
        mTvConfirm = findViewById(R.id.tv_confirm);
        if (!TextUtils.isEmpty(title)) {
            mTvTitle.setText(title);
        }
        if (!TextUtils.isEmpty(message)) {
            mTvMessage.setText(message);
        }
        if (!TextUtils.isEmpty(cancel)) {
            mTvCancel.setText(cancel);
        }
        if (!TextUtils.isEmpty(confirm)) {
            mTvConfirm.setText(confirm);
        }
        mTvCancel.setOnClickListener(this);
        mTvConfirm.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.tv_cancel:
               if(cancelListener != null){
                   cancelListener.OnCancel(this);
               }
               break;
           case R.id.tv_confirm:
               if(confirmListener != null){
                   confirmListener.OnConfirm(this);
               }
               break;
       }
    }


    public interface IOnCancelListener{
        void OnCancel(CustomDialog dialog);
    }

    public interface IOnConfirmListener{
        void OnConfirm(CustomDialog dialog);
    }
}

