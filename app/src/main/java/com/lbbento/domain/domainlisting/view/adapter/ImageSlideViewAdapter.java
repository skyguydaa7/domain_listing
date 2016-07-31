package com.lbbento.domain.domainlisting.view.adapter;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.lbbento.domain.domainlisting.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lbbento on 31/07/2016.
 */

public class ImageSlideViewAdapter extends PagerAdapter {


    private List<String> imageLinks;
    private LayoutInflater inflater;
    private Context context;


    public ImageSlideViewAdapter(Context context, List<String> imageLinks) {
        this.context = context;
        this.imageLinks = imageLinks;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return imageLinks.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.item_image, view, false);

        assert imageLayout != null;

        final ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.item_image);
        final ProgressBar progress = (ProgressBar) imageLayout
                .findViewById(R.id.progressBar);
        //Image filter
        imageView.setColorFilter(context.getResources().getColor(R.color.listing_image_filter), PorterDuff.Mode.SRC_ATOP);

        Picasso.with(context).load(imageLinks.get(position)).into(imageView,
                new Callback() {
                    @Override
                    public void onSuccess() {
                        progress.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {
                    }
                });

        view.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }


}