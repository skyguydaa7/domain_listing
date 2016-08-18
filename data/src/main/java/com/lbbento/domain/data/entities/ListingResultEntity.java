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
