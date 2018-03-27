package com.ccb.admin.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.ccb.admin.fragmentdemo.fragment.Fragment1;
import com.ccb.admin.fragmentdemo.fragment.Fragment2;
import com.ccb.admin.fragmentdemo.fragment.Fragment3;
import com.ccb.admin.fragmentdemo.fragment.Fragment4;

public class FragmentShowHideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewResource());
        initView();
        initData();
        initList();
    }



    private FrameLayout fl;
    private RadioGroup rg;
    private Fragment HomeFm = null,SpcFm = null, OrderFm = null, MyFm = null;

    private final class RadioGroupOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            if (HomeFm != null) {
                getSupportFragmentManager().beginTransaction().hide(HomeFm).commit();
            }
            if (SpcFm != null) {
                getSupportFragmentManager().beginTransaction().hide(SpcFm).commit();
            }
            if (OrderFm != null) {
                getSupportFragmentManager().beginTransaction().hide(OrderFm).commit();
            }
            if (MyFm != null) {
                getSupportFragmentManager().beginTransaction().hide(MyFm).commit();
            }
            switch (checkedId) {
                case R.id.rb_home:
                    if (HomeFm == null) {
                        HomeFm = new Fragment1();
                        getSupportFragmentManager().beginTransaction().add(R.id.fl, HomeFm).commit();
                    } else {
                        getSupportFragmentManager().beginTransaction().show(HomeFm).commit();
                    }
                    break;
                case R.id.rb_shoppingcart:
                    if (SpcFm == null) {
                        SpcFm = new Fragment2();
                        getSupportFragmentManager().beginTransaction().add(R.id.fl, SpcFm).commit();
                    } else {
                        getSupportFragmentManager().beginTransaction().show(SpcFm).commit();
                    }
                    break;

                case R.id.rb_orderfrom:
                    if (OrderFm == null) {
                        OrderFm = new Fragment3();
                        getSupportFragmentManager().beginTransaction().add(R.id.fl, OrderFm).commit();
                    } else {
                        getSupportFragmentManager().beginTransaction().show(OrderFm).commit();
                    }
                    break;
                case R.id.rb_my:
                    if (MyFm == null) {
                        MyFm = new Fragment4();
                        getSupportFragmentManager().beginTransaction().add(R.id.fl, MyFm).commit();
                    } else {
                        getSupportFragmentManager().beginTransaction().show(MyFm).commit();
                    }
                    break;
            }
        }
    }


    public int getContentViewResource() {
        return R.layout.activity_fragment;
    }


    protected void initView() {
        fl = findViewById(R.id.fl);
        rg = findViewById(R.id.rg);

    }


    protected void initData() {
    }


    protected void initList() {
        rg.setOnCheckedChangeListener(new RadioGroupOnCheckedChangeListener());
        rg.check(R.id.rb_home);
    }
}
