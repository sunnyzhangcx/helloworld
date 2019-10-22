package com.example.star.helloworld;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.star.helloworld.datastorage.DataStroageActivity;
import com.example.star.helloworld.fragment.AFragment;
import com.example.star.helloworld.fragment.ContainerActivity;
import com.example.star.helloworld.jump.AActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUI,mBtnJump,mBtnFragment,mBtnEvent,mBtnData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI = findViewById(R.id.btn_ui);
        mBtnJump = findViewById(R.id.btn_jump);
        mBtnFragment = findViewById(R.id.btn_fragment);
        mBtnEvent = findViewById(R.id.btn_event);
        mBtnData = findViewById(R.id.btn_data);
        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnJump.setOnClickListener(onClick);
        mBtnFragment.setOnClickListener(onClick);
        mBtnEvent.setOnClickListener(onClick);
        mBtnData.setOnClickListener(onClick);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);

    }

    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this,UIActivity.class);
                    break;
                case R.id.btn_jump:
                    intent = new Intent(MainActivity.this,AActivity.class);
                    break;
                case R.id.btn_fragment:
                    intent = new Intent(MainActivity.this,ContainerActivity.class);
                    break;
                case R.id.btn_event:
                    intent = new Intent(MainActivity.this,EventActivity.class);
                    break;
                case R.id.btn_data:
                    intent = new Intent(MainActivity.this,DataStroageActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
