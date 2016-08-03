package com.lbbento.domain.domain.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lbbento on 30/07/2016.
 * Represents each Item of the Search Result
 */

public class ListingItemModel {


    private Long adId;
    private String displayPrice;
    private Integer bathrooms;
    private Integer bedrooms;
    private Integer carspaces;
    private String displayableAddress;
    private Integer isElite;
    private String thumbUrl;
    private String secondThumbUrl;
    private List<String> imageUrls;
    private String agencyLogoUrl;


    public Long getAdId() {
        return adId;
    }

    public void setAdId(Long adId) {
        this.adId = adId;
    }

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

    public boolean isElite() {
        return isElite == 1 ? true : false;
    }

    public void setIsElite(boolean elite) {
        isElite = elite ? 1 : 0;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getSecondThumbUrl() {
        return secondThumbUrl;
    }

    public void setSecondThumbUrl(String secondThumbUrl) {
        this.secondThumbUrl = secondThumbUrl;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getAgencyLogoUrl() {
        return agencyLogoUrl;
    }

    public void setAgencyLogoUrl(String agencyLogoUrl) {
        this.agencyLogoUrl = agencyLogoUrl;
    }
}
