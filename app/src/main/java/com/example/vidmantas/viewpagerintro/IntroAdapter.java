package com.example.vidmantas.viewpagerintro;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * @author Vidmantas Kerbelis (vkerbelis@yahoo.com) on 2015-08-05.
 */
public class IntroAdapter extends FragmentPagerAdapter {

    public IntroAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return IntroFragment.newInstance(Color.parseColor("#03A9F4"), position); // blue
            case 1:
                return IntroFragment.newInstance(Color.parseColor("#4CAF50"), position); // green
            default:
                return IntroFragment.newInstance(Color.parseColor("#000000"), position);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

}
