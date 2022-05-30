package com.xqx.native_simple_test.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.xqx.native_simple_test.BlankFragment2;

import java.util.ArrayList;

/**
 *viewpager加载fragment的时候使用，viewpager的pageradapter适配器
 */
public class PageAdapter extends FragmentPagerAdapter {
    //声明标题文本队列
    private ArrayList<Fragment> list;
    //碎片页适配器的构造函数，传入碎片管理器与标题队列
    public PageAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }
    //获取指定位置的碎片fragment
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }
    //获取fragment的个数
    @Override
    public int getCount() {
        return list.size();
    }
    //获取指定碎片页的标题文本
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "";
    }
}

