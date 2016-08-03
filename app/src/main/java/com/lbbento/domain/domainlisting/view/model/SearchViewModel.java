package com.lbbento.domain.domainlisting.view.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lbbento on 30/07/2016.
 * Represents the List of Results API Object returned by the SearchEndpoint
 */

public class SearchViewModel {

    @SerializedName(value="ListingResults")
    private ListingResultViewModel listingResultViewModel;

    public SearchViewModel(ListingResultViewModel listingResultViewModel) {
        this.listingResultViewModel = listingResultViewModel;
    }



    public ListingResultViewModel getListingResultViewModel() {
        return listingResultViewModel;
    }

    public void setListingResultViewModel(ListingResultViewModel listingResultViewModel) {
        this.listingResultViewModel = listingResultViewModel;
    }
}
