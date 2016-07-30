package com.lbbento.domain.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lbbento on 30/07/2016.
 * Represents the mapping to the API Object returned by the SearchEndpoint , ListingResults
 */

public class ListingResult {

    @SerializedName(value="Listings")
    private List<ListingItem> listingItems;

    @SerializedName(value="ResultsReturned")
    private Integer resultsReturned;

    @SerializedName(value="ResultsTotal")
    private Integer resultsTotal;

    public ListingResult(List<ListingItem> listingItems) {
        this.listingItems = listingItems;
    }

    public List<ListingItem> getListingItems() {
        return listingItems;
    }

    public void setListingItems(List<ListingItem> listingItems) {
        this.listingItems = listingItems;
    }

    public Integer getResultsReturned() {
        return resultsReturned;
    }

    public void setResultsReturned(Integer resultsReturned) {
        this.resultsReturned = resultsReturned;
    }

    public Integer getResultsTotal() {
        return resultsTotal;
    }

    public void setResultsTotal(Integer resultsTotal) {
        this.resultsTotal = resultsTotal;
    }
}
