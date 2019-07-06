package com.example.hozoor;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class page_adapter extends FragmentPagerAdapter {

    int numoftabs;

    public page_adapter(FragmentManager fm,int numoftabs) {
        super(fm);
        this.numoftabs=numoftabs;


    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new ghayebha();

                case 1:
                    return new hazerha();

                    default:
                        return null;


        }

    }

    @Override
    public int getCount() {
        return numoftabs;
    }
}
