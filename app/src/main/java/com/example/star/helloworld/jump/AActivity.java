package com.example.star.helloworld.jump;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.star.helloworld.R;

public class AActivity extends AppCompatActivity {

    private Button mBtnJump,mBtnJump2;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.d("AActivity","-----onCreate-----");
        Log.d("AActivity","taskid:"+getTaskId()+"  ,hash:"+hashCode());
        logtaskName();
        mBtnJump = findViewById(R.id.jump);
        mBtnJump2 = findViewById(R.id.jump_2);
        mBtnJump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this,AActivity.class);
                startActivity(intent);
            }
        });
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示跳转1
                Intent intent = new Intent(AActivity.this,BActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name","张晨曦");
                bundle.putInt("number",88);
                intent.putExtras(bundle);
                startActivity(intent);
                //startActivityForResult(intent,0);

                //显示跳转2
/*                Intent intent = new Intent();
                intent.setClass(AActivity.this,BActivity.class);
                startActivity(intent);*/

                //显示跳转3
/*                Intent intent = new Intent();
                intent.setClassName(AActivity.this,"com.example.star.helloworld.jump.BActivity");
                startActivity(intent);*/

                //显示跳转4
/*                Intent intent = new Intent();
                intent.setComponent(new ComponentName(AActivity.this,"com.example.star.helloworld.jump.BActivity"));
                startActivity(intent);*/

                //隐式
/*                Intent intent = new Intent();
                intent.setAction("com.star.test.BActivity");
                startActivity(intent);*/

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this,data.getExtras().getString("title"),Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("AActivity","-----onNewIntent-----");
        Log.d("AActivity","taskid:"+getTaskId()+"  ,hash:"+hashCode());
        logtaskName();
    }

    private void logtaskName(){
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(),PackageManager.GET_META_DATA);
            Log.d("AActivity",info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }
}
