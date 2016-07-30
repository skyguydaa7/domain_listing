package com.lbbento.domain.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lbbento on 30/07/2016.
 * Represents the List of Results API Object returned by the SearchEndpoint
 */

public class SearchModel {

    @SerializedName(value="ListingResults")
    private ListingResult listingResult;

    public SearchModel(ListingResult listingResult) {
        this.listingResult = listingResult;
    }



    public ListingResult getListingResult() {
        return listingResult;
    }

    public void setListingResult(ListingResult listingResult) {
        this.listingResult = listingResult;
    }
}
