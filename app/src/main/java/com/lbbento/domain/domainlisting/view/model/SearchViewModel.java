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

package com.lbbento.domain.domainlisting.view.model;

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
