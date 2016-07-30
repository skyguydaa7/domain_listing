package com.lbbento.domain.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lbbento on 30/07/2016.
 * Represents each Item inside Listings in API Object returned by the SearchEndpoint.
 */

public class ListingItem {


  //TODO - What else do I need from here?


    @SerializedName(value="DisplayPrice")
    private String displayPrice;

    @SerializedName(value="Bathrooms")
    private Integer bathrooms;

    @SerializedName(value="Bedrooms")
    private Integer bedrooms;

    @SerializedName(value="Carspaces")
    private Integer carspaces;

    @SerializedName(value="DisplayableAddress")
    private String displayableAddress;




    public String getDisplayPrice() {
        return displayPrice;
    }

    public void setDisplayPrice(String displayPrice) {
        this.displayPrice = displayPrice;
    }


    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getCarspaces() {
        return carspaces;
    }

    public void setCarspaces(Integer carspaces) {
        this.carspaces = carspaces;
    }

    public String getDisplayableAddress() {
        return displayableAddress;
    }

    public void setDisplayableAddress(String displayableAddress) {
        this.displayableAddress = displayableAddress;
    }
}
