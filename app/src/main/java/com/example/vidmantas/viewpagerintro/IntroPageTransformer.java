package com.example.vidmantas.viewpagerintro;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import java.util.logging.Logger;

/**
 * @author Vidmantas Kerbelis (vkerbelis@yahoo.com) on 2015-08-05.
 */
public class IntroPageTransformer implements ViewPager.PageTransformer {

    private int mDuperPadding = -1;
    private int mDuperPaddingTimesPosition;

    @Override
    public void transformPage(View page, float position) {

        // Get the page index from the tag. This makes
        // it possible to know which page index you're
        // currently transforming - and that can be used
        // to make some important performance improvements.
        int pagePosition = (int) page.getTag();

        // Here you can do all kinds of stuff, like get the
        // width of the page and perform calculations based
        // on how far the user has swiped the page.
        int pageWidth = page.getWidth();
        float pageWidthTimesPosition = pageWidth * position;
        float absPosition = Math.abs(position);

        // Now it's time for the effects
        if (position <= -1.0f || position >= 1.0f) {

            // The page is not visible. This is a good place to stop
            // any potential work / animations you may have running.

        } else if (position == 0.0f) {

            // The page is selected. This is a good time to reset Views
            // after animations as you can't always count on the PageTransformer
            // callbacks to match up perfectly.

        } else {

            // The page is currently being scrolled / swiped. This is
            // a good place to show animations that react to the user's
            // swiping as it provides a good user experience.

            // Let's start by animating the title.
            // We want it to fade as it scrolls out
            View title = page.findViewById(R.id.title);
            title.setAlpha(1.0f - absPosition);

            // Now the description. We also want this one to
            // fade, but the animation should also slowly move
            // down and out of the screen
            View description = page.findViewById(R.id.description);
            description.setTranslationY(-pageWidthTimesPosition / 2f);
            description.setAlpha(1.0f - absPosition);

            // Now, we want the image to move to the right,
            // i.e. in the opposite direction of the rest of the
            // content while fading out
            View computer = page.findViewById(R.id.computer);

            // We're attempting to create an effect for a View
            // specific to one of the pages in our ViewPager.
            // In other words, we need to check that we're on
            // the correct page and that the View in question
            // isn't null.
            if (pagePosition == 0 && computer != null) {
//                computer.setAlpha(1.0f - absPosition);
                computer.setTranslationX(-pageWidthTimesPosition * 0.35f);
            }

            View duper = page.findViewById(R.id.duper);
            if (pagePosition == 1 && duper != null) {
                if (mDuperPadding == -1) {
                    mDuperPadding = duper.getPaddingTop();
                }
                duper.setTranslationX(-pageWidthTimesPosition * 0.49f);
            }

            View tv = page.findViewById(R.id.tv);

            if (pagePosition == 2 && tv != null) {
                tv.setTranslationX(-pageWidthTimesPosition * 0.35f);
                tv.setTranslationY(pageWidthTimesPosition * 0.35f);
            }

            // Finally, it can be useful to know the direction
            // of the user's swipe - if we're entering or exiting.
            // This is quite simple:
            if (position < 0) {
                if (pagePosition == 1 && duper != null) {
                    mDuperPaddingTimesPosition = (int) (mDuperPadding + mDuperPadding * position);
                    duper.setPadding(mDuperPaddingTimesPosition, mDuperPaddingTimesPosition,
                            mDuperPaddingTimesPosition, mDuperPaddingTimesPosition);
                    duper.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }
                // Create your out animation here
            } else {
                if (pagePosition == 1 && duper != null) {
                    mDuperPaddingTimesPosition = (int) (mDuperPadding - mDuperPadding * position);
                    duper.setPadding(mDuperPaddingTimesPosition, mDuperPaddingTimesPosition,
                            mDuperPaddingTimesPosition, mDuperPaddingTimesPosition);
                    duper.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }
                // Create your in animation here
            }
        }
    }

}
