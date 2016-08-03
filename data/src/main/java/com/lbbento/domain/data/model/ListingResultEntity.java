package com.lbbento.domain.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lbbento on 30/07/2016.
 * Represents the mapping to the API Object returned by the SearchEndpoint , ListingResults
 */

public class ListingResultEntity {

    @SerializedName(value="Listings")
    private List<ListingItemEntity> listingItemEntities;

    @SerializedName(value="ResultsReturned")
    private Integer resultsReturned;

    @SerializedName(value="ResultsTotal")
    private Integer resultsTotal;

    public ListingResultEntity(List<ListingItemEntity> listingItemEntities) {
        this.listingItemEntities = listingItemEntities;
    }

    public List<ListingItemEntity> getListingItemEntities() {
        return listingItemEntities;
    }

    public void setListingItemEntities(List<ListingItemEntity> listingItemEntities) {
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
