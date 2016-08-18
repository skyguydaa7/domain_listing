/*
 * Copyright (C) 2016 Lucas Bento Open Source Proj.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lbbento.domain.domainlisting.view.adapter;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lbbento.domain.data.entities.ListingItemEntity;
import com.lbbento.domain.domainlisting.R;
import com.lbbento.domain.domainlisting.view.animation.DepthPageTransformer;
import com.lbbento.domain.domainlisting.view.model.ListingItemViewModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lbbento on 30/07/2016.
 * Adapter that manages a collection of {@link ListingItemEntity}.
 */

public class SearchListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private OnItemClickListener onItemClickListener;
    private static final int VIEW_TYPE_NORMAL = 0;
    private static final int VIEW_TYPE_ELITE = 1;

    private Context ctx;
    private final LayoutInflater layoutInflater;
    private DepthPageTransformer mDepthPageTransformer;


    private List<ListingItemViewModel> listingItemViewModelCollection;


    public SearchListAdapter(Context ctx, DepthPageTransformer depthPageTransformer, LayoutInflater layoutInflater) {

        this.ctx = ctx;
        this.layoutInflater = layoutInflater;
        this.listingItemViewModelCollection = Collections.emptyList(); //Initialize empty
        this.mDepthPageTransformer = depthPageTransformer;
    }

    @Override public int getItemCount() {
        return (this.listingItemViewModelCollection != null) ? this.listingItemViewModelCollection.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= 0) {
            ListingItemViewModel item = listingItemViewModelCollection.get(position);
            return (item.isElite() ? VIEW_TYPE_ELITE : VIEW_TYPE_NORMAL);
        }
        return super.getItemViewType(position);
    }


    @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case VIEW_TYPE_ELITE:
                return new ListingItemEliteViewHolder(this.layoutInflater.inflate(R.layout.row_listing_elite, parent, false));
            default:
                return new ListingItemNormalViewHolder(this.layoutInflater.inflate(R.layout.row_listing_normal, parent, false));
        }

    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ListingItemViewModel mListingItemViewModel = this.listingItemViewModelCollection.get(position);


        switch (holder.getItemViewType()) {
            case VIEW_TYPE_NORMAL:
                final ListingItemNormalViewHolder viewholder = (ListingItemNormalViewHolder) holder;
                setAnimation(viewholder.cardView, position);

                viewholder.textViewPrice.setText(mListingItemViewModel.getDisplayPrice());
                viewholder.textViewFeatureBed.setText(String.format("%s %s",
                        mListingItemViewModel.getBedrooms().toString(),
                        ctx.getResources().getString(R.string.card_description_bedrooms)));
                viewholder.textViewFeatureBath.setText(String.format("%s %s",
                        mListingItemViewModel.getBathrooms().toString(),
                        ctx.getResources().getString(R.string.card_description_bathrooms)));
                viewholder.textViewFeatureCar.setText(String.format("%s %s",
                        mListingItemViewModel.getCarspaces().toString(),
                        ctx.getResources().getString(R.string.card_description_carspaces)));
                viewholder.textViewLocation.setText(mListingItemViewModel.getDisplayableAddress());

                Picasso.with(ctx).load(mListingItemViewModel.getAgencyLogoUrl()).into(viewholder.agencyLogo);
                Picasso.with(ctx).load(mListingItemViewModel.getThumbUrl()).into(viewholder.imageThumb,
                        new Callback() {
                            @Override
                            public void onSuccess() {
                                viewholder.progressBar.setVisibility(View.GONE);
                            }

                            @Override
                            public void onError() {

                            }
                        });
                //Image filter
                viewholder.imageThumb.setColorFilter(ctx.getResources().getColor(R.color.listing_image_filter), PorterDuff.Mode.SRC_ATOP);
                break;

            case VIEW_TYPE_ELITE:
                ListingItemEliteViewHolder viewholderElite = (ListingItemEliteViewHolder) holder;
                setAnimation(viewholderElite.cardView, position);

                viewholderElite.textViewPrice.setText(mListingItemViewModel.getDisplayPrice());
                viewholderElite.textViewFeatureBed.setText(String.format("%s %s",
                        mListingItemViewModel.getBedrooms().toString(),
                        ctx.getResources().getString(R.string.card_description_bedrooms)));
                viewholderElite.textViewFeatureBath.setText(String.format("%s %s",
                        mListingItemViewModel.getBathrooms().toString(),
                        ctx.getResources().getString(R.string.card_description_bathrooms)));
                viewholderElite.textViewFeatureCar.setText(String.format("%s %s",
                        mListingItemViewModel.getCarspaces().toString(),
                        ctx.getResources().getString(R.string.card_description_carspaces)));
                viewholderElite.textViewLocation.setText(mListingItemViewModel.getDisplayableAddress());
                Picasso.with(ctx).load(mListingItemViewModel.getAgencyLogoUrl()).into(viewholderElite.agencyLogo);

                //Images
                List<String> urls = new ArrayList<>();
                urls.add(mListingItemViewModel.getThumbUrl());
                urls.add(mListingItemViewModel.getSecondThumbUrl());
                viewholderElite.imageSlideView.setAdapter(new ImageSlideViewAdapter(ctx, urls));
                viewholderElite.imageSlideView.setPageTransformer(true, mDepthPageTransformer);
                break;

        }

        //Click Listener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (SearchListAdapter.this.onItemClickListener != null) {
                    SearchListAdapter.this.onItemClickListener.onUserItemClicked(mListingItemViewModel);
                }
            }
        });
    }

    @Override public long getItemId(int position) {
        return position;
    }

    public void setListingItemEntityCollection(List<ListingItemViewModel> listingItemViewModelCollection) {
        this.validateListingItemCollection(listingItemViewModelCollection);
        this.listingItemViewModelCollection = listingItemViewModelCollection;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener (OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private void validateListingItemCollection(List<ListingItemViewModel> listingItemViewModelCollection) {
        if (listingItemViewModelCollection == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
    }

    interface ListingItemViewHolder {};

    static class ListingItemNormalViewHolder extends RecyclerView.ViewHolder implements ListingItemViewHolder {
        @BindView(R.id.cardView) CardView cardView;
        @BindView(R.id.price) TextView textViewPrice;
        @BindView(R.id.featureBed) TextView textViewFeatureBed;
        @BindView(R.id.featureBath) TextView textViewFeatureBath;
        @BindView(R.id.featureCar) TextView textViewFeatureCar;
        @BindView(R.id.location) TextView textViewLocation;
        @BindView(R.id.thumbImage) ImageView imageThumb;
        @BindView(R.id.agencyLogo) ImageView agencyLogo;
        @BindView(R.id.progressBar) ProgressBar progressBar;

        public ListingItemNormalViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

    static class ListingItemEliteViewHolder extends RecyclerView.ViewHolder implements ListingItemViewHolder {
        @BindView(R.id.cardView) CardView cardView;
        @BindView(R.id.price) TextView textViewPrice;
        @BindView(R.id.featureBed) TextView textViewFeatureBed;
        @BindView(R.id.featureBath) TextView textViewFeatureBath;
        @BindView(R.id.featureCar) TextView textViewFeatureCar;
        @BindView(R.id.location) TextView textViewLocation;
        @BindView(R.id.agencyLogo) ImageView agencyLogo;
        @Nullable @BindView(R.id.imageSlideView) ViewPager imageSlideView;

        public ListingItemEliteViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }



    private int lastPosition = -1;
    /**
     * Here is the key method to apply the animation
     */
    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition && position < 2)
        {
            Animation animation = AnimationUtils.loadAnimation(ctx, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }



    public interface OnItemClickListener {
        void onUserItemClicked(ListingItemViewModel mListingItemViewModel);
    }
}




