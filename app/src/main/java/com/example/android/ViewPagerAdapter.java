package com.example.android;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;




import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class vewpageAdapter extends FragmentPagerAdapter {

    final List<Fragment> fragmentList = new ArrayList<>();
    final List<String>  fragmentTitle = new ArrayList<>();


    public vewpageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public  void addFragment(Fragment fragment , String title){
        fragmentList.add(fragment);
        fragmentTitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}