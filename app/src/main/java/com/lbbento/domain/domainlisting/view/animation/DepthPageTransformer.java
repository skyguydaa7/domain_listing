package com.lbbento.domain.domainlisting.view.animation;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by lbbento on 31/07/2016.
 */

public class DepthPageTransformer implements ViewPager.PageTransformer {
    private static float MIN_SCALE = 0.75f;

    @SuppressLint("NewApi")
    @Override
    public void transformPage(View view, float pos) {
        int pageWidth = view.getWidth();

        if (pos < -1) { // [-Infinity,-1)
            view.setAlpha(0);
        }else if (pos <= 0) { // [-1,0]
            view.setAlpha(1);
            view.setTranslationX(0);
            view.setScaleX(1);
            view.setScaleY(1);
        }else if (pos <= 1) { // (0,1]
            view.setAlpha(1 - pos);
            view.setTranslationX(pageWidth * -pos);
            float scaleFactor = MIN_SCALE + (1 - MIN_SCALE)
                    * (1 - Math.abs(pos));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
        }else
            view.setAlpha(0);
    }
}