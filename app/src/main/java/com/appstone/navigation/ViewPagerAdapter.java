package com.appstone.navigation;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private Context context;
    private String[] titles;

    public ViewPagerAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        this.context = context;

        titles = context.getResources().getStringArray(R.array.tab_title);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 1:
                Bundle args = new Bundle();
                args.putString("TITLE", "Search Fragment");
                fragment = new SearchFragment();
                fragment.setArguments(args);
                break;

            case 2:
                Bundle args1 = new Bundle();
                args1.putString("TITLE", "Logout Fragment");
                fragment = new LogoutFragment();
                fragment.setArguments(args1);
                break;

            default:
                fragment = new HomeFragment();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
