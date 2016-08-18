/*
 * Copyright (C) 2016 Lucas Bento Open Source Proj.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lbbento.domain.data.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lbbento on 30/07/2016.
 * Represents each Item inside Listings in API Object returned by the SearchEndpoint.
 */

public class ListingItemEntity {


    @SerializedName(value="AdId")
    private Long adId;

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

    @SerializedName(value="IsElite")
    private Integer isElite;

    @SerializedName(value="RetinaDisplayThumbUrl")
    private String thumbUrl;

    @SerializedName(value="SecondRetinaDisplayThumbUrl")
    private String secondThumbUrl;

    @SerializedName(value="ImageUrls")
    private List<String> imageUrls;

    @SerializedName(value="AgencyLogoUrl")
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
