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

package com.lbbento.domain.domainlisting.mapper;

/**
 * Created by lbbento on 9/08/2016.
 */

import com.lbbento.domain.domain.model.ListingItemModel;
import com.lbbento.domain.domain.model.SearchModel;
import com.lbbento.domain.domainlisting.view.model.ListingItemViewModel;
import com.lbbento.domain.domainlisting.view.model.SearchViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper class used to transform {@link SearchModel} (in the domain layer) to {@link SearchViewModel} in the
 * presentation layer.
 */
public class SearchDataMapper {

    public SearchDataMapper() {}

    public SearchViewModel transform(SearchModel searchModel) {
        SearchViewModel searchViewModel = null;

        if (searchModel != null && searchModel.getListingResultModel() != null) {
            List<ListingItemViewModel> listingItemViewModelList = new ArrayList<>();
            for (ListingItemModel lm : searchModel.getListingResultModel().getListingItemModelEntities() ) {
                ListingItemViewModel listingItemViewModel = new ListingItemViewModel();
                listingItemViewModel.setAdId(lm.getAdId());
                listingItemViewModel.setAgencyLogoUrl(lm.getAgencyLogoUrl());
                listingItemViewModel.setBathrooms(lm.getBathrooms());
                listingItemViewModel.setBedrooms(lm.getBedrooms());
                listingItemViewModel.setCarspaces(lm.getCarspaces());
                listingItemViewModel.setDisplayableAddress(lm.getDisplayableAddress());
                listingItemViewModel.setDisplayPrice(lm.getDisplayPrice());
                listingItemViewModel.setThumbUrl(lm.getThumbUrl());
                listingItemViewModel.setSecondThumbUrl(lm.getSecondThumbUrl());
                listingItemViewModel.setIsElite(lm.isElite());
                listingItemViewModelList.add(listingItemViewModel);
            }

            searchViewModel = new SearchViewModel(listingItemViewModelList);
        }

        return searchViewModel;
    }

}
