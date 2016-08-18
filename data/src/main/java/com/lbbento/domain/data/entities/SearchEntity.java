package com.lbbento.domain.data.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lbbento on 30/07/2016.
 * Represents the List of Results API Object returned by the SearchEndpoint
 */

public class SearchEntity {

    @SerializedName(value="ListingResults")
    private ListingResultEntity listingResultEntity;

    public SearchEntity(ListingResultEntity listingResultEntity) {
        this.listingResultEntity = listingResultEntity;
    }



    public ListingResultEntity getListingResultEntity() {
        return listingResultEntity;
    }

    public void setListingResultEntity(ListingResultEntity listingResultEntity) {
        this.listingResultEntity = listingResultEntity;
    }
}
