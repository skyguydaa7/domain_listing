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

import com.lbbento.domain.data.model.ListingItemEntity;
import com.lbbento.domain.domainlisting.R;
import com.lbbento.domain.domainlisting.view.animation.DepthPageTransformer;
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


    private List<ListingItemEntity> listingItemEntityCollection;


    public SearchListAdapter(Context ctx, DepthPageTransformer depthPageTransformer, LayoutInflater layoutInflater) {

        this.ctx = ctx;
        this.layoutInflater = layoutInflater;
        this.listingItemEntityCollection = Collections.emptyList(); //Initialize empty
        this.mDepthPageTransformer = depthPageTransformer;
    }

    @Override public int getItemCount() {
        return (this.listingItemEntityCollection != null) ? this.listingItemEntityCollection.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= 0) {
            ListingItemEntity item = listingItemEntityCollection.get(position);
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
        final ListingItemEntity mListingItemEntity = this.listingItemEntityCollection.get(position);


        switch (holder.getItemViewType()) {
            case VIEW_TYPE_NORMAL:
                final ListingItemNormalViewHolder viewholder = (ListingItemNormalViewHolder) holder;
                setAnimation(viewholder.cardView, position);

                viewholder.textViewPrice.setText(mListingItemEntity.getDisplayPrice());
                viewholder.textViewFeatureBed.setText(String.format("%s %s",
                        mListingItemEntity.getBedrooms().toString(),
                        ctx.getResources().getString(R.string.card_description_bedrooms)));
                viewholder.textViewFeatureBath.setText(String.format("%s %s",
                        mListingItemEntity.getBathrooms().toString(),
                        ctx.getResources().getString(R.string.card_description_bathrooms)));
                viewholder.textViewFeatureCar.setText(String.format("%s %s",
                        mListingItemEntity.getCarspaces().toString(),
                        ctx.getResources().getString(R.string.card_description_carspaces)));
                viewholder.textViewLocation.setText(mListingItemEntity.getDisplayableAddress());

                Picasso.with(ctx).load(mListingItemEntity.getAgencyLogoUrl()).into(viewholder.agencyLogo);
                Picasso.with(ctx).load(mListingItemEntity.getThumbUrl()).into(viewholder.imageThumb,
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

                viewholderElite.textViewPrice.setText(mListingItemEntity.getDisplayPrice());
                viewholderElite.textViewFeatureBed.setText(String.format("%s %s",
                        mListingItemEntity.getBedrooms().toString(),
                        ctx.getResources().getString(R.string.card_description_bedrooms)));
                viewholderElite.textViewFeatureBath.setText(String.format("%s %s",
                        mListingItemEntity.getBathrooms().toString(),
                        ctx.getResources().getString(R.string.card_description_bathrooms)));
                viewholderElite.textViewFeatureCar.setText(String.format("%s %s",
                        mListingItemEntity.getCarspaces().toString(),
                        ctx.getResources().getString(R.string.card_description_carspaces)));
                viewholderElite.textViewLocation.setText(mListingItemEntity.getDisplayableAddress());
                Picasso.with(ctx).load(mListingItemEntity.getAgencyLogoUrl()).into(viewholderElite.agencyLogo);

                //Images
                List<String> urls = new ArrayList<>();
                urls.add(mListingItemEntity.getThumbUrl());
                urls.add(mListingItemEntity.getSecondThumbUrl());
                viewholderElite.imageSlideView.setAdapter(new ImageSlideViewAdapter(ctx, urls));
                viewholderElite.imageSlideView.setPageTransformer(true, mDepthPageTransformer);
                break;

        }

        //Click Listener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (SearchListAdapter.this.onItemClickListener != null) {
                    SearchListAdapter.this.onItemClickListener.onUserItemClicked(mListingItemEntity);
                }
            }
        });
    }

    @Override public long getItemId(int position) {
        return position;
    }

    public void setListingItemEntityCollection(List<ListingItemEntity> listingItemEntityCollection) {
        this.validateListingItemCollection(listingItemEntityCollection);
        this.listingItemEntityCollection = listingItemEntityCollection;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener (OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private void validateListingItemCollection(List<ListingItemEntity> listingItemEntityCollection) {
        if (listingItemEntityCollection == null) {
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
        void onUserItemClicked(ListingItemEntity mListingItemEntity);
    }
}




