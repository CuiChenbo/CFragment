package com.ccb.admin.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.ccb.admin.fragmentdemo.fragment.Fragment1;
import com.ccb.admin.fragmentdemo.fragment.Fragment2;
import com.ccb.admin.fragmentdemo.fragment.Fragment3;
import com.ccb.admin.fragmentdemo.fragment.Fragment4;

public class FragmentShowHide2Activity extends AppCompatActivity {

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

    private final class RgOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            switch (checkedId) {
                case R.id.rb_home:
                    switchFragment(showFragment,HomeFm);
                    break;
                case R.id.rb_shoppingcart:
                    switchFragment(showFragment,SpcFm);
                    break;
                case R.id.rb_orderfrom:
                    switchFragment(showFragment,OrderFm);
                    break;
                case R.id.rb_my:
                    switchFragment(showFragment,MyFm);
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
        rg.setOnCheckedChangeListener(new RgOnCheckedChangeListener());
        rg.check(R.id.rb_home);
    }

    private Fragment showFragment;  //当前显示的fragment

    private void switchFragment(Fragment hide,Fragment show){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (hide == show)return;
        if (hide != null){
            if (!show.isAdded()){
                ft.hide(hide).add(R.id.fl, show).commit();
            }else{
                ft.hide(hide).show(show).commit();
            }
        }else {
            if (!show.isAdded()){
                ft.add(R.id.fl, show).commit();
            }else{
                ft.show(show).commit();
            }
        }
        showFragment = show;
    }
}
