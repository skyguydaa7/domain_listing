package com.lbbento.domain.domain.model;

/**
 * Created by lbbento on 30/07/2016.
 * Represents the result of a Search
 */

public class SearchModel {

    private ListingResultModel listingResultModel;

    public SearchModel(ListingResultModel listingResultModel) {
        this.listingResultModel = listingResultModel;
    }

    public ListingResultModel getListingResultModel() {
        return listingResultModel;
    }

    public void setListingResultModel(ListingResultModel listingResultModel) {
        this.listingResultModel = listingResultModel;
    }
}
