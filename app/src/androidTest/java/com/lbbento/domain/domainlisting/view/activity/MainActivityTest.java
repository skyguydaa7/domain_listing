package com.lbbento.domain.domainlisting.view.activity;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by lbbento on 1/08/2016.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest  {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testInitialization() {
        
    }

}
