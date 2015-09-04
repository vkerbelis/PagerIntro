package com.example.vidmantas.viewpagerintro;

import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private PageIndicator mViewPageIndicator;
    private IntroAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPageIndicator = (PageIndicator) findViewById(R.id.page_indicator);
        mViewPagerAdapter = new IntroAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.setPageTransformer(false, new IntroPageTransformer());
        mViewPageIndicator.setViewPager(mViewPager);
        mViewPageIndicator.setOnPageChangeListener(new IntroPageScrollListener());
    }

    public class IntroPageScrollListener implements ViewPager.OnPageChangeListener {

        Integer[] colors = { Color.parseColor("#03A9F4"), Color.parseColor("#4CAF50"), Color.parseColor("#000000") };
        ArgbEvaluator argbEvaluator;

        public IntroPageScrollListener() {
            this.argbEvaluator = new ArgbEvaluator();
        }

        @Override
        public void onPageScrolled(int position, float offset, int offsetPx) {
            if(position < (mViewPagerAdapter.getCount() -1) && position < (colors.length - 1)) {

                mViewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(offset, colors[position], colors[position + 1]));

            } else {

                mViewPager.setBackgroundColor(colors[colors.length - 1]);

            }
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int position) {

        }

    }

}
