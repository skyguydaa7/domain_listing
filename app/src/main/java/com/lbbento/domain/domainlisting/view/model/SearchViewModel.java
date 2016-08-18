package com.lbbento.domain.domainlisting.view.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lbbento on 30/07/2016.
 * Represents the List of Results API Object returned by the SearchEndpoint
 */

public class SearchViewModel {

    private List<ListingItemViewModel> listingItemEntities;

    private Integer resultsReturned;

    private Integer resultsTotal;

    public SearchViewModel(List<ListingItemViewModel> listingItemEntities) {
        this.listingItemEntities = listingItemEntities;
    }

    public List<ListingItemViewModel> getListingItemEntities() {
        return listingItemEntities;
    }

    public void setListingItemEntities(List<ListingItemViewModel> listingItemEntities) {
        this.listingItemEntities = listingItemEntities;
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
