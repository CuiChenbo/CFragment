package com.ccb.admin.fragmentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt1,bt2,bt3,bt4,bt5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt1:
                startActivity(new Intent(MainActivity.this,FragmentReplaceActivity.class));
                break;
            case R.id.bt2:
                startActivity(new Intent(MainActivity.this,FragmentShowHideActivity.class));
                break;
            case R.id.bt3:
                startActivity(new Intent(MainActivity.this,FragmentShowHide2Activity.class));
                break;
            case R.id.bt4:
                startActivity(new Intent(MainActivity.this,FragmentOverlayActivity.class));
                break;
            case R.id.bt5:
                startActivity(new Intent(MainActivity.this,FragmentShowHideClipChildrenActivity.class));
                break;
        }
    }
}
