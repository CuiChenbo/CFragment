package com.ccb.admin.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.ccb.admin.fragmentdemo.fragment.Fragment1;
import com.ccb.admin.fragmentdemo.fragment.Fragment2;
import com.ccb.admin.fragmentdemo.fragment.Fragment3;
import com.ccb.admin.fragmentdemo.fragment.Fragment4;

public class FragmentReplaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewResource());
        initView();
        initData();
        initList();
    }
    private RadioGroup rg;
    private Fragment HomeFm = null,SpcFm = null, OrderFm = null, MyFm = null;

    private final class RadioGroupOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            /**
             * 替换fragment
             */
            switch (checkedId) {
                case R.id.rb_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl, HomeFm).commit();
                    break;
                case R.id.rb_shoppingcart:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl, SpcFm).commit();
                    break;
                case R.id.rb_orderfrom:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl, OrderFm).commit();
                    break;
                case R.id.rb_my:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl, MyFm).commit();
                    break;
            }
        }
    }


    public int getContentViewResource() {
        return R.layout.activity_fragment;
    }


    protected void initView() {
        rg = findViewById(R.id.rg);
    }


    protected void initData() {
        HomeFm  = new Fragment1();
        SpcFm = new Fragment2();
        OrderFm = new Fragment3();
        MyFm = new Fragment4();
    }

    protected void initList() {
        rg.setOnCheckedChangeListener(new RadioGroupOnCheckedChangeListener());
        rg.check(R.id.rb_home);
    }
}
