package com.lbbento.domain.domain.model;

import java.util.List;

/**
 * Created by lbbento on 30/07/2016.
 * Represents the  ListingResults that belong to a SearchModel
 */

public class ListingResultModel {

    private List<ListingItemModel> listingItemModelList;

    private Integer resultsReturned;

    private Integer resultsTotal;

    public ListingResultModel(List<ListingItemModel> listingItemModelEntities) {
        this.listingItemModelList = listingItemModelEntities;
    }

    public List<ListingItemModel> getListingItemModelEntities() {
        return listingItemModelList;
    }

    public void setListingItemModelEntities(List<ListingItemModel> listingItemModelEntities) {
        this.listingItemModelList = listingItemModelEntities;
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
