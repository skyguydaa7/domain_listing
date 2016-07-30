package com.lbbento.domain.domainlisting.search;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lbbento.domain.data.model.ListingItem;
import com.lbbento.domain.domainlisting.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lbbento on 30/07/2016.
 * Adapter that manages a collection of {@link com.lbbento.domain.data.model.ListingItem}.
 */

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.ListingItemViewHolder> {
    Context ctx;


    public interface OnItemClickListener {
        void onUserItemClicked(ListingItem mListingItem);
    }

    private List<ListingItem> listingItemCollection;
    private final LayoutInflater layoutInflater;

    private OnItemClickListener onItemClickListener;

    public SearchListAdapter(Context ctx, LayoutInflater layoutInflater) {

        this.ctx = ctx;
        this.layoutInflater = layoutInflater;
        this.listingItemCollection = Collections.emptyList(); //Initialize empty
    }

    @Override public int getItemCount() {
        return (this.listingItemCollection != null) ? this.listingItemCollection.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= 0) {
            ListingItem item = listingItemCollection.get(position);
            return (item.isElite() ? 1 : 0);
        }
        return super.getItemViewType(position);
    }

    @Override public ListingItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        int resource;

        switch (viewType) {
            case 1:
                resource = R.layout.row_listing_elite;
                break;
            default:
                resource = R.layout.row_listing;
        }

        return new ListingItemViewHolder(this.layoutInflater.inflate(resource, parent, false));
    }

    @Override public void onBindViewHolder(ListingItemViewHolder holder, final int position) {
        final ListingItem mListingItem = this.listingItemCollection.get(position);

        holder.textViewPrice.setText(mListingItem.getDisplayPrice());
        holder.textViewFeatures.setText(String.format("%s %s, %s %s, %s %s" ,
                                        mListingItem.getBedrooms().toString(),
                                        ctx.getResources().getString(R.string.card_description_bedrooms),
                                        mListingItem.getBathrooms().toString(),
                                        ctx.getResources().getString(R.string.card_description_bathrooms),
                                        mListingItem.getCarspaces().toString(),
                                        ctx.getResources().getString(R.string.card_description_carspaces)
        ));
        holder.textViewLocation.setText(mListingItem.getDisplayableAddress());

        //if Elite
        if (mListingItem.isElite()) {
            ArrayList<String> urls = new ArrayList<>();
            urls.add(mListingItem.getThumbUrl());
            urls.add(mListingItem.getSecondThumbUrl());
            holder.imageSlidePager.setAdapter(new ImagePagerAdapter(ctx, urls));
        }else {
            Picasso.with(ctx).load(mListingItem.getThumbUrl()).placeholder(R.drawable.placeholder).into(holder.imageThumb1);

        }



        //Click Listener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (SearchListAdapter.this.onItemClickListener != null) {
                    SearchListAdapter.this.onItemClickListener.onUserItemClicked(mListingItem);
                }
            }
        });
    }

    @Override public long getItemId(int position) {
        return position;
    }

    public void setListingItemCollection(List<ListingItem> listingItemCollection) {
        this.validateListingItemCollection(listingItemCollection);
        this.listingItemCollection = listingItemCollection;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener (OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private void validateListingItemCollection(List<ListingItem> listingItemCollection) {
        if (listingItemCollection == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
    }

    static class ListingItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.price) TextView textViewPrice;
        @BindView(R.id.features) TextView textViewFeatures;
        @BindView(R.id.location) TextView textViewLocation;
        @Nullable @BindView(R.id.thumbImage1) ImageView imageThumb1;
        @Nullable @BindView(R.id.imageSlidePager) ViewPager imageSlidePager;

        public ListingItemViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }



    public class ImagePagerAdapter extends PagerAdapter {


        private ArrayList<String> imageLinks;
        private LayoutInflater inflater;
        private Context context;


        public ImagePagerAdapter(Context context,ArrayList<String> imageLinks) {
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
            View imageLayout = inflater.inflate(R.layout.page_image, view, false);

            assert imageLayout != null;

            final ImageView imageView = (ImageView) imageLayout
                    .findViewById(R.id.thumbImage2);

            Picasso.with(ctx).load(imageLinks.get(position)).placeholder(R.drawable.placeholder).into(imageView);
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
}


