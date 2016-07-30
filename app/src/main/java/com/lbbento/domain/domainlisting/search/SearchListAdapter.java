package com.lbbento.domain.domainlisting.search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lbbento.domain.data.model.ListingItem;
import com.lbbento.domain.domainlisting.R;

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

    @Override public ListingItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.row_listing, parent, false);
        return new ListingItemViewHolder(view);
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


//        txtTimezone.setText(forecast.getTimezone());
//        viewWidgets.txtMore.setText(String.format("%s:%s\n%s:%s\n%s:%s", getResources().getString(R.string.format_dew_point),
//                forecast.getCurrently().getDewPoint().toString(),
//                getResources().getString(R.string.format_pressure),
//                forecast.getCurrently().getPressure().toString(),
//                getResources().getString(R.string.format_cloud_cover),
//                forecast.getCurrently().getCloudCover().toString()));
//        String icon = Forecast.icons.get(forecast.getCurrently().getIcon()).toString();
//        Picasso.with(getContext()).load(icon).placeholder(R.drawable.placeholder).into(viewWidgets.icon);



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

        public ListingItemViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}