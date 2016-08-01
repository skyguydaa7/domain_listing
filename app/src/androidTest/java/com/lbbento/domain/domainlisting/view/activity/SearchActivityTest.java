package com.lbbento.domain.domainlisting.view.activity;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.Fragment;

import com.lbbento.domain.domainlisting.R;
import com.lbbento.domain.domainlisting.view.fragment.SearchListFragment;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by lbbento on 1/08/2016.
 */

@RunWith(AndroidJUnit4.class)
public class SearchActivityTest {


    @Rule
    public ActivityTestRule<SearchListActivity> mActivityRule =
            new DaggerActivityTestRule<>(SearchListActivity.class, new DaggerActivityTestRule.OnBeforeActivityLaunchedListener<SearchListActivity>() {
                @Override
                public void beforeActivityLaunched(@NonNull Application application, @NonNull SearchListActivity activity) {

                }
            });

    @Test
    public void testContainsUserListFragment() {
        Fragment searchFragment =
                mActivityRule.getActivity().getSupportFragmentManager().findFragmentById(R.id.main_content_frame);

        assertThat(searchFragment, is(notNullValue()));
    }


}
